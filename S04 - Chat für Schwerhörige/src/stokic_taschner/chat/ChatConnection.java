package stokic_taschner.chat;

/**
 * Ein Interface fuer den MulticastChat. Beinhaltet das Vorbereiten der MulticastConnection(username, 
 * hostname, port) und das Starten des MulticastChats.
 * 
 * @author Stefan Stokic
 * @version 19112014
 */
public interface ChatConnection {

	/**
	 * @param username der Benutzername, der bei der Anmeldung verwendet werden soll
	 * @param hostname der Name des Hosts, auf dem der MulticastSocket laufen soll
	 * @param port der Port, auf dem der Socket laufen soll
	 * 
	 * Dient zum Herstellen der Verbindung zum Socket.
	 */
	public void setupChatConnection(String username, String hostname, int port);
	
	/**
	 * Dient zum Starten des MulticastChats
	 */
	public void startChat();
}