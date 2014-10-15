package polymorphie.universell.laufzeit;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Eine Demonstration der Laufzeitpolymorphie
 */
public class Laufzeit_Main {

	/**
	 * @param args Argument von Main
	 */
	public static void main(String[] args) {
		/**
		 * Hier wird als Ausgabe "A" erwartet
		 */
		A a = new A();
		a.p(123);
		
		/**
		 * Hier wird als Ausgabe "B" erwartet
		 */
		a = new B();
		a.p(123);
		
		/**
		 * a.p(123); legt in diesem Fall nicht fest, welche Methode sich hinter dem Namen p verbirgt, dies wird vielmehr vom dynamischen Typ von a abh‰ngig gemacht!
		 * Gew‰hlt wird dynamisch die Methode des Objekttyps, nicht statisch die des Variablentyps. Man spricht daher auch von dynamischem Binden.
		 * Die Methode p ist sozusagen Ñvielgestaltigì, polymorph.
		 * Diese Art der an die Vererbung (oder auch an die Implementierung einer Schnittstelle!) gebundene Polymorphie heiﬂt auch Einschlusspolymorphie oder Inklusionspolymorphie.
		 */
	}
}