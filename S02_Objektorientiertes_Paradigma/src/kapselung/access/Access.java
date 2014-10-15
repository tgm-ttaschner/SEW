package kapselung.access;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * In Java gibt es zusätzlich noch die Möglichkeit mit Hilfe von sogenannten Modifizierern (Access Modifiers) den Zugriff von außen noch weiter einzuschränken.
 * So ein Access Modifier lässt sich auf jede Klasse, Methode und Attribut anwenden.
 * Nicht alle Access Modifier haben überall Sinn.
 * Beispielsweise wären private Getter- und Setter-Methoden oder ein solch ein Konstruktor völlig sinnlos.
 * Folgende Access Modifier in immer einschränkender werdender Reihenfolge gibt es:
 */

public class Access {
	
	/**
	 * Der Konstruktor
	 */
	public Access()	{
		
	}
	
	/**
	 * public - Überall sichtbar
	 */
	
	/**
	 * Gibt "Access: öffentlich" in der Konsole aus
	 */
	public void oeffentlich()	{
		System.out.println("Access: öffentlich");
	}
	
	/**
	 * protected - Nur im eigenen Package und Subklassen (Klassen, die von dieser Klasse erben) sichtbar
	 */
	
	/**
	 * Gibt "Access: geschützt" in der Konsole aus
	 */
	protected void geschuetzt()	{
		System.out.println("Access: geschützt");
	}
	
	/**
	 * default (wenn nichts angegeben wurde) - Nur im eigenen Package sichtbar
	 */
	
	/**
	 * Gibt "Access: standard" in der Konsole aus
	 */
	void standard()	{
		System.out.println("Access: standard");
	}
	
	/**
	 * private - Nur in der eigenen Klasse sichtbar
	 */
	
	/**
	 * Gibt "Access: privat" in der Konsole aus
	 */
	@SuppressWarnings("unused")
	private void privat()	{
		System.out.println("Access: privat");
	}
	
	/**
	 * Man beachte außerdem, dass die Zugriffsrechte nur weiter eingeschränkt, aber nicht erweitert werden können.
	 */
}