package kapselung.getter_setter;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Bei der Kapselung wird zwischen den nach außen sichtbaren Attribute und Methoden (Schnittstelle der Klasse)  und den nach innen sichtbaren Eigenschaften und Methoden unterschieden.
 * Nach innen Sichtbares soll beim Implementieren der Klasse vor dem Benutzer verborgen bleiben. 
 * Der Zugriff darf nur über eine explizit definierte Schnittstelle erfolgen.
 * So wird eine Korrektheit (Konsistenz) der Daten gewährleistet.
 * Dies wird mit Hilfe von Getter- und Setter-Methoden ermöglicht.
 *  -- Es darf NIEMALS von außen direkt auf die Attribute zugegriffen werden
 * Um wieder an das Schüler Beispiel anzuknüpfen, wird die Schülerklasse um eine Getter- und Setter-Methode für das alle Attribute erweitert:
 */

public class Schueler {
	
	/**
	 * Die Attribute können in Java ebenfalls einen "Access Modifier" haben.
	 * Mehr dazu im Kapitel Access Modifier.
	 */
	private long schuelernummer;
	private String vorname;
	private String nachname;
	private String klasse;
	
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
	 * Die Getter-Methoden geben den Wert des jeweiligen Attributs zurück.
	 */
	
	
	/**
	 * @return Die Schülernummer
	 */
	public long getSchuelernummer() {
		return schuelernummer;
	}

	/**
	 * @return Der Vorname des Schülers
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @return Der Nachname des Schülers
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @return Der Name der Klasse, die der Schüler besucht
	 */
	public String getKlasse() {
		return klasse;
	}
	
	/**
	 * Die Setter-Methoden setzen den Wert des jeweiligen Attributs des aktuellen Objektes auf den über die Methoden mitgegebenen Werte.
	 */
	
	/**
	 * @param schuelernummer Die Schülernummer
	 */
	public void setSchuelernummer(long schuelernummer) {
		this.schuelernummer = schuelernummer;
	}

	/**
	 * @param vorname Der Vorname des Schülers
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @param nachname Der Nachname des Schülers
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @param klasse Der Name der Klasse, die der Schüler besucht
	 */
	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

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
}