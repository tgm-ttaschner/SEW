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

		return applyFilter(getTypeMessage().createMessage());
	}

	public String applyFilter(String message)	{
		for (int i = 0; i < badwords.size(); i++)	{
			if (message.equalsIgnoreCase(badwords.get(i)))	{
				return message.replace(message, "***");
			}
		}
		return message;
	}
}