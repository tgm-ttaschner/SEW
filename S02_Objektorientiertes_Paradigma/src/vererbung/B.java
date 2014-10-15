package vererbung;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Objekt B besitzt die vererbten Methoden m1 und m2 und die eigene Methode m3 , die den jeweiligen Klassen- und Methodennamen zurückgeben.
 *  -- B kann alles, was auch A kann und sogar noch mehr
 */
public class B extends A	{

	/**
	 * Der Konstruktor von B
	 */
	public B()	{
		
	}
	
	/**
	 * @return Gibt den Klassen- und Methodennamen zurück
	 */
	public String m3()	{
		return getClass().getSimpleName() + ": m3";
	}
}