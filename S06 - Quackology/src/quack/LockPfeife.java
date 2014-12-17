package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer Lockpfeife, die nicht quaken, sondern nur 'kwaaken' kann.
 */
public class LockPfeife implements Quakfaehig {
	SenderRing senderRing;

	/**
	 * Erstellt eine neue Lockpfeife.
	 */
	public LockPfeife() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Hier wird gekwaakt und alle Beobachter werden informiert.
	 */
	public void quaken() {
		System.out.println("Kwaak");
		benachrichtigeBeobachtende();
	}

	/**
	 * Macht die Lockpfeife beobachtbar, registriert einen neuen Zuschauer.
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
		return "Lockpfeife";
	}
}