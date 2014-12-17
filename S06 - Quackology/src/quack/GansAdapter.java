package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Adapterklasse, die es ermoeglicht der Gans sich als Ente anzugeben.
 */
public class GansAdapter implements Quakfaehig {
	Gans gans;
	SenderRing senderRing;

	/**
	 * Diese Gans gibt sich als Ente aus.
	 * 
	 * @param gans Die zu verschleiernde Gans
	 */
	public GansAdapter(Gans gans) {
		this.gans = gans;
		senderRing = new SenderRing(this);
	}
 
	/**
	 * Implementiert quaken, jedoch mit Gans-typischem Schnattern.
	 */
	public void quaken() {
		gans.schnattern();
		benachrichtigeBeobachtende();
	}

	/**
	 * Hier wird die Beobachtbarkeit ermoeglicht.
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		senderRing.registriereBeobachter(beobachter);
	}

	/**
	 * Die Beobachter werden ueber das Verhalten der Gans informiert.
	 */
	public void benachrichtigeBeobachtende() {
		senderRing.benachrichtigeBeobachtende();
	}

	/**
	 * Hier wird informiert um welche vermeintliche Ente es sich handelt.
	 */
	public String toString() {
		return "sich als Ente ausgebende Gans";
	}
}