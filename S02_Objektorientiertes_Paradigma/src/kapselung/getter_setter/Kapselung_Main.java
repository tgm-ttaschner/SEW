package kapselung.getter_setter;

import java.util.Random;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Ausf�hrung der Getter- und Setter-Methoden von Sch�ler
 */
public class Kapselung_Main {
	
	/**
	 * 
	 * @param args Argument von Main
	 */
	public static void main(String[] args) {
		Schueler s = new Schueler(12345, "Max", "Mustermann", "3A");
		
		/**
		 * Ausgabe und �nderung der Werte der Attribute des Objekts
		 * Der Zugriff auf die Attribute erfolgt indirekt �ber entsprechende Methoden
		 */
		System.out.println(s.getSchuelernummer());
		System.out.println(s.getVorname());
		System.out.println(s.getNachname());
		System.out.println(s.getKlasse() + "\n");
		
		/**
		 * Mit Hilfe der Setter-Methoden k�nnen auf einfache Weise die Werte des Objekts ge�ndert werden
		 */
		s.setSchuelernummer(Math.abs(new Random().nextLong()));
		s.setVorname("Herbert");
		s.setNachname("Eichelmann");
		s.setKlasse("1C");
		
		System.out.println(s.getSchuelernummer());
		System.out.println(s.getVorname());
		System.out.println(s.getNachname());
		System.out.println(s.getKlasse());
	}
}
