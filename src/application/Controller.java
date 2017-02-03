/**
* The Calculator program implements an application that
* displays "a simple graphic calculator with +, -, *, / operands.
*
* @author  Zelzin Márquez
* @version 1.0
* @since   2017-02-03 
*/

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	@FXML
    private Text output;

    private double number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Calculator calc = new Calculator();
    
    @FXML
    /**
	   * This method is used to process the input of button AC
	   * wich purposse is to clear the data from the "display"
	   * @param event The event press button to process
	   */
    private void processAC(ActionEvent event) {
        if (start) {
            output.setText("0");
        }

        String value = "0";
        output.setText("");
    }
    
    @FXML
    /**
	   * This method is used to process the input of pad numbers
	   * that contains the value to use in the calculation
	   * @param event The event press button to process
	   */
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    /**
	   * This method is used to process the input of pad operands
	   * that contains the value to use in the calculation
	   * @param event The event press button to process
	   */
    private void processOperator(ActionEvent event) {
    	if (start) {
            output.setText("0");
            start = false;
        }
    	
    	String value = ((Button)event.getSource()).getText();
    	
    	if (!"=".equals(value)) {
		    if (!operator.isEmpty()) 
		    	if(output.getText().equals(""))
		    		return;

		    operator = value;
		    number1 = Double.parseDouble(output.getText());
		    output.setText("");
		}
		else {
		    if (operator.isEmpty() || output.getText().equals(""))
		    	return;

		    output.setText(String.valueOf(calc.calculate(number1, Double.parseDouble(output.getText()), operator)));
		    operator = "";
		    start = true;
		}
    }
}
