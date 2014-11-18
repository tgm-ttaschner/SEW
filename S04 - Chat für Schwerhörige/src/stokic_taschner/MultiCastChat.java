package stokic_taschner;

import java.io.*;
import java.net.*;

public class MultiCastChat {

	private String hostname;
	private int port;
	
	
	public MultiCastChat(String hostname, int port) {
		
		this.hostname = hostname;
		this.port = port;
		
		try {
			
			String msg = "";
			
			
			InetAddress group = InetAddress.getByName(hostname);
			MulticastSocket mSocket = new MulticastSocket(port);
			
			mSocket.joinGroup(group);
			
			Thread chatListenerThread = new Thread(new ChatListener());
			
			chatListenerThread.start();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while(!(msg.equals("QUIT"))) {
				
				msg = in.readLine();
				if(!(msg.equals("QUIT"))) {
					
					DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, port);
					mSocket.send(sendPacket);
				}
			}
			
			mSocket.leaveGroup(group);
			//mSocket.close();
			
		} catch(Exception e) {
			
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private class ChatListener implements Runnable {

		@Override
		public void run() {
			
			try {
				
				InetAddress group = InetAddress.getByName(hostname);
				MulticastSocket mSocket = new MulticastSocket(port);
				
				mSocket.joinGroup(group);
				
				while(true) {
					
					byte[] buf = new byte[256];
					DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
					
					mSocket.receive(receivedPacket);
					
					System.out.println("Received: " + new String(receivedPacket.getData()).trim());
					
					Thread.sleep(20);
					//mSocket.close();
				}
				
			}catch(Exception e) {
				
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new MultiCastChat("224.1.2.3", 8888);
	}
}