package vererbung;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Objekt A besitzt die Methoden m1 und m2, die den Klassen- und jeweiligen Methodennamen zurückgeben.
 */
public class A {

	/**
	 * Der Konstruktor von A
	 */
	public A()	{
		
	}
	
	/**
	 * @return Gibt den Klassen- und Methodennamen zurück
	 */
	public String m1()	{
		return getClass().getSimpleName() + ": m1";
	}
	
	/**
	 * @return Gibt den Klassen- und Methodennamen zurück
	 */
	public String m2()	{
		return getClass().getSimpleName() + ": m2";
	}
}