package stokic_taschner.chat;

/**
 * Ein Interface fuer den MulticastChat. Beinhaltet das vorbereiten der MulticastConnection(username, 
 * hostname, port) und das Starten des MulticastChats.
 * 
 * @author Stefan Stokic
 * @version 19112014
 */
public interface ChatConnection {

	public void setupChatConnection(String username, String hostname, int port);
	public void startChat();
}