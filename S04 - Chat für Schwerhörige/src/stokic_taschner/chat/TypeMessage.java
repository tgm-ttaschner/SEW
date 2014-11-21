package stokic_taschner.chat;

/**
 * Setzt die Art der Nachricht.
 * 
 * @author Stefan Stokic
 * @version 21112014
 */
public abstract class TypeMessage extends Message {

	private Message message;
	
	public TypeMessage(Message message) {
		
		this.setTypeMessage(message);
	}
	
	public void setTypeMessage(Message message) {
		
		this.message = message;
	}
	
	public Message getTypeMessage() {
		
		return this.message;
	}
	
	public abstract String createMessage();
}