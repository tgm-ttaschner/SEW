package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

import quack.*;

public class TestQuack {
	
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
	public void testMoorEntenSchar() {
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		EntenSchar.hinzufügen(moorEnte);
		
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		simulator.simulieren(EntenSchar);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//redirect the System-output (normaly the console) to a variable
		System.setErr(new PrintStream(outContent));

		//call your method here
		simulator.simulieren(moorEnte);

		//check if your error message is in the output variable
		assertEquals("Fehlerhafte Parameter!", outContent.toString());
	}
	
	@Test
	public void testLockPfeifenSchar() {
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		EntenSchar.hinzufügen(lockPfeife);
	}
}