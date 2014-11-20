package stokic_taschner.chat;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import stokic_taschner.gui.MultiCastChatClient;

/**
 * Eine Thread Klasse welche auf Nachrichten wartet und dementsprechend empfaengt und ausgibt.
 * 
 * @author Stefan Stokic
 * @version 19112014
 */
public class ChatListener implements Runnable {

	private String hostname;
	private int port;
	private DatagramPacket receivedPacket;
	private MulticastSocket mSocket;
	
	/**
	 * @param hostname der Name des Hosts, auf dem der MulticastSocket laufen soll
	 * @param port der Port, auf dem der Socket laufen soll
	 */
	public ChatListener(String hostname, int port) {
		
		this.hostname = hostname;
		this.port = port;
	}
	
	@Override
	public void run() {

		try {

			// IP-Adresse wird gespeichert
			InetAddress group = InetAddress.getByName(hostname);

			// MulticastSocket an angegebenem Port wird erstellt
			mSocket = new MulticastSocket(port);

			// Socket wird einer Multicastgruppe hinzugefuegt
			mSocket.joinGroup(group);

			// Wiederhole unendlich lange
			while(true) {

				// Array, in dem die zu empfangende Nachricht gespeichert werden soll, wird initialisiert
				byte[] buf = new byte[256];

				// Vorbereiten des Pakets fuer die zu empfangende Nachricht
				receivedPacket = new DatagramPacket(buf, buf.length);

				// Nachrichtenpaket wird empfangen
				mSocket.receive(receivedPacket);

				// Empfangene Nachricht wird mit vorne und hinten entfernten Leerzeichen ausgegeben
				MultiCastChatClient.getInstance().getTa_output().append(new String(receivedPacket.getData()).trim() + "\n");
				
				// Thread schlaeft fuer 20 Millisekunden
				Thread.sleep(20);
			}

		} catch(Exception e) {

			// Fehlermeldung wird ausgegeben
			System.out.println("Error: " + e.getMessage());
		}
	}
}