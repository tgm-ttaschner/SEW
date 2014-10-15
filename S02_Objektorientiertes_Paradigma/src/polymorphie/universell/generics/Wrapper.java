package polymorphie.universell.generics;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * In dieser Klasse wird ein Wert gespeichert, der über den Konstruktor übergeben wird.
 * Dieser Wert kann mit Hilfe von einer Getter- und Setter-Methode ausgelesen und verändert werden.
 * Da sich in den Klassen WrapperString, WrapperInteger und WrapperDouble nur der Datentyp des Wertes value voneinander unterscheiden, wird hier mit einem generischen Datentypen gearbeitet.
 * Die Klasse wird so multifunktional.
 */
public class Wrapper<T> {
	
	private T value;
	
	/**
	 * @param t Der dem Konstruktor mitzugebende generische Datentyp
	 * Der Konstruktor
	 */
	public Wrapper(T t)	{
		this.value = t;
	}
	
	/**
	 * @return Der Wert des generischen Datentyps
	 */
	public T getValue()	{
		return value;
	}
	
	/**
	 * @param value Der Wert des generischen Datentyps
	 */
	public void setValue(T value)	{
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Gibt den Wert des generischen Datentyps zurück
	 */
	@Override
	public String toString()	{
		return "" + getValue();
	}
}