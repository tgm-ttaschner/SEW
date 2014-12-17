package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Konkrete Implementierung der abstrakten Entenfabrik, es werden Zaehler mit dem entsprechenden Entenobjekt zurueckgegeben.
 */
public class ZaehlendeEntenFabrik extends AbstrakteEntenFabrik {

	/**
	 * Erzeugt eine Stockente mit Counter.
	 */
	public Quakfaehig erzeugeStockEnte() {
		return new QuakZaehler(new StockEnte());
	}

	/**
	 * Erzeugt eine Moorente mit Counter.
	 */
	public Quakfaehig erzeugeMoorEnte() {
		return new QuakZaehler(new MoorEnte());
	}

	/**
	 * Erzeugt eine Lockpfeife mit Counter.
	 */
	public Quakfaehig erzeugeLockPfeife() {
		return new QuakZaehler(new LockPfeife());
	}

	/**
	 * Erzeugt eine Gummiente mit Counter.
	 */
	public Quakfaehig erzeugeGummiEnte() {
		return new QuakZaehler(new GummiEnte());
	}
}