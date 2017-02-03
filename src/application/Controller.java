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
    private void processAC(ActionEvent event) {
        if (start) {
            output.setText("0");
        }

        String value = "0";
        output.setText("");
    }
    
    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
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
		    if (operator.isEmpty())
		        return;

		    output.setText(String.valueOf(calc.calculate(number1, Double.parseDouble(output.getText()), operator)));
		    operator = "";
		    start = true;
		}
    }
}
