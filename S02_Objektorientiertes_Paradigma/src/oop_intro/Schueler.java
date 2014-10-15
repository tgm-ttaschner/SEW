package oop_intro;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Die Objektorientierung ist ein Ansatz aus der Softwareentwicklung, der Daten und dazugeh�rige Funktionen von in der Realit�t vorkommenden Objekten in Klassen zusammenfasst.
 * Das Ziel der Objektorientierung ist:
 *  -- Reduzierter Programmieraufwand durch wiederverwendbaren Code
 *  -- Bessere Verst�ndlichkeit und Wartbarkeit des Codes
 *
 * Objekte in der Softwareentwicklung sind virtuelle Abbildungen der Realit�t. Sie werden durch seine Eigenschaften (Attribute) und durch seine Funktionen (Methoden) definiert. Diese Objekte werden nach einer bestimmten Vorlage bzw. Schablone (Klasse) erstellt.
 * Eine Klasse erlaubt es gemeinsame Merkmale zwischen Objekten zusammenzufassen.
 * Wird dieses Objekt nun im Code ausgef�hrt, so spricht man von einer Instanz, einem nach dieser Klasse nachgebauten, ins Leben gerufene, Modell. Man spricht hier von einer Instanziierung des Objekts.
 * 
 * Jede Instanz eines Objekts besitzt folgende Eigenschaften:
 *  -- Identit�t � Meistens die Speicheradresse des Objekts
 *  -- Zustand � Die Summe aller Attribute
 *  -- Verhalten � Die Reaktion des Objekts durch Methoden auf bestimmte Ereignisse
 * 
 * W�hrend die Klasse nur angibt, wie die Struktur eines Objektes sein soll, beinhaltet eine Instanz auch konkrete Werte.
 * 
 * Nehmen wir als Beispiel die Klasse Sch�ler her:
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
	 * @param schuelernummer Die Sch�lernummer
	 * @param vorname Der Vorname des Sch�lers
	 * @param nachname Der Nachname des Sch�lers
	 * @param klasse Der Name der Klasse, die der Sch�ler besucht
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
	 * Gibt "Passt w�hrend des Unterrichts auf" auf der Konsole aus
	 */
	public void unterricht()	{
		System.out.println("Passt w�hrend des Unterrichts auf");
	}
	
	/**
	 * Gibt "Macht eine Haus�bung" auf der Konsole aus
	 */
	public void hausuebung()	{
		System.out.println("Macht eine Haus�bung");
	}
	
	/**
	 * Gibt "Lernt f�r die Schule" auf der Konsole aus
	 */
	public void lernen()	{
		System.out.println("Lernt f�r die Schule");
	}
	
	/**
	 * Dank der Objektorientierung kann man hier sehr leicht Instanzen von Sch�ler erstellen.
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