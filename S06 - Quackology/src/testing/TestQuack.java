package testing;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import quack.*;

/**
 * @author Thomas Taschner
 * @version 18.12.2014
 * 
 * Testet die Entenfabrik auf ihre Funktionalitaet.
 *
 */
public class TestQuack extends MoorEnte {

	EntenSimulator simulator;
	AbstrakteEntenFabrik entenfabrik;

	Schar EntenSchar;

	/**
	 * Vorbereitend fuer die Tests
	 */
	@Before
	public void setup()	{
		simulator = new EntenSimulator();
		entenfabrik = new ZaehlendeEntenFabrik();
		EntenSchar = new Schar();
	}

	/**
	 * Eine Moorentenschar quakt.
	 */
	@Test
	public void testMoorEntenSchar()	{

		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		EntenSchar.hinzufuegen(moorEnte);

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));

		//call your method here
		simulator.simulieren(moorEnte);

		// Es gab Probleme mit dem Lineseparator
		String abc = "Quak" + System.lineSeparator() + "Quakologe: Moorente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());
	}

	/**
	 * Eine Lockpfeifenschar 'kwaakt'.
	 */
	@Test
	public void testLockPfeifenSchar() {
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		EntenSchar.hinzufuegen(lockPfeife);

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));

		//call your method here
		simulator.simulieren(lockPfeife);

		// Es gab Probleme mit dem Lineseparator
		String abc = "Kwaak" + System.lineSeparator() + "Quakologe: Lockpfeife hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());


	}

	/**
	 * Eine Gummientenschar quietscht.
	 */
	@Test
	public void testGummiEntenSchar() {
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		EntenSchar.hinzufuegen(gummiEnte);

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));

		//call your method here
		simulator.simulieren(gummiEnte);

		// Es gab Probleme mit dem Lineseparator
		String abc = "Quietsch" + System.lineSeparator() + "Quakologe: Gummiente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());


	}

	/**
	 * Eine Gansadapterschar schnattert.
	 */
	@Test
	public void testGansAdapterSchar() {
		Quakfaehig gansEnte = new GansAdapter(new Gans());
		EntenSchar.hinzufuegen(gansEnte);

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));

		//simulator.simulieren(EntenSchar);

		//call your method here
		simulator.simulieren(gansEnte);

		// Es gab Probleme mit dem Lineseparator
		String abc = "Schnatter" + System.lineSeparator() + "Quakologe: sich als Ente ausgebende Gans hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());


	}

	/**
	 * Eine Stockentenschar quakt.
	 */
	@Test
	public void testStockEntenSchar() {
		Quakfaehig stockEnte = entenfabrik.erzeugeStockEnte();
		EntenSchar.hinzufuegen(stockEnte);

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));

		//call your method here
		simulator.simulieren(stockEnte);

		// Es gab Probleme mit dem Lineseparator
		String abc = "Quak" + System.lineSeparator() + "Quakologe: Stockente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());


	}

	/**
	 * Der Quakologe gibt seine eigene Bezeichnung zurueck.
	 */
	@Test
	public void testQuakologeToString() {
		Quakologe q = new Quakologe();
		assertEquals("Quakologe", q.toString());
	}
	
	/**
	 * Die Gans gibt ihre eigene Bezeichnung zurueck.
	 */
	@Test
	public void testGansToString() {
		Gans g = new Gans();
		assertEquals("Gans", g.toString());
	}

	/**
	 * Registiert eine Moorente beim Senderring und ueberprueft, ob diese registriert wurde.
	 */
	@Test
	public void testSenderRingGetBeobachtende()	{

		SenderRing s = new SenderRing(entenfabrik.erzeugeMoorEnte());

		s.registriereBeobachter(new Quakologe());
		
		assertNotNull(s.getBeobachtende().next());
	}

	/**
	 * Check der korrekten Zaehlweise des Quackzaehlers.
	 */
	@Test
	public void testQuackZaehler()	{
		assertEquals(10, QuakZaehler.getQuaks());
	}
	
	/**
	 * Fuegt dem QuackZaehler eine Moorente hinzu, laesst allen Beobachtern ihren eigenen Typ zukommen und gibt diesen dann aus.
	 */
	@Test
	public void testQuackZaehlerBenachrichtigeBeobachtende()	{
		QuakZaehler q = new QuakZaehler(new MoorEnte());
		q.benachrichtigeBeobachtende();
		assertEquals("Moorente", q.toString());
	}
	
	/**
	 * Benachrichtigt alle beobachtenden Scharen.
	 */
	@Test
	public void testScharBenachrichtigeBeobachtende()	{
		EntenSchar = new Schar();
		EntenSchar.benachrichtigeBeobachtende();
	}
	
	/**
	 * Gibt den Typ der Schar zurueck.
	 */
	@Test
	public void testScharToString()	{
		EntenSchar = new Schar();
		EntenSchar.hinzufuegen(new MoorEnte());
		
		assertEquals("Entenschar", EntenSchar.toString());
	}
	
	/**
	 * Ueberprueft, ob die Entenfabrik auch wirklich eine Stockente erzeugt.
	 */
	@Test
	public void testEntenfabrikErzeugeStockEnte()	{
		Quakfaehig q = new Entenfabrik().erzeugeStockEnte();
		
		if (q instanceof StockEnte) {
			assertTrue(true);
		}
	}
	
	/**
	 * Ueberprueft, ob die Entenfabrik auch wirklich eine Moorente erzeugt.
	 */
	@Test
	public void testEntenfabrikErzeugeMoorEnte()	{
		Quakfaehig q = new Entenfabrik().erzeugeMoorEnte();
		
		if (q instanceof MoorEnte) {
			assertTrue(true);
		}
	}
	
	/**
	 * Ueberprueft, ob die Entenfabrik auch wirklich eine Lockpfeife erzeugt.
	 */
	@Test
	public void testEntenfabrikErzeugeLockPfeife()	{
		Quakfaehig q = new Entenfabrik().erzeugeLockPfeife();
		
		if (q instanceof LockPfeife) {
			assertTrue(true);
		}
	}
	
	/**
	 * Ueberprueft, ob die Entenfabrik auch wirklich eine Gummiente erzeugt.
	 */
	@Test
	public void testEntenfabrikErzeugeGummiEnte()	{
		Quakfaehig q = new Entenfabrik().erzeugeGummiEnte();
		
		if (q instanceof GummiEnte) {
			assertTrue(true);
		}
	}
	
	
	/**
	 * Fuehrt die Entensimulation aus (hauptsaechlich zu Coveragezwecken).
	 */
	@Test
	public void testEntenSimulator()	{
		EntenSimulator.main(null);
	}

	/**
	 * Zuruecksetzen der Konsolenausgabe
	 */
	@After
	public void cleanup()	{
		System.setErr(null);
		System.setOut(null);
	}
}