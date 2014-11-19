package stokic_taschner.chat;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Eine Thread Klasse welche auf Nachrichten wartet und dementsprechend empfaengt und ausgibt.
 * 
 * @author Stefan Stokic
 * @version 19112014
 */
public class ChatListener implements Runnable {

	private String hostname;
	private int port;
	
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