package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Interface, dessen einzige Methoden den Status der zu beobachteten Ente abfragt.
 */
public interface Beobachter {
	public void aktualisieren(QuakBeobachtungsSubjekt ente);
}