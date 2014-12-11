package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Abstrakte Enten Fabrik, die abstrakte Methoden zum Erstellen von verschiedenen Enten des Typs quackfaehig besitzt.
 */
public abstract class AbstrakteEntenFabrik {
	public abstract Quakfaehig erzeugeStockEnte();
	public abstract Quakfaehig erzeugeMoorEnte();
	public abstract Quakfaehig erzeugeLockPfeife();
	public abstract Quakfaehig erzeugeGummiEnte();
}