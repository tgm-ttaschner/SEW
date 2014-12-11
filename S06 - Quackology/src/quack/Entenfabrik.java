package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Konkrete Implementierung der abstrakten Entenfabrik. Hier werden nur entsprechende neue Entenobjekte erzeugt.
 */
public class Entenfabrik extends AbstrakteEntenFabrik {
  
	public Quakfaehig erzeugeStockEnte() {
		return new StockEnte();
	}
  
	public Quakfaehig erzeugeMoorEnte() {
		return new MoorEnte();
	}
  
	public Quakfaehig erzeugeLockPfeife() {
		return new LockPfeife();
	}
   
	public Quakfaehig erzeugeGummiEnte() {
		return new GummiEnte();
	}
}