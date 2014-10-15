package polymorphie.universell.laufzeit;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Klasse B erbt von und besitzt daher zwei Methoden, die den jeweiligen Eingabeparameter ausgeben.
 * Die dritte Methode gibt hier nicht A, sondern B aus, da diese Methode hier überschrieben wird.
 * Entschieden wird dies jedoch erst während der Laufzeit.
 * 
 */
public class B extends A {
	/* (non-Javadoc)
	 * @see polymorphie.universell.laufzeit.A#p(int)
	 */
	
	public void p(int b) {
		print("B");
	}
}