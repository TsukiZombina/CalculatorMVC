/**
* The Calculator program implements an application that
* displays "a simple graphic calculator with +, -, *, / operands.
*
* @author  Zelzin Márquez
* @version 1.0
* @since   2017-02-03 
*/

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	/**
	   * This method load the window view of the calculator
	   * @param Stage primary stage to show the view
	   */
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("WindowView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	   * This method launch the application
	   * @param String of arguments
	   */
	public static void main(String[] args) {
		launch(args);
	}
}
