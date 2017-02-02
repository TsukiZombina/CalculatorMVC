package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	@FXML
    private Text output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Calculator model = new Calculator();
    
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
    	
    	if(output.getText() == ""){
    		String value = "0";
    	}
    	
    	String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
