package stokic_taschner.chat;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

/**
 * @author Stefan Stokic
 * @version 18112014
 * 
 * Dieses Programm soll einen Chatclient repräsentieren, der die Nachrichten der einzelnen Teilnehmen in CAPS LOCK Schreibweise (Großbuchstaben) an alle anderen Chatteilnehmer schickt.
 * Zusätzlich werden noch die Benutzername, ein Timestamp mitgeschickt und eventuell vorkommende Schimpfwörter durch * zensiert.
 *
 */
public class MulticastChat implements ChatConnection {

	private String username;
	private String hostname;
	private int port;
	private String msg = "";

	/**
	 * @param username der Benutzername, der beim Versenden der Nachrichten im Chat angezeigt werden soll
	 * @param hostname die Adresse des Multicastnetzes, an dem der Socket erstellt werden soll
	 * @param port der Port, an dem der Socket erstellt werden soll
	 */
	public MulticastChat(String username, String hostname, int port) {

		this.username = username;
		this.hostname = hostname;
		this.port = port;
	}

	/**
	 * @param username der Benutzername, der beim Versenden der Nachrichten im Chat angezeigt werden soll
	 * @param hostname die Adresse des Multicastnetzes, an dem der Socket erstellt werden soll
	 * @param port der Port, an dem der Socket erstellt werden soll
	 */
	@Override
	public void setupChatConnection(String username, String hostname, int port) {

		this.username = username;
		this.hostname = hostname;
		this.port = port;
	}

	@Override
	public void startChat() {

		try {

			// IP-Adresse wird gespeichert
			InetAddress group = InetAddress.getByName(this.hostname);

			// MulticastSocket an angegebenem Port wird erstellt
			MulticastSocket mSocket = new MulticastSocket(this.port);

			// Socket wird einer Multicastgruppe hinzugefügt
			mSocket.joinGroup(group);

			// Neuer ChatListener Thread wird erstellt und ausgeführt
			Thread chatListenerThread = new Thread(new ChatListener(this.hostname, this.port));

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
					DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, this.port);

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
	 * @param args Argumente für Main
	 */
	public static void main(String[] args) {

		// Für 1. Tests wird für den Benutzernamen einfach das aktuelle Datum und die Uhrzeit genommen, da es ja keinerlei String.random(size) Methoden von Haus aus gibt.
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");

		MulticastChat chat = new MulticastChat(dateFormat.format(new Date()), "224.1.2.3", 8888);
		chat.startChat();
	}
}