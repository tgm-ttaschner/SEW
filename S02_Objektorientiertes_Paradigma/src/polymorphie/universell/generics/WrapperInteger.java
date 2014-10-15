package polymorphie.universell.generics;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * In dieser Klasse wird ein Wert gespeichert, der �ber den Konstruktor �bergeben wird.
 * Dieser Wert kann mit Hilfe von einer Getter- und Setter-Methode ausgelesen und ver�ndert werden.
 */
public class WrapperInteger {
	
	private Integer value;
	
	/**
	 * @param t Der dem Konstruktor mitzugebende Integer
	 * Der Konstruktor
	 */
	public WrapperInteger(Integer t)	{
		this.value = t;
	}
	
	/**
	 * @return Der Wert des Integers
	 */
	public Integer getValue()	{
		return value;
	}
	
	/**
	 * @param value Der Wert des Integers
	 */
	public void setValue(Integer value)	{
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Gibt den Wert des Integers zur�ck
	 */
	@Override
	public String toString()	{
		return "" + getValue();
	}
}