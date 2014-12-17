package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung des Quakologen, der ausgibt, was fuer eine Ente gerade gequakt hat.
 */
public class Quakologe implements Beobachter {
 
	/**
	 * 
	 * Gibt aus, welche Ente einen Laut von sich gegeben hat.
	 * 
	 * @param ente Die spezifische Ente
	 */
	public void aktualisieren(QuakBeobachtungsSubjekt ente) {
		System.out.println("Quakologe: " + ente + " hat gerade gequakt.");
	}
 
	/**
	 * Gibt aus, um welches Objekt es sich handelt.
	 */
	public String toString() {
		return "Quakologe";
	}
}