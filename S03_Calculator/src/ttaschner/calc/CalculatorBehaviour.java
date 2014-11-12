package ttaschner.calc;

import java.util.List;

/**
 * @author Thomas Taschner
 * @version 11.11.2014
 * 
 * Interface des Rechners, alle Werte der Liste werden mit Hilfe von processCalculations mit dem Wert von modifier modifiziert (addiert, subtrahiert, multipliziert bzw. dividiert).
 *
 */
public interface CalculatorBehaviour {

	/**
	 * @param values die Liste mit den Werten
	 * @param modifier Wert, mit denen die Werte der Liste modifiziert werden
	 * @return die Liste mit den modifizierten Werten
	 */
	public List<Double> processCalculations(List<Double> values, double modifier);

}