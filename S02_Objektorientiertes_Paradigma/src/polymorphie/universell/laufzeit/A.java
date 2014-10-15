package polymorphie.universell.laufzeit;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Klasse A besitzt zwei Methoden, die den jeweiligen Eingabeparameter ausgeben, während die dritte Methode einfach nur A ausgibt.
 */
public class A {
	
	/**
	 * @param s Ein mitzugebender String
	 */
	public static void print(String s) { 
		System.out.println(s);
	}

	/**
	 * @param a Ein mitzugebender Character
	 */
	public void p(char a) {
		System.out.println("" + 'a');
	}
	
	/**
	 * @param a Eine mitzugebende Zahl
	 */
	public void p(int a) {
		System.out.println("A");
	}
}
