package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung eines Zaehlers, der mitzaehlt, wie oft die Enten insgesamt schon gequakt haben.
 */
public class QuakZaehler implements Quakfaehig {
	Quakfaehig ente;
	static int anzahlDerQuaks;
  
	/**
	 * 
	 * Erstellt ein neues Objekt fuer eine Ente.
	 * 
	 * @param ente Bei welcher Ente mitgezaehlt werden soll.
	 * 
	 */
	public QuakZaehler(Quakfaehig ente) {
		this.ente = ente;
	}
  
	/**
	 * Quakt und zaehlt den globalen Counter hoch.
	 */
	public void quaken() {
		ente.quaken();
		anzahlDerQuaks++;
	}
 
	/**
	 * Liefert den globalen Counter, wie oft alle Enten einen Laut von sich gegeben haben.
	 * 
	 * @return erg Die Anzahl der Quaks.
	 * 
	 */
	public static int getQuaks() {
		return anzahlDerQuaks;
	}
 
	/**
	 * Macht das Objekt beobachtbar, registriert einen Zuschauer.
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		ente.registriereBeobachter(beobachter);
	}
 
	/**
	 * Benachrichtigt alle Zuschauer.
	 */
	public void benachrichtigeBeobachtende() {
		ente.benachrichtigeBeobachtende();
	}
   
	/**
	 * Liefert zurueck, um welches Objekt es sich handelt.
	 */
	public String toString() {
		return ente.toString();
	}
}