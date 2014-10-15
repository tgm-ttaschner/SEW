package kapselung.access;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * AccessChild erbt alle Attribute und Methoden von Access und wird um eine Methode erweitert
 */
public class AccessChild extends Access {

	/**
	 * Der Konstruktor
	 */
	public AccessChild() {
		
	}
	
	/**
	 * Gibt "AccessChild: public" in der Konsole aus
	 */
	public void accesspublic()	{
		System.out.println("AccessChild: public");
	}
}