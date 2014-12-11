package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Konkrete Implementierung der abstrakten Entenfabrik, es werden Zaehler mit dem entsprechenden Entenobjekt zurueckgegeben.
 */
public class ZaehlendeEntenFabrik extends AbstrakteEntenFabrik {

	public Quakfaehig erzeugeStockEnte() {
		return new QuakZaehler(new StockEnte());
	}

	public Quakfaehig erzeugeMoorEnte() {
		return new QuakZaehler(new MoorEnte());
	}

	public Quakfaehig erzeugeLockPfeife() {
		return new QuakZaehler(new LockPfeife());
	}

	public Quakfaehig erzeugeGummiEnte() {
		return new QuakZaehler(new GummiEnte());
	}
}