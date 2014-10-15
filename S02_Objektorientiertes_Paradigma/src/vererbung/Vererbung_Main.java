package vererbung;

/**
 * @author Thomas Taschner
 * @version 14.10.2014
 * 
 * Die Vererbung beschreibt die Beziehung zwischen Klassen, die in einer direkten Relation in der Vererbungshierarchie stehen.
 * Ist die Klasse eine Unterklasse (Child) einer Oberklasse (Parent), so:
 *  -- Werden alle Attribute und Methoden des Elternteils an das Kind weitergeben
 *  -- Kann jedes Objekt der Kindklasse auch als Objekt der Oberklasse behandelt werden (mehr dazu im Kapitel Polymorphie)
 * 
 * Kindklassen können wie ihre Eltern verwendet und zusätzlich noch erweitert werden.
 * 
 * Nehmen wir hier als praktisches Beispiel die Klassen A, B und C her:
 * C erbt von B, B erbt wiederum von A.
 */
public class Vererbung_Main {
	
	public static void main(String[] args) {

		A aa = new A();
		A ab = new B();
		A ac = new C();

		/**
		 * ClassCastException wird geworfen -> A kann nicht nach B gecastet werden
		 */
		//B ba = (B) new A();

		B bb = new B();
		B bc = new C();
		
		/**
		 * ClassCastException wird geworfen -> A und B können nicht nach C gecastet werden
		 */
		//C ca = (C) new A();
		//C cb = (C) new B();
		C cc = new C();

		System.out.println(aa.m1());
		System.out.println(ab.m1());
		System.out.println(ac.m1() + "\n");

		/**
		 * Variable wird nie initialisiert, da beim Casten von A nach B eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ba.m1());

		System.out.println(bb.m1());
		System.out.println(bc.m1() + "\n");
		
		/**
		 * Variable wird nie initialisiert, da beim Casten von A und B nach C eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ca.m1());
		//System.out.println(cb.m1());
		System.out.println(cc.m1() + "\n\n");

		System.out.println(aa.m2());
		System.out.println(ab.m2());
		System.out.println(ac.m2() + "\n");

		/**
		 * Variable wird nie initialisiert, da beim Casten von A nach B eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ba.m2());

		System.out.println(bb.m2());
		System.out.println(bc.m2() + "\n");
		
		/**
		 * Variable wird nie initialisiert, da beim Casten von A und B nach C eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ca.m2());
		//System.out.println(cb.m2());
		System.out.println(cc.m2() + "\n\n");
		
		
		/**
		 * Objekt A besitzt die Fähigkeit m3, die Objekt B besitzt, nicht.
		 */
		//System.out.println(aa.m3());
		//System.out.println(ab.m3());
		//System.out.println(ac.m3() + "\n");

		/**
		 * Variable wird nie initialisiert, da beim Casten von A nach B eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ba.m3());

		System.out.println(bb.m3());
		System.out.println(bc.m3() + "\n");
		
		/**
		 * Variable wird nie initialisiert, da beim Casten von A und B nach C eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ca.m3());
		//System.out.println(cb.m3());
		System.out.println(cc.m3() + "\n\n");
		
		
		/**
		 * Objekt A besitzt die Fähigkeit m4, die Objekt C besitzt, nicht.
		 */
		//System.out.println(aa.m4());
		//System.out.println(ab.m4());
		//System.out.println(ac.m4() + "\n");

		/**
		 * Variable wird nie initialisiert, da beim Casten von A nach B eine ClassCastException geworfen wird -> kein Aufruf möglich
		 * Außerdem besitzt Objekt A die Fähigkeit m4, die Objekt C besitzt, nicht.
		 */
		//System.out.println(ba.m4());
		//System.out.println(bb.m4());
		//System.out.println(bc.m4() + "\n");
		
		/**
		 * Variable wird nie initialisiert, da beim Casten von A und B nach C eine ClassCastException geworfen wird -> kein Aufruf möglich
		 */
		//System.out.println(ca.m4());
		//System.out.println(cb.m4());
		System.out.println(cc.m4());
	}
}