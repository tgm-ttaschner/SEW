package quack;

/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer (Enten)schar. Enten koennen dieser hinzugefuegt werden.
 * 
 * Es wurden lediglich die generischen Argumente bei der ArrayList und dem Iterator hinzugefuegt.
 */
import java.util.Iterator;
import java.util.ArrayList;

public class Schar implements Quakfaehig {
	ArrayList<Quakfaehig> quakende = new ArrayList<Quakfaehig>();
  
	/**
	 * Fuegt eine Ente zur Schar hinzu.
	 * 
	 * @param quaker Die Ente, die zur Schar dazustoesst.
	 */
	public void hinzufuegen(Quakfaehig quaker) {
		quakende.add(quaker);
	}
  
	/**
	 * Laesst das ganze Rudel Enten quaken.
	 */
	public void quaken() {
		Iterator<Quakfaehig> iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.quaken();
		}
	}
   
	/**
	 * 
	 * Macht das Objekt beobachtbar, fuegt einen neuen Zuschauer hinzu.
	 * 
	 * @param beobachter Der neue Zuschauer.
	 * 
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		Iterator<Quakfaehig> iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.registriereBeobachter(beobachter);
		}
	}
  
	/**
	 * Stub method
	 */
	public void benachrichtigeBeobachtende() { }
  
	/**
	 * Zeigt, um welches Objekt es sich handelt.
	 */
	public String toString() {
		return "Entenschar";
	}
}