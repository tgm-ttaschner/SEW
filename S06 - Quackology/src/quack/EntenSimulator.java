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
  
	void simulieren(AbstrakteEntenFabrik entenfabrik) {
  
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		Quakfaehig gansEnte = new GansAdapter(new Gans());
 
		Schar EntenSchar = new Schar();
 
		EntenSchar.hinzuf�gen(moorEnte);
		EntenSchar.hinzuf�gen(lockPfeife);
		EntenSchar.hinzuf�gen(gummiEnte);
		EntenSchar.hinzuf�gen(gansEnte);
 
		Schar stockEntenSchar = new Schar();
 
		Quakfaehig stockEnte1 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte2 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte3 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte4 = entenfabrik.erzeugeStockEnte();

		stockEntenSchar.hinzuf�gen(stockEnte1);
		stockEntenSchar.hinzuf�gen(stockEnte2);
		stockEntenSchar.hinzuf�gen(stockEnte3);
		stockEntenSchar.hinzuf�gen(stockEnte4);

		EntenSchar.hinzuf�gen(stockEntenSchar);

		System.out.println("\nEntensimulator: mit Observer");

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		simulieren(EntenSchar);

		System.out.println("\nDie Enten haben " + 
		                   QuakZaehler.getQuaks() + 
		                   "-mal gequakt.");
	}
 
	void simulieren(Quakfaehig ente) {
		ente.quaken();
	}
}