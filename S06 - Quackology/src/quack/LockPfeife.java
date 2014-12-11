package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer Lockpfeife, die nicht quaken, sondern nur 'kwaaken' kann.
 */
public class LockPfeife implements Quakfaehig {
	SenderRing senderRing;

	public LockPfeife() {
		senderRing = new SenderRing(this);
	}

	public void quaken() {
		System.out.println("Kwaak");
		benachrichtigeBeobachtende();
	}

	public void registriereBeobachter(Beobachter beobachter) {
		senderRing.registriereBeobachter(beobachter);
	}

	public void benachrichtigeBeobachtende() {
		senderRing.benachrichtigeBeobachtende();
	}

	public String toString() {
		return "Lockpfeife";
	}
}