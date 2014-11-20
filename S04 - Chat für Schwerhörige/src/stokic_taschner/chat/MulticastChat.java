package stokic_taschner.chat;

import java.io.*;
import java.net.*;

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

	private InetAddress group;
	private MulticastSocket mSocket;

	private static MulticastChat instanceMulticastChat = null;

	protected MulticastChat() {}

	/**
	 * @param username der Benutzername, der beim Versenden der Nachrichten im Chat angezeigt werden soll
	 * @param hostname die Adresse des Multicastnetzes, an dem der Socket erstellt werden soll
	 * @param port der Port, an dem der Socket erstellt werden soll
	 */
	public MulticastChat(String username, String hostname, int port) {

		instanceMulticastChat = this;

		this.username = username;
		this.hostname = hostname;
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private String getMsg() {
		return this.msg;
	}

	public void createMsg(String msg) {

		this.msg = username + ": " + msg;
	}

	public void send() {

		DatagramPacket sendPacket = new DatagramPacket(this.getMsg().getBytes(), this.getMsg().length(), group, this.port);

		// Senden der Nachricht
		try {

			mSocket.send(sendPacket);

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}
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
			group = InetAddress.getByName(this.hostname);

			// MulticastSocket an angegebenem Port wird erstellt
			mSocket = new MulticastSocket(this.port);

			// Socket wird einer Multicastgruppe hinzugefügt
			mSocket.joinGroup(group);

			// Neuer ChatListener Thread wird erstellt und ausgeführt
			Thread chatListenerThread = new Thread(new ChatListener(this.hostname, this.port));

			chatListenerThread.start();

			// Wenn fenster geschlossen sollte dies aufgerufen werden
			// Socket verlässt die Multicastgruppe
			// mSocket.leaveGroup(group);

			/**
			 * Mit close gibts noch Probleme...
			 */
			//mSocket.close();

		} catch(Exception e) {

			// Ausgabe der Fehlermeldung
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static MulticastChat getInstance() {

		if(instanceMulticastChat == null)
			instanceMulticastChat = new MulticastChat();

		return instanceMulticastChat;
	}

	public void multicastLeaveGroup() {

		try {
			
			mSocket.leaveGroup(group);
			mSocket.close();
			
		} catch (IOException e) {

			// Ausgabe der Fehlermeldung
			System.out.println("Error: " + e.getMessage());
		}
	}
}