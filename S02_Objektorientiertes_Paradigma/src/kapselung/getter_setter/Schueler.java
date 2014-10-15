package kapselung.getter_setter;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Bei der Kapselung wird zwischen den nach au�en sichtbaren Attribute und Methoden (Schnittstelle der Klasse)  und den nach innen sichtbaren Eigenschaften und Methoden unterschieden.
 * Nach innen Sichtbares soll beim Implementieren der Klasse vor dem Benutzer verborgen bleiben. 
 * Der Zugriff darf nur �ber eine explizit definierte Schnittstelle erfolgen.
 * So wird eine Korrektheit (Konsistenz) der Daten gew�hrleistet.
 * Dies wird mit Hilfe von Getter- und Setter-Methoden erm�glicht.
 *  -- Es darf NIEMALS von au�en direkt auf die Attribute zugegriffen werden
 * Um wieder an das Sch�ler Beispiel anzukn�pfen, wird die Sch�lerklasse um eine Getter- und Setter-Methode f�r das alle Attribute erweitert:
 */

public class Schueler {
	
	/**
	 * Die Attribute k�nnen in Java ebenfalls einen "Access Modifier" haben.
	 * Mehr dazu im Kapitel Access Modifier.
	 */
	private long schuelernummer;
	private String vorname;
	private String nachname;
	private String klasse;
	
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
	 * Die Getter-Methoden geben den Wert des jeweiligen Attributs zur�ck.
	 */
	
	
	/**
	 * @return Die Sch�lernummer
	 */
	public long getSchuelernummer() {
		return schuelernummer;
	}

	/**
	 * @return Der Vorname des Sch�lers
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @return Der Nachname des Sch�lers
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @return Der Name der Klasse, die der Sch�ler besucht
	 */
	public String getKlasse() {
		return klasse;
	}
	
	/**
	 * Die Setter-Methoden setzen den Wert des jeweiligen Attributs des aktuellen Objektes auf den �ber die Methoden mitgegebenen Werte.
	 */
	
	/**
	 * @param schuelernummer Die Sch�lernummer
	 */
	public void setSchuelernummer(long schuelernummer) {
		this.schuelernummer = schuelernummer;
	}

	/**
	 * @param vorname Der Vorname des Sch�lers
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @param nachname Der Nachname des Sch�lers
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @param klasse Der Name der Klasse, die der Sch�ler besucht
	 */
	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

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
}