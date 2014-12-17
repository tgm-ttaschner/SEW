package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer GummiEnte, die nicht quaken, sondern nur quietschen kann.
 */
public class GummiEnte implements Quakfaehig {
	SenderRing senderRing;

	/**
	 * Erzeugt eine neue Gummiente.
	 */
	public GummiEnte() {
		senderRing = new SenderRing(this);
	}
 
	/**
	 * Hier wird gequietscht und alle Beobachter werden informiert.
	 */
	public void quaken() {
		System.out.println("Quietsch");
		benachrichtigeBeobachtende();
	}

	/**
	 * Macht die Gummiente beobachtbar, registriert einen neuen Zuschauer.
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		senderRing.registriereBeobachter(beobachter);
	}

	/**
	 * Informiert alle Zuschauer, wenn etwas passiert.
	 */
	public void benachrichtigeBeobachtende() {
		senderRing.benachrichtigeBeobachtende();
	}
  
	/**
	 * Liefert, um welche Entenart es sich handelt.
	 */
	public String toString() {
		return "Gummiente";
	}
}