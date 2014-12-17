package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * https://www.vgt.at/ ;)
 * Konkrete Implementierung der abstrakten Entenfabrik. Hier werden nur entsprechende neue Entenobjekte erzeugt.
 */
public class Entenfabrik extends AbstrakteEntenFabrik {
  
	/**
	 * Liefert eine Stockente als Objekt zurueck.
	 * @return ente Die Stockente
	 */
	public Quakfaehig erzeugeStockEnte() {
		return new StockEnte();
	}
  
	/**
	 * Liefert eine Moorente als Objekt zurueck.
	 * @return ente Die Moorente
	 */
	public Quakfaehig erzeugeMoorEnte() {
		return new MoorEnte();
	}
  
	/**
	 * Liefert eine Lockpfeife als Objekt zurueck.
	 * @return pfeife Die Lockpfeife
	 */
	public Quakfaehig erzeugeLockPfeife() {
		return new LockPfeife();
	}
   
	/**
	 * Liefert eine Gummiente als Objekt zurueck.
	 * @return ente Die Gummiente
	 */
	public Quakfaehig erzeugeGummiEnte() {
		return new GummiEnte();
	}
}