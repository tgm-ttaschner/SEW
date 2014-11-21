package stokic_taschner.chat;

/**
 * Setzt die Art der Nachricht.
 * 
 * @author Stefan Stokic
 * @version 21112014
 */
public abstract class TypeMessage extends Message {

	private Message message;
	
	/**
	 * @param message die Nachricht, die gesendet werden soll
	 * 
	 * Konstruktor, der die eigene Setter-Methode aufruft
	 */
	public TypeMessage(Message message) {
		
		this.setTypeMessage(message);
	}
	
	/**
	 * @param message die Nachricht, die gesendet werden soll
	 */
	public void setTypeMessage(Message message) {
		
		this.message = message;
	}
	
	/**
	 * @return die Nachricht, die gesendet werden soll
	 */
	public Message getTypeMessage() {
		
		return this.message;
	}
	
	/* (non-Javadoc)
	 * @see stokic_taschner.chat.Message#createMessage()
	 * 
	 * Gibt die zu sendende Nachricht zurueck
	 */
	public abstract String createMessage();
}