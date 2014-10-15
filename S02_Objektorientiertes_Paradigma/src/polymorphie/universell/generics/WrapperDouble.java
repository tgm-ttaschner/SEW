package polymorphie.universell.generics;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * In dieser Klasse wird ein Wert gespeichert, der über den Konstruktor übergeben wird.
 * Dieser Wert kann mit Hilfe von einer Getter- und Setter-Methode ausgelesen und verändert werden.
 */
public class WrapperDouble {
	
	private Double value;
	
	/**
	 * @param t Der dem Konstruktor mitzugebende Double
	 * Der Konstruktor
	 */
	public WrapperDouble(Double t)	{
		this.value = t;
	}
	
	/**
	 * @return Der Wert des Doubles
	 */
	public Double getValue()	{
		return value;
	}
	
	/**
	 * @param value Der Wert des Doubles
	 */
	public void setValue(Double value)	{
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Gibt den Wert des Doubles zurück
	 */
	@Override
	public String toString()	{
		return "" + getValue();
	}
}