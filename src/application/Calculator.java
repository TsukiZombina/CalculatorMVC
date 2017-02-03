/**
* The Calculator program implements an application that
* displays "a simple graphic calculator with +, -, *, / operands.
*
* @author  Zelzin Márquez
* @version 1.0
* @since   2017-02-03 
*/

package application;

public class Calculator {
	/**
	   * This method is used to make tha arithmetic calculations.
	   * Supports +, -, *, / operands.
	   * @param number1 First double number to calculate operaton
	   * @param number2  Second double number to calculate operaton
	   * @return double This returns the result of number1 operand number2.
	   */
	public double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 0;

                return number1 / number2;
        }

        System.out.println("Unknown operator - " + operator);
        return 0;
    }
}
