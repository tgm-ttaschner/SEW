package polymorphie.adhoc.casten;

/**
 * 
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Es kommt recht häufig vor, dass Datentypen konvertiert werden müssen.
 * Dieser Vorgang nennt sich Casten.
 * In Java wird hier zwischen zwei Arten der Typanpassung unterschieden:
 */

public class Casten {
	
	/**
	 * @param args Argument von Main
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/**
		 * Beim impliziten Casten werden Daten von einem kleineren Datentypen ohne Datenverlust in einen größeren Datentypen umgewandelt.
		 */
		short s1 = 123;
		int i1 = 544764 + s1;
		long l1 = 1234567890 + i1;
		float f1 = i1;
		double d1 = f1 + l1;
		
		/**
		 * Beim expliziten Casten werden Daten von einem größeren Datentypen mit Datenverlust in einen kleineren Datentypen umgewandelt.
		 */
		short s2 = (short) d1;
		int i2 = (int) d1;
		long l2 = Long.MAX_VALUE;
		byte b1 = (byte) l2;
	}
}
