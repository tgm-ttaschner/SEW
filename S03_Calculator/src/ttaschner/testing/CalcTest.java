package ttaschner.testing;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import ttaschner.calc.*;

/**
 * @author Thomas Taschner
 * @version 11.11.2014
 * 
 * Test der korrekten Funktionalitaet des Rechners. Getestet werden alle moeglichen Faelle, mit jedem Verhalten des Rechners, die eintreten koennen.
 *
 */
public class CalcTest {

	List<Double> l;

	/**
	 * Liste wird mit den Zahlen 1-10 immer wieder aufs Neue befuellt.
	 */
	@Before
	public void setup()	{
		l = new ArrayList<Double>();
		for (int i = 1; i <= 10; i++)	{
			l.add((double) i);
		}
	}

	/**
	 * Das Verhalten wird auf null gesetzt (den Part mit dem Vergleichen spar ich mir, funktioniert eh immer nach dem gleichen Prinzip)
	 */
	@Test
	public void testNullBehaviour() {
		Calculator c = new Calculator(l, 10.0, null);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]");
	}

	/**
	 * Der Modifier wird ausgelesen
	 */
	@Test
	public void testGetModifier() {
		Calculator c = new Calculator(l, 10.0, null);
		assertEquals(c.getModifier(), 10.0, 0);
	}

	/**
	 * Das Verhalten wird ausgelesen
	 */
	@Test
	public void testGetBehaviour() {
		AdditionCalculator a = new AdditionCalculator();
		Calculator c = new Calculator(l, 10.0, a);
		assertEquals(c.getCalculatorBehaviour(),  a);
	}

	/**
	 * Das Verhalten wird ausgelesen (null)
	 */
	@Test
	public void testGetNullBehaviour() {
		Calculator c = new Calculator(l, 10.0, null);
		assertEquals(c.getCalculatorBehaviour(), null);
	}

	/**
	 * Der Wert 5.0 wird aus der ArrayList ueber die eigene Loeschmethode entfernt.
	 */
	@Test
	public void testRemoveValue() {
		Calculator c = new Calculator(l, 10.0, null);
		c.removeValue(5.0);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 10.0]");
	}

	/**
	 * Der Wert 123.4 wird der Liste hinzugefuegt, das Vehalten ist: addieren
	 */
	@Test
	public void testAddAddNormalValue() {
		Calculator c = new Calculator(l, 10.0, new AdditionCalculator());
		c.addValue(123.4);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 123.4]");
	}

	/**
	 * Ein null Wert wird der Liste hinzugeuegt, das Verhalten ist: addieren
	 * Eine NullPointerException wird erwartet.
	 */
	@SuppressWarnings("null")
	@Test (expected = NullPointerException.class)
	public void testAddAddNullValue() {
		Calculator c = new Calculator(l, 10.0, new AdditionCalculator());
		c.addValue((Double) null);
	}

	/**
	 * Alle Werte der Liste werden mit dem Wert von modifier addiert
	 */
	@Test
	public void testAddAddCalcPos() {
		Calculator c = new Calculator(l, 10.0, new AdditionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0]");
	}

	/**
	 * Alle Werte der Liste werden mit dem negativen Wert von modifier addiert
	 */
	@Test
	public void testAddAddCalcNeg() {
		Calculator c = new Calculator(l, -10.0, new AdditionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[-9.0, -8.0, -7.0, -6.0, -5.0, -4.0, -3.0, -2.0, -1.0, 0.0]");
	}

	/**
	 * Alle Werte der Liste werden mit dem Wert 0 addiert
	 */
	@Test
	public void testAddAddCalc0() {
		Calculator c = new Calculator(l, 0.0, new AdditionCalculator());
		c.calculate();
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]");
	}

	/**
	 * Der Wert 123.4 wird der Liste hinzugefuegt, das Vehalten ist: subtrahieren
	 */
	@Test
	public void testSubAddNormalValue() {
		Calculator c = new Calculator(l, 10.0, new SubstractionCalculator());
		c.addValue(123.4);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 123.4]");
	}

	/**
	 * Ein null Wert wird der Liste hinzugeuegt, das Verhalten ist: subtrahieren
	 * Eine NullPointerException wird erwartet.
	 */
	@SuppressWarnings("null")
	@Test (expected = NullPointerException.class)
	public void testSubAddNullValue() {
		Calculator c = new Calculator(l, 10.0, new SubstractionCalculator());
		c.addValue((Double) null);
	}

	/**
	 * Allen Werten der Liste wird der Wert von modifier subtrahiert
	 */
	@Test
	public void testSubCalcPos() {
		Calculator c = new Calculator(l, 10.0, new SubstractionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[-9.0, -8.0, -7.0, -6.0, -5.0, -4.0, -3.0, -2.0, -1.0, 0.0]");
	}

	/**
	 * Allen Werten der Liste wird der negative Wert von modifier subtrahiert
	 */
	@Test
	public void testSubCalcNeg() {
		Calculator c = new Calculator(l, -10.0, new SubstractionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0]");
	}

	/**
	 * Allen Werten der Liste wird der Wert 0 subtrahiert
	 */
	@Test
	public void testSubCalc0() {
		Calculator c = new Calculator(l, 0.0, new SubstractionCalculator());
		c.calculate();
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]");
	}

	/**
	 * Der Wert 123.4 wird der Liste hinzugefuegt, das Vehalten ist: multiplizieren
	 */
	@Test
	public void testMulAddNormalValue() {
		Calculator c = new Calculator(l, 10.0, new MultiplicationCalculator());
		c.addValue(123.4);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 123.4]");
	}

	/**
	 * Ein null Wert wird der Liste hinzugeuegt, das Verhalten ist: multiplizieren
	 * Eine NullPointerException wird erwartet.
	 */
	@SuppressWarnings("null")
	@Test (expected = NullPointerException.class)
	public void testMulAddNullValue() {
		Calculator c = new Calculator(l, 10.0, new MultiplicationCalculator());
		c.addValue((Double) null);
	}

	/**
	 * Alle Werte der Liste werden mit dem Wert von modifier multipliziert
	 */
	@Test
	public void testMulCalcPos() {
		Calculator c = new Calculator(l, 10.0, new MultiplicationCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0]");
	}

	/**
	 * Alle Werte der Liste werden mit dem negativen Wert von modifier multipliziert
	 */
	@Test
	public void testMulCalcNeg() {
		Calculator c = new Calculator(l, -10.0, new MultiplicationCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[-10.0, -20.0, -30.0, -40.0, -50.0, -60.0, -70.0, -80.0, -90.0, -100.0]");
	}

	/**
	 * Alle Werte der Liste werden mit dem Wert 0 multipliziert
	 */
	@Test
	public void testMulCalc0() {
		Calculator c = new Calculator(l, 0.0, new MultiplicationCalculator());
		c.calculate();
		assertEquals(c.toString(), "[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]");
	}

	/**
	 * Der Wert 123.4 wird der Liste hinzugefuegt, das Vehalten ist: dividieren
	 */
	@Test
	public void testDivAddNormalValue() {
		Calculator c = new Calculator(l, 10.0, new DivisionCalculator());
		c.addValue(123.4);
		assertEquals(c.toString(), "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 123.4]");
	}

	/**
	 * Ein null Wert wird der Liste hinzugeuegt, das Verhalten ist: dividieren
	 * Eine NullPointerException wird erwartet.
	 */
	@SuppressWarnings("null")
	@Test (expected = NullPointerException.class)
	public void testDivAddNullValue() {
		Calculator c = new Calculator(l, 10.0, new DivisionCalculator());
		c.addValue((Double) null);
	}

	/**
	 * Alle Werte der Liste werden mit dem Wert von modifier dividiert
	 */
	@Test
	public void testDivCalcPos() {
		Calculator c = new Calculator(l, 10.0, new DivisionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]");
	}

	/**
	 * Alle Werte der Liste werden mit dem negativen Wert von modifier dividiert
	 */
	@Test
	public void testDivCalcNeg() {
		Calculator c = new Calculator(l, -10.0, new DivisionCalculator());
		c.calculate();
		assertEquals(c.getValues().toString(), "[-0.1, -0.2, -0.3, -0.4, -0.5, -0.6, -0.7, -0.8, -0.9, -1.0]");
	}

	/**
	 * Alle Werte der Liste werden durch 0 dividiert
	 */
	@Test
	public void testDivCalc0() {
		Calculator c = new Calculator(l, 0.0, new DivisionCalculator());
		c.calculate();
		assertEquals(c.toString(), "[" + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + "]");
	}

	/**
	 * Der Liste wird der Wert 0 hinzugefuegt, um anschließend alle Werte durch 0 zu dividieren
	 */
	@Test
	public void testDivCalc0durch0() {
		Calculator c = new Calculator(l, 0.0, new DivisionCalculator());
		c.addValue(0.0);
		c.calculate();
		assertEquals(c.toString(), "[" + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY + ", " + Double.NaN + "]");
	}
}