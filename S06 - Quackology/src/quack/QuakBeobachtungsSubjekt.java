package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Interface, dessen Methoden es einem Beobachter erlauben sich zu registrieren und benachrichtigt zu werden.
 */
public interface QuakBeobachtungsSubjekt {
	public void registriereBeobachter(Beobachter beobachter);
	public void benachrichtigeBeobachtende();
}