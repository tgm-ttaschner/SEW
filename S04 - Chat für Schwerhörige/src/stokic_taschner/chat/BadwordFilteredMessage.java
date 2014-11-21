package stokic_taschner.chat;

import java.util.*;

/**
 * @author Stefan Stokic
 * @author Thomas Taschner
 * @version 21.11.2014
 * 
 * Diese Klasse nimmt mit Hilfe des Decorator Patterns eine Nachricht entgegen, wandelt sie in Caps Lock Schreibweise um und zensiert aus einer Liste entnommene eventuell vorkommende Schimpfwoerter.
 *
 */
public class BadwordFilteredMessage extends TypeMessage {

	List<String> badwords = new ArrayList<String>();

	/**
	 * @param message die zu ueberpruefende Nachricht
	 * 
	 * Konstruktor, der den Elternkonstruktor aufruft.
	 * Anschlieﬂend werden noch Schimpfwoerter einer Liste hinzugefuegt.
	 */
	public BadwordFilteredMessage(Message message) {

		super(message);

		badwords.add("arsch");
		badwords.add("trottel");
	}

	/* (non-Javadoc)
	 * @see stokic_taschner.chat.TypeMessage#createMessage()
	 * 
	 * Wendet den Filter an die groﬂgeschriebene Nachricht an
	 */
	public String createMessage() {
		return applyFilter(getTypeMessage().createMessage().toUpperCase());
	}

	/**
	 * @param message die zu zensierende Nachricht
	 * @return die zensierte Nachricht
	 * 
	 * Die Nachricht wird in einzelne Woerter zerteilt, eventuell zensiert und wieder zusammengesetzt
	 */
	public String applyFilter(String message)	{

		String s[] = message.split(" ");
		
		message = "";

		for (int i = 0; i < s.length; i++)	{
			for (int j = 0; j < badwords.size(); j++)	{
				if (s[i].equalsIgnoreCase(badwords.get(j)))	{
					s[i] = "$%&*";
				}
			}
			message += s[i] + " ";
		}
		return message;
	}
}