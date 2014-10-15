package vererbung;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Objekt C besitzt die vererbten Methoden m1, m2, m3 und die eigene Methode m4, die den jeweiligen Klassen- und Methodennamen zur�ckgeben.
 *  -- C kann alles, was auch A und B k�nnen und sogar noch mehr
 */
public class C extends B	{
	
	/**
	 * Der Konstruktor von C
	 */
	public C()	{
		
	}
	
	/**
	 * @return Gibt den Klassen- und Methodennamen zur�ck
	 */
	public String m4()	{
		return getClass().getSimpleName() + ": m4";
	}
}