package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer MoorEnte.
 */
public class MoorEnte implements Quakfaehig {
	SenderRing senderRing;

	/**
	 * Erstellt eine neue Moorente.
	 */
	public MoorEnte() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Hier wird quakt und alle Beobachter werden informiert.
	 */
	public void quaken() {
		System.out.println("Quak");
		benachrichtigeBeobachtende();
	}

	/**
	 * Macht die Moorente beobachtbar, registriert einen neuen Zuschauer.
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
		return "Moorente";
	}
}