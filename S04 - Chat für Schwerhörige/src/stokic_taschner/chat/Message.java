package stokic_taschner.chat;

public abstract class Message {

	private String message;
	
	public void setMessage(String message) {

		this.message =  message;
	}
	
	public String getMessage() {
		
		return this.message;
	}
	
	public abstract String createMessage();
}