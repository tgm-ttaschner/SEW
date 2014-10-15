package polymorphie.universell.generics;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * In dieser Klasse wird ein Wert gespeichert, der �ber den Konstruktor �bergeben wird.
 * Dieser Wert kann mit Hilfe von einer Getter- und Setter-Methode ausgelesen und ver�ndert werden.
 */
public class WrapperString {
	
	private String value;
	
	/**
	 * @param t Der dem Konstruktor mitzugebende String
	 * Der Konstruktor
	 */
	public WrapperString(String t)	{
		this.value = t;
	}
	
	/**
	 * @return Der Wert des Strings
	 */
	public String getValue()	{
		return value;
	}
	
	/**
	 * @param value Der Wert des Strings
	 */
	public void setValue(String value)	{
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Gibt den Wert des Strings zur�ck
	 */
	@Override
	public String toString()	{
		return "" + getValue();
	}
}