package testing;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import quack.*;

public class TestQuack extends MoorEnte {
	
	EntenSimulator simulator;
	AbstrakteEntenFabrik entenfabrik;
	
	Schar EntenSchar;
	
	@Before
	public void setup()	{
		simulator = new EntenSimulator();
		entenfabrik = new ZaehlendeEntenFabrik();
		EntenSchar = new Schar();
	}
	
	@Test
	public void testMoorEntenSchar()	{
		
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		EntenSchar.hinzufügen(moorEnte);
		
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));
		
		//simulator.simulieren(EntenSchar);

		//call your method here
		simulator.simulieren(moorEnte);
		
		// Es gab Probleme mit dem Lineseparator
		String abc = "Quak" + System.lineSeparator() + "Quakologe: Moorente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());
	}
	
	@Test
	public void testLockPfeifenSchar() {
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		EntenSchar.hinzufügen(lockPfeife);
		
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));
		
		//simulator.simulieren(EntenSchar);

		//call your method here
		simulator.simulieren(lockPfeife);
		
		// Es gab Probleme mit dem Lineseparator
		String abc = "Kwaak" + System.lineSeparator() + "Quakologe: Lockpfeife hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());
		
		
	}
	
	@Test
	public void testGummiEntenSchar() {
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		EntenSchar.hinzufügen(gummiEnte);
		
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));
		
		//simulator.simulieren(EntenSchar);

		//call your method here
		simulator.simulieren(gummiEnte);
		
		// Es gab Probleme mit dem Lineseparator
		String abc = "Quietsch" + System.lineSeparator() + "Quakologe: Gummiente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());
		
		
	}
	
	@Test
	public void testGansAdapterSchar() {
		Quakfaehig gansEnte = new GansAdapter(new Gans());
		EntenSchar.hinzufügen(gansEnte);
		
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
	
	@Test
	public void testStockEntenSchar() {
		Quakfaehig stockEnte = entenfabrik.erzeugeStockEnte();
		EntenSchar.hinzufügen(stockEnte);
		
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setOut(new PrintStream(outContent));
		
		//simulator.simulieren(EntenSchar);

		//call your method here
		simulator.simulieren(stockEnte);
		
		// Es gab Probleme mit dem Lineseparator
		String abc = "Quak" + System.lineSeparator() + "Quakologe: Stockente hat gerade gequakt." + System.lineSeparator();

		//check if your error message is in the output variable
		assertEquals(abc, outContent.toString());
		
		
	}
	
	@Test
	public void testQuakologeToString() {
		Quakologe q = new Quakologe();
		assertEquals("Quakologe", q.toString());
	}
	
	@Test
	public void testGansToString() {
		Gans g = new Gans();
		assertEquals("Gans", g.toString());
	}
	
	@Test
	public void testSenderRingGetBeobachtende()	{
		
		SenderRing s = new SenderRing(new MoorEnte());
		
		s.registriereBeobachter(new Quakologe());
		
		System.out.println(s.getBeobachtende().next().toString());

		//check if your error message is in the output variable
		assertNotNull(s.getBeobachtende().next());
	}
	
	@Test
	public void testQuackZaehler()	{
		
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		//EntenSchar.hinzufügen(moorEnte);
		
		//Quakologe quakologe = new Quakologe();
		//EntenSchar.registriereBeobachter(quakologe);
		
		//call your method here
		//simulator.simulieren(moorEnte);
		
		
		
		QuakZaehler z = new QuakZaehler(moorEnte);
		
		//z.quaken();
		//z.quaken();

		//check if your error message is in the output variable
		assertEquals(1, QuakZaehler.getQuaks());
	}
	
	@After
	public void cleanup()	{
		System.setErr(null);
		System.setOut(null);
	}
}