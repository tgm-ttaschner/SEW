package stokic_taschner.chat;

/**
 * @author Stefan Stokic
 * @version 21.11.2014
 * 
 * Diese Klasse ruft den Konstruktor in Message auf.
 *
 */
public class ChatMessage extends Message {

	/* (non-Javadoc)
	 * @see stokic_taschner.chat.Message#createMessage()
	 * 
	 * Ruft die Getter-Methode von Message auf und gibt die zu sendende Nachricht zurück
	 */
	@Override
	public String createMessage() {
		return super.getMessage();
	}
}