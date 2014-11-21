package stokic_taschner.chat;

public class CapsedMessage extends TypeMessage {

	public CapsedMessage(Message message) {
		
		super(message);
	}
	
	public String createMessage() {
		
		return capsMessage(getTypeMessage().createMessage());
	}
	
	public String capsMessage(String message) {
		
		return message.toUpperCase();
	}
}