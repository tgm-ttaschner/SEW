package stokic_taschner.chat;

import java.util.*;

public class BadwordFilteredMessage extends TypeMessage {

	List<String> badwords = new ArrayList<String>();

	public BadwordFilteredMessage(Message message) {

		super(message);

		badwords.add("arsch");
		badwords.add("trottel");
	}

	public String createMessage() {

		return applyFilter(getTypeMessage().createMessage().toUpperCase());
	}

	public String applyFilter(String message)	{
		for (int i = 0; i < badwords.size(); i++)	{
			if (message.equalsIgnoreCase(badwords.get(i)))	{
				return message.replace(message, this.charCount(message.length()));
			}
		}
		return message;
	}

	public String charCount(int length)	{
		String s = "";
		for (int i = 0; i < length; i++)	{
			s += "*";
		}
		return s;
	}
}