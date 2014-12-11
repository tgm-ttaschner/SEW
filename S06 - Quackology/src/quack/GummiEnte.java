package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer GummiEnte, die nicht quaken, sondern nur quietschen kann.
 */
public class GummiEnte implements Quakfaehig {
	SenderRing senderRing;

	public GummiEnte() {
		senderRing = new SenderRing(this);
	}
 
	public void quaken() {
		System.out.println("Quietsch");
		benachrichtigeBeobachtende();
	}

	public void registriereBeobachter(Beobachter beobachter) {
		senderRing.registriereBeobachter(beobachter);
	}

	public void benachrichtigeBeobachtende() {
		senderRing.benachrichtigeBeobachtende();
	}
  
	public String toString() {
		return "Gummiente";
	}
}