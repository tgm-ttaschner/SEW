package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer StockEnte.
 */
public class StockEnte implements Quakfaehig {
	SenderRing senderRing;

	/**
	 * Erstellt eine neue Stockente.
	 */
	public StockEnte() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Hier wird gequakt und alle Beobachter werden informiert.
	 */
	public void quaken() {
		System.out.println("Quak");
		benachrichtigeBeobachtende();
	}

	/**
	 * Macht die Stockente beobachtbar, registriert einen neuen Zuschauer.
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
		return "Stockente";
	}
}