package oop_intro;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Die Objektorientierung ist ein Ansatz aus der Softwareentwicklung, der Daten und dazugehörige Funktionen von in der Realität vorkommenden Objekten in Klassen zusammenfasst.
 * Das Ziel der Objektorientierung ist:
 *  -- Reduzierter Programmieraufwand durch wiederverwendbaren Code
 *  -- Bessere Verständlichkeit und Wartbarkeit des Codes
 *
 * Objekte in der Softwareentwicklung sind virtuelle Abbildungen der Realität. Sie werden durch seine Eigenschaften (Attribute) und durch seine Funktionen (Methoden) definiert. Diese Objekte werden nach einer bestimmten Vorlage bzw. Schablone (Klasse) erstellt.
 * Eine Klasse erlaubt es gemeinsame Merkmale zwischen Objekten zusammenzufassen.
 * Wird dieses Objekt nun im Code ausgeführt, so spricht man von einer Instanz, einem nach dieser Klasse nachgebauten, ins Leben gerufene, Modell. Man spricht hier von einer Instanziierung des Objekts.
 * 
 * Jede Instanz eines Objekts besitzt folgende Eigenschaften:
 *  -- Identität – Meistens die Speicheradresse des Objekts
 *  -- Zustand – Die Summe aller Attribute
 *  -- Verhalten – Die Reaktion des Objekts durch Methoden auf bestimmte Ereignisse
 * 
 * Während die Klasse nur angibt, wie die Struktur eines Objektes sein soll, beinhaltet eine Instanz auch konkrete Werte.
 * 
 * Nehmen wir als Beispiel die Klasse Schüler her:
 */

public class Schueler {
	
	/**
	 * Die Eigenschaften/Attribute der Klasse
	 */
	private long schuelernummer;
	private String vorname;
	private String nachname;
	private String klasse;
	
	/**
	 * Der Konstruktor - Konkreter Aufbau der Schablone des zu erstellenden Objekts
	 */
	
	/**
	 * @param schuelernummer Die Schülernummer
	 * @param vorname Der Vorname des Schülers
	 * @param nachname Der Nachname des Schülers
	 * @param klasse Der Name der Klasse, die der Schüler besucht
	 */
	public Schueler(long schuelernummer, String vorname, String nachname, String klasse)	{
		this.schuelernummer = schuelernummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.klasse = klasse;
	}

	/**
	 * Eine Funktion/Methode der Klasse
	 * Jede Methode muss eine einzigartige Signatur (Name und Eingangsparameter) haben
	 */
	
	/** 
	 * Gibt "Passt während des Unterrichts auf" auf der Konsole aus
	 */
	public void unterricht()	{
		System.out.println("Passt während des Unterrichts auf");
	}
	
	/**
	 * Gibt "Macht eine Hausübung" auf der Konsole aus
	 */
	public void hausuebung()	{
		System.out.println("Macht eine Hausübung");
	}
	
	/**
	 * Gibt "Lernt für die Schule" auf der Konsole aus
	 */
	public void lernen()	{
		System.out.println("Lernt für die Schule");
	}
	
	/**
	 * Dank der Objektorientierung kann man hier sehr leicht Instanzen von Schüler erstellen.
	 */
	
	/**
	 * @param args Argument von Main
	 */
	public static void main(String[] args) {
		Schueler s = new Schueler(12345, "Max", "Mustermann", "3A");
		
		/**
		 * Ausgabe der Werte der Attribute des Objekts
		 * Der Zugriff auf die Attribute erfolgt direkt
		 */
		System.out.println(s.schuelernummer);
		System.out.println(s.vorname);
		System.out.println(s.nachname);
		System.out.println(s.klasse);
		
		s.lernen();
	}
}