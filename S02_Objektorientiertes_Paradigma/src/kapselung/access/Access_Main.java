package kapselung.access;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Hier wird der Gültigkeitsbereich der in Java verfügbaren Access Modifier demonstriert
 */
public class Access_Main {

	public static void main(String[] args) {
		
		Access a = new Access();
		
		a.oeffentlich();
		a.geschuetzt();
		a.standard();
		System.out.println();
		
		/**
		 * In dieser Klasse nicht sichtbar
		 */
		//a.privat();
		
		/**
		 * AccessChild besitzt nun alle Fähigkeiten, die Access, das Elternklasse, auch besitzt und wurde um eine weitere Methode erweitert.
		 */
		AccessChild ac = new AccessChild();
		
		ac.oeffentlich();
		ac.geschuetzt();
		ac.standard();
		
		/**
		 * In dieser Klasse ebenfalls nicht sichtbar
		 */
		//ac.privat();
		
		ac.accesspublic();
	}
}