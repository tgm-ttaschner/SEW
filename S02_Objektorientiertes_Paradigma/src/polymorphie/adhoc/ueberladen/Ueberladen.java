package polymorphie.adhoc.ueberladen;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Eine Methode ist gekennzeichnet durch R�ckgabewert, Name, Parameter und unter Umst�nden durch Ausnahmefehler, die sie ausl�sen kann.
 * Ein wichtiger Begriff in diesem Zusammenhang ist die Signatur einer Methode.
 * Die Signatur einer Methode ist der Name der Methode und die Typen in ihrer Parameterliste:
 * 
 * Der R�ckgabetyp ist kein Bestandteil der Signatur.
 * Die Namen der Parameter spielen keine Rolle, nur die Typen und ihre Reihenfolge!
 * 
 * Java erlaubt es, den Namen der Methode gleich zu lassen, aber andere Parameter einzusetzen.
 * Eine �berladene Methode ist eine Methode mit dem gleichen Namen wie eine andere Methode, unterscheidet sich aber durch eine unterschiedliche Parameterliste.
 * Das ist auf zwei Arten m�glich:
 *  -- Eine Methode hat f�r den Compiler unterscheidbare Typen
 *  -- Eine Methode akzeptiert eine unterschiedliche Anzahl von Parametern
 * 
 * Im folgenden Beispiel werden Methoden erstellt, die �ber die Methode mitgegebene Werte in zusammengez�hlter Form wieder zur�ckgeben
 * 
 */
public class Ueberladen {
	
	/**
	 * @param a Der 1. Wert, der addiert werden soll
	 * @param b Der 2. Wert, der addiert werden soll
	 * @return Die beiden addierten Werte
	 */
	public static long add(int a, int b)	{
		return a+b;
	}
	
	/**
	 * @param a Der 1. Wert, der addiert werden soll
	 * @param b Der 2. Wert, der addiert werden soll
	 * @param c Der 3. Wert, der addiert werden soll
	 * @return Die drei addierten Werte
	 */
	public static long add(int a, int b, int c)	{
		return a+b+c;
	}
	
	/**
	 * @param a Der 1. Wert, der addiert werden soll
	 * @param b Der 2. Wert, der addiert werden soll
	 * @return Die beiden addierten Werte
	 */
	public static long add(long a, long b)	{
		return a+b;
	}
	
	/**
	 * @param a Der 1. Wert, der addiert werden soll
	 * @param b Der 2. Wert, der addiert werden soll
	 * @return Die beiden addierten Werte
	 */
	public static long add(int a, short b)	{
		return a+b;
	}
	
	/**
	 * @param a Das Array, das die zu addierenden Werte enth�lt
	 * @return Alle aus dem Array zusammenaddierten Werte
	 */
	public static long add(int[] a)	{
		long l = 0;
		for (int i = 0; i < a.length; i++)	{
			l = l + a[i];
		}
		return l;
		
		/**
		 * Wichtig ist, dass sich die Methoden nicht nur durch den Datentyp des R�ckgabewertes unterscheiden
		 */
	}
}
