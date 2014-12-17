package quack;


/**
 * @author O'reilly Verlag, uebernommen von Thomas Taschner und Michael Weinberger
 * @version 11.12.2014
 * 
 * Implementierung einer Gans, die nicht quaken, sondern nur schnattern kann.
 */
public class Gans {

	/**
	 * Die Gans muss schnattern !
	 */
	public void schnattern() {
		System.out.println("Schnatter");
	}

	/**
	 * Keine Ente, sondern eine Gans
	 */
	public String toString() {
		return "Gans";
	}
}