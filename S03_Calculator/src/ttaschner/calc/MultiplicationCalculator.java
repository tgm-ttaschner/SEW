package ttaschner.calc;

import java.util.List;

/**
 * @author Thomas Taschner
 * @version 11.11.2014
 * 
 * Implementierung des Rechner Interfaces.
 * Alle Werte der Liste werden mit Hilfe von processCalculations mit dem Wert von modifier modifiziert (hier: multipliziert).
 *
 */
public class MultiplicationCalculator implements CalculatorBehaviour {
	/**
	 * @param values die Liste mit den Werten
	 * @param modifier Wert, mit denen die Werte der Liste modifiziert werden
	 * @return values die Liste mit den veraenderten Werten
	 */
	public List<Double> processCalculations(List<Double> values, double modifier) {
		for (int i = 0; i < values.size(); i++)	{
			values.set(i, values.get(i) * modifier);
		}
		return values;
	}
}