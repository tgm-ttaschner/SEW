package ttaschner.calc;

import java.util.List;

/**
 * @author Thomas Taschner
 * @version 11.11.2014
 * 
 * Grundimplementierung des Rechners, in der grundlegende Methoden zum Hinzufuegen, Aendern und Loeschen der Attribute implementiert wurden.
 *
 */
public class Calculator {

	private List<Double> values;

	private double modifier;

	private CalculatorBehaviour calculatorBehaviour;

	/**
	 * @param values die Liste mit den Werten
	 * @param modifier Wert, mit denen die Werte der Liste modifiziert werden
	 * @param calculatorBehaviour das Verhalten des Rechners, die durchzufuehrende Rechenoperation
	 */
	public Calculator(List<Double> values, double modifier, CalculatorBehaviour calculatorBehaviour) {
		this.setValues(values);
		this.setModifier(modifier);
		this.setCalculatorBehaviour(calculatorBehaviour);
	}

	/**
	 * @param value der Wert, der der Liste hinzugefuegt werden soll
	 */
	public void addValue(double value) {
		values.add(value);
	}

	/**
	 * @param value der Wert, der aus der Liste entfernt werden soll
	 */
	public void removeValue(double value) {
		values.remove(value);
	}

	/**
	 * @return values die modifizierte Liste, sollte calculatorBehaviour gesetzt sein. Andernfalls wird die unveraenderte Liste zurueckgegeben
	 */
	public List<Double> calculate() {
		if (calculatorBehaviour != null)	{
			calculatorBehaviour.processCalculations(values, modifier);
		}
		return values;
	}

	/**
	 * @return eine String Repraesentation der Liste
	 */
	public String toString() {
		return values.toString();
	}
	
	/**
	 * @return calculatorBehaviour das Verhalten, anhand dessen der Rechner dann entscheidet, was mit den Input geschehen soll
	 */
	public CalculatorBehaviour getCalculatorBehaviour() {
		return calculatorBehaviour;
	}

	/**
	 * @return die Liste
	 */
	public List<Double> getValues() {
		return values;
	}

	/**
	 * @return den Wert des Modifikators
	 */
	public double getModifier() {
		return modifier;
	}

	/**
	 * @param CALCULATORBEHAVIOUR das Verhalten, anhand dessen der Rechner dann entscheidet, was mit den Input geschehen soll
	 */
	public void setCalculatorBehaviour(final CalculatorBehaviour CALCULATORBEHAVIOUR) {
		this.calculatorBehaviour = CALCULATORBEHAVIOUR;
	}

	/**
	 * @param values die Liste
	 */
	public void setValues(List<Double> values) {
		this.values = values;
	}

	/**
	 * @param modifier der Wert des Modifikators
	 */
	public void setModifier(double modifier) {
		this.modifier = modifier;
	}
}