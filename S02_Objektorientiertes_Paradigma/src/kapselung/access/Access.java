package kapselung.access;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * In Java gibt es zus�tzlich noch die M�glichkeit mit Hilfe von sogenannten Modifizierern (Access Modifiers) den Zugriff von au�en noch weiter einzuschr�nken.
 * So ein Access Modifier l�sst sich auf jede Klasse, Methode und Attribut anwenden.
 * Nicht alle Access Modifier haben �berall Sinn.
 * Beispielsweise w�ren private Getter- und Setter-Methoden oder ein solch ein Konstruktor v�llig sinnlos.
 * Folgende Access Modifier in immer einschr�nkender werdender Reihenfolge gibt es:
 */

public class Access {
	
	/**
	 * Der Konstruktor
	 */
	public Access()	{
		
	}
	
	/**
	 * public - �berall sichtbar
	 */
	
	/**
	 * Gibt "Access: �ffentlich" in der Konsole aus
	 */
	public void oeffentlich()	{
		System.out.println("Access: �ffentlich");
	}
	
	/**
	 * protected - Nur im eigenen Package und Subklassen (Klassen, die von dieser Klasse erben) sichtbar
	 */
	
	/**
	 * Gibt "Access: gesch�tzt" in der Konsole aus
	 */
	protected void geschuetzt()	{
		System.out.println("Access: gesch�tzt");
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
	 * Man beachte au�erdem, dass die Zugriffsrechte nur weiter eingeschr�nkt, aber nicht erweitert werden k�nnen.
	 */
}