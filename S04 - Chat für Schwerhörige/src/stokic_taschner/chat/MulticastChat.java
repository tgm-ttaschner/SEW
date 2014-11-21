package stokic_taschner.chat;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Stefan Stokic
 * @author Thomas Taschner
 * @version 18112014
 * 
 * Dieses Programm soll einen Chatclient repräsentieren, der die Nachrichten der einzelnen Teilnehmen in CAPS LOCK Schreibweise (Großbuchstaben) an alle anderen Chatteilnehmer schickt.
 * Zusätzlich werden noch der Benutzername, ein Timestamp mitgeschickt und eventuell vorkommende Schimpfwörter durch * zensiert.
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
	
	/**
	 * @return der Benutzername, der bei der Anmeldung verwendet werden soll
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username der Benutzername, der bei der Anmeldung verwendet wurde
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return der Name des Hosts, auf dem der MulticastSocket laufen soll
	 */
	public String getHostname() {
		return hostname;
	}
	
	/**
	 * @param hostname der Name des Hosts, auf dem der MulticastSocket laeuft
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return der Port, auf dem der Socket laufen soll
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * @param port der Port, auf dem der Socket laeuft
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return die Nachricht, die verschickt werden soll
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg die Nachricht, die verschickt werden soll
	 * 
	 * Die Nachricht wird mit weiteren Informationen erweitert
	 */
	public void createMsg(String msg) {
		this.msg = getUsername() + ", um " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + " Uhr: " + msg;
	}

	/**
	 * @return die Adresse der Multicastgruppe, in der sich der Socket befindet
	 */
	public InetAddress getGroup() {
		return group;
	}

	/**
	 * @param group die Adresse der Multicastgruppe, in der sich der Socket befinden soll
	 */
	public void setGroup(InetAddress group) {
		this.group = group;
	}

	

	/**
	 * Das Paket wird mit Daten befuellt und anschließend verschickt
	 */
	public void send() {

		DatagramPacket sendPacket = new DatagramPacket(this.getMsg().getBytes(), this.getMsg().length(), this.getGroup(), this.getPort());
		
		try {
			// Senden der Nachricht
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
			group = InetAddress.getByName(this.getHostname());

			// MulticastSocket an angegebenem Port wird erstellt
			mSocket = new MulticastSocket(this.getPort());

			// Socket wird einer Multicastgruppe hinzugefügt
			mSocket.joinGroup(group);

			// Neuer ChatListener Thread wird erstellt und ausgeführt
			Thread chatListenerThread = new Thread(new ChatListener(this.getHostname(), this.getPort()));

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

	/**
	 * @return eine Instanz von MulticastChat
	 */
	public static MulticastChat getInstance() {

		if(instanceMulticastChat == null)
			instanceMulticastChat = new MulticastChat();

		return instanceMulticastChat;
	}

	/**
	 * Der Socket verlaesst die Multicastgruppe und wird abschließend geschlossen.
	 */
	public void multicastLeaveGroup() {

		try {
			
			mSocket.leaveGroup(group);
			mSocket.close();
			
		} catch (IOException e) {

			// Ausgabe der Fehlermeldung
			System.out.println("Error: " + e.getMessage());
		} catch (NullPointerException ex)	{
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	/**
	 * @param ip die zu ueberpruefende IP-Adresse
	 * @return true oder false, je nachdem, ob der Input einer gueltigen IP-Adresse entspricht
	 * 
	 * Entnommen von http://stackoverflow.com/questions/4581877/validating-ipv4-string-in-java, Antwort Nr. 2
	 * 
	 * Die Methode ueberprueft mit Hilfe von Regex, ob die mitgegebene Zeichenkette einer gueltigen IP-Adresse entspricht.
	 * Zunaechst erfolgt eine Ueberpruefung, ob der Input nicht leer ist und 4 Zahlen, jeweils getrennt mit einem Punkt, zwischen 0 und 255, enthaelt.
	 */
	public static boolean validIP (String ip) {
	    try {
	    	
	    	// Check, ob String leer oder nicht
	        if (ip == null || ip.isEmpty()) {
	            return false;
	        }
	        
	        // Vierteilung des Strings
	        String[] parts = ip.split("\\.", -1);
	        if ( parts.length != 4 ) {
	            return false;
	        }
	        
	        // Check, ob Zahlen zwischen 0 und 255 vorhanden sind
	        for ( String s : parts ) {
	            int i = Integer.parseInt( s );
	            if ( (i < 0) || (i > 255) ) {
	                return false;
	            }
	        }

	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
}