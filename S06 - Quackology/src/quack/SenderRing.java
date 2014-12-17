package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung eines SenderRings, der eine Meldung an alle Beobachter schickt.
 */
import java.util.Iterator;
import java.util.ArrayList;

public class SenderRing implements QuakBeobachtungsSubjekt {
	ArrayList<Beobachter> beobachtende = new ArrayList<Beobachter>();
	QuakBeobachtungsSubjekt ente;
 
	/**
	 * 
	 * Erstellt ein neues SenderRing-Objekt.
	 * 
	 * @param ente Eine Ente.
	 * 
	 */
	public SenderRing(QuakBeobachtungsSubjekt ente) {
		this.ente = ente;
	}
  
	/**
	 * Macht das Objekt beobachtbar, registriert einen neuen Zuschauer.
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		beobachtende.add(beobachter);
	}
  
	/**
	 * Informiert alle Zuschauer, wenn etwas passiert.
	 */
	public void benachrichtigeBeobachtende() {
		Iterator<Beobachter> iterator = beobachtende.iterator();
		while (iterator.hasNext()) {
			Beobachter beobachter = (Beobachter)iterator.next();
			beobachter.aktualisieren(ente);
		}
	}
 
	/**
	 * Liefert zurueck, welche Beobachter es gibt.
	 * 
	 * @return it Ein Iterator mit allen Beobachtern.
	 * 
	 */
	public Iterator<Beobachter> getBeobachtende() {
		return beobachtende.iterator();
	}
}