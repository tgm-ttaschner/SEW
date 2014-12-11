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
  
	public void hinzufügen(Quakfaehig quaker) {
		quakende.add(quaker);
	}
  
	public void quaken() {
		Iterator<Quakfaehig> iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.quaken();
		}
	}
   
	public void registriereBeobachter(Beobachter beobachter) {
		Iterator<Quakfaehig> iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.registriereBeobachter(beobachter);
		}
	}
  
	public void benachrichtigeBeobachtende() { }
  
	public String toString() {
		return "Entenschar";
	}
}