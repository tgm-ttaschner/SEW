package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung des Quakologen, der ausgibt, was fuer eine Ente gerade gequakt hat.
 */
public class Quakologe implements Beobachter {
 
	public void aktualisieren(QuakBeobachtungsSubjekt ente) {
		System.out.println("Quakologe: " + ente + " hat gerade gequakt.");
	}
 
	public String toString() {
		return "Quakologe";
	}
}