package stokic_taschner.chat;

/**
 * @author Stefan Stokic
 * 
 * Abstrakte Message Klasse mit einer Getter- und Setter-Methode der zu sendenden Nachricht
 *
 */
public abstract class Message {

	private String message;
	
	/**
	 * @param message die zu sendende Nachricht
	 */
	public void setMessage(String message) {
		this.message =  message;
	}
	
	/**
	 * @return die zu sendende Nachricht
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * @return die zu sendende Nachricht
	 */
	public abstract String createMessage();
}