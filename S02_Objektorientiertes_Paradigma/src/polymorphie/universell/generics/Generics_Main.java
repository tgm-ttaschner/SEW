package polymorphie.universell.generics;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Die Generizität wird auch parametrisierte Polymorphie genannt.
 * Ein und dieselbe Methode, Klasse, soll für Daten verschiedener Typen verwendbar sein.
 * Durch den Einsatz von formalen Typparametern wird diese Vielgestaltigkeit erreicht.
 * Generics findet seine Anwendung in Methoden, Klassen, aber auch Interfaces.
 * 
 * Das folgende Beispiel soll die Funktion von Generics bzw. der Generizität mit Hilfe von diesen Wrappenklassen demonstrieren.
 */
public class Generics_Main {

	/**
	 * @param args Argument von Main
	 */
	public static void main(String[] args) {
		/**
		 * Ein- und Ausgabe für String
		 */
		WrapperString s = new WrapperString("abc");
		System.out.println(s.toString());

		/**
		 * Ein- und Ausgabe für Integer
		 */
		WrapperInteger i = new WrapperInteger(123);
		System.out.println(i.toString());

		/**
		 * Ein- und Ausgabe für Double
		 */
		WrapperDouble d = new WrapperDouble(123.456);
		System.out.println(d.toString() + "\n");

		/**
		 * Ein- und Ausgabe für alle drei Datentypen mit Hilfe von Generics
		 */
		Wrapper<String> ws = new Wrapper<String>("abc");
		System.out.println(ws.toString());

		Wrapper<Integer> wi = new Wrapper<Integer>(123);
		System.out.println(wi.toString());

		Wrapper<Double> wd = new Wrapper<Double>(123.456);
		System.out.println(wd.toString());
		wd.setValue(987.654);
		System.out.println(wd.toString());

		/**
		 * Der Typparameter wird in spitzen Klammern <T> geschrieben.
		 * Bei der Erstellung von Objekten muss der Typ (z.B.: Wrapper<Integer>) bekannt gemacht werden.
		 * Mithilfe des new-Operators (new Wrapper<Integer>(2)) wird ein Wrapper-Objekt mit dem Datentyp Integer erstellt.
		 */
	}
}
