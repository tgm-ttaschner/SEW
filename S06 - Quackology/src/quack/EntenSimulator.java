package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Ausfuehren der Entensimulation, es werden verschiedenste Enten initialisiert und dessen Quaken vom Quakologen analysiert und ausgegeben.
 */
public class EntenSimulator {
	public static void main(String[] args) {
		EntenSimulator simulator = new EntenSimulator();
		AbstrakteEntenFabrik entenFabrik = new ZaehlendeEntenFabrik();
 
		simulator.simulieren(entenFabrik);
	}
	
	/**
	 * 
	 * Enten werden erstellt ('fabriziert'),
	 * einer Schar hinzugefuegt, die der Observer Quakologe ueberwachen kann,
	 * dem Quakologen wird gesagt, dass er die Schar ueberwachen soll,
	 * dann werden die Enten zum Quaken gebracht,
	 * und der Quakologe zaehlt und berichtet.
	 * 
	 * @param entenfabrik Die Fabrik, die verwendet werden soll.
	 */
	public void simulieren(AbstrakteEntenFabrik entenfabrik) {
  
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		Quakfaehig gansEnte = new GansAdapter(new Gans());
 
		Schar EntenSchar = new Schar();
 
		EntenSchar.hinzufuegen(moorEnte);
		EntenSchar.hinzufuegen(lockPfeife);
		EntenSchar.hinzufuegen(gummiEnte);
		EntenSchar.hinzufuegen(gansEnte);
 
		Schar stockEntenSchar = new Schar();
 
		Quakfaehig stockEnte1 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte2 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte3 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte4 = entenfabrik.erzeugeStockEnte();

		stockEntenSchar.hinzufuegen(stockEnte1);
		stockEntenSchar.hinzufuegen(stockEnte2);
		stockEntenSchar.hinzufuegen(stockEnte3);
		stockEntenSchar.hinzufuegen(stockEnte4);

		EntenSchar.hinzufuegen(stockEntenSchar);

		System.out.println("\nEntensimulator: mit Observer");

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		simulieren(EntenSchar);

		System.out.println("\nDie Enten haben " + 
		                   QuakZaehler.getQuaks() + 
		                   "-mal gequakt.");
	}
 
	/**
	 * 
	 * Bringt beliebig viele Enten zum Quaken.
	 * 
	 * @param ente Welche Enten quaken sollen (1-x Elemente)
	 */
	public void simulieren(Quakfaehig ente) {
		ente.quaken();
	}
}