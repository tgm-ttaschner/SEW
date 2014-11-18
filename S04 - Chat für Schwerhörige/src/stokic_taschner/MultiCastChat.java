package stokic_taschner;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Stefan Stokic
 * @date 18112014
 * 
 * Dieses Programm soll einen Chatclient repräsentieren, der die Nachrichten der einzelnen Teilnehmen in CAPS LOCK Schreibweise (Großbuchstaben) an alle anderen Chatteilnehmer schickt.
 * Zusätzlich werden noch die Benutzername, ein Timestamp mitgeschickt und eventuell vorkommende Schimpfwörter durch * zensiert.
 *
 */
public class MultiCastChat {

	private String username;
	private String hostname;
	private int port;
	
	String msg = "";

	/**
	 * @param username der Benutzername, der beim Versenden der Nachrichten im Chat angezeigt werden soll
	 * @param hostname die Adresse des Multicastnetzes, an dem der Socket erstellt werden soll
	 * @param port der Port, an dem der Socket erstellt werden soll
	 */
	public MultiCastChat(String username, String hostname, int port) {

		this.username = username;
		this.hostname = hostname;
		this.port = port;

		try {
			
			// IP-Adresse wird gespeichert
			InetAddress group = InetAddress.getByName(hostname);
			
			// MulticastSocket an angegebenem Port wird erstellt
			MulticastSocket mSocket = new MulticastSocket(port);
			
			// Socket wird einer Multicastgruppe hinzugefügt
			mSocket.joinGroup(group);
			
			// Neuer ChatListener Thread wird erstellt und ausgeführt
			Thread chatListenerThread = new Thread(new ChatListener());

			chatListenerThread.start();
			
			// Konsoleninput wird gespeichert
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			// Wiederhole, solange nicht 'QUIT' eingegeben wird
			while(!(msg.equals("QUIT"))) {
				
				// Als Nachricht werden Benutzername: Nachricht gespeichert
				msg = username + ": " + in.readLine();
				
				// Sollte die Nachricht 'QUIT' entsprechen, so wird das Programm terminiert, andernfalls wird die Nachricht in ein Paket verpackt und an gegebene Adresse geschickt.
				if(!(msg.equals("QUIT"))) {
					
					// Verpacken und adressieren der Nachricht
					DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, port);
					
					// Senden der Nachricht
					mSocket.send(sendPacket);
				} else {
					System.exit(0);
				}
			}
			
			// Socket verlässt die Multicastgruppe
			mSocket.leaveGroup(group);
			
			/**
			 * Mit close gibts noch Probleme...
			 */
			//mSocket.close();

		} catch(Exception e) {
			
			// Ausgabe der Fehlermeldung
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @author Stefan Stokic
	 * @date 18112014
	 * 
	 * Dieses Programm soll einen Chatclient repräsentieren, der die Nachrichten der einzelnen Teilnehmen in CAPS LOCK Schreibweise (Großbuchstaben) an alle anderen Chatteilnehmer schickt.
	 * Zusätzlich werden noch die Benutzername, ein Timestamp mitgeschickt und eventuell vorkommende Schimpfwörter durch * zensiert.
	 *
	 */
	private class ChatListener implements Runnable {

		@Override
		public void run() {

			try {
				
				// IP-Adresse wird gespeichert
				InetAddress group = InetAddress.getByName(hostname);
				
				// MulticastSocket an angegebenem Port wird erstellt
				MulticastSocket mSocket = new MulticastSocket(port);
				
				// Socket wird einer Multicastgruppe hinzugefügt
				mSocket.joinGroup(group);
				
				// Wiederhole unendlich lange
				while(true) {
					
					// Array, in dem die zu empfangende Nachricht gespeichert werden soll, wird initialisiert
					byte[] buf = new byte[256];
					
					// Vorbereiten des Packets für die zu empfangende Nachricht
					DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
					
					// Nachrichtenpaket wird empfangen
					mSocket.receive(receivedPacket);
					
					// Empfangene Nachricht wird mit vorne und hinten entfernten Leerzeichen ausgegeben
					System.out.println(new String(receivedPacket.getData()).trim());
					
					// Thread schläft für 20 Millisekunden
					Thread.sleep(20);
					
					/**
					 * Auch hier gibts mit close() noch Probleme...
					 */
					//mSocket.close();
				}

			} catch(Exception e) {
				
				// Fehlermeldung wird ausgegeben
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	/**
	 * @param args Argumente für Main
	 */
	public static void main(String[] args) {
		
		// Für 1. Tests wird für den Benutzernamen einfach das aktuelle Datum und die Uhrzeit genommen, da es ja keinerlei String.random(size) Methoden von Haus aus gibt.
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");

		new MultiCastChat(dateFormat.format(new Date()), "224.1.2.3", 8888);
	}
}