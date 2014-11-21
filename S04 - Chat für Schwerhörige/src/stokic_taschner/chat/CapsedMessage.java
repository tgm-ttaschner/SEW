package stokic_taschner.chat;

/**
 * @author Stefan Stokic
 * @version 21.11.2014
 * 
 * Diese Klasse nimmt mit Hilfe des Decorator Patterns eine Nachricht entgegen und wandelt sie in Caps Lock Schreibweise um.
 *
 */
public class CapsedMessage extends TypeMessage {

	/**
	 * @param message die zu veraendernde Nachricht
	 * 
	 * Konstruktor, der den Elternkonstruktor aufruft.
	 */
	public CapsedMessage(Message message) {
		
		super(message);
	}
	
	/* (non-Javadoc)
	 * @see stokic_taschner.chat.TypeMessage#createMessage()
	 * 
	 * Gibt eine Nachricht in Caps Lock Schreibweise zurueck
	 */
	public String createMessage() {
		
		return capsMessage(getTypeMessage().createMessage());
	}
	
	
	/**
	 * @param message die urspruengliche Nachricht
	 * @return die Nachricht in Caps Lock Schreibweise
	 */
	public String capsMessage(String message) {
		return message.toUpperCase();
	}
}