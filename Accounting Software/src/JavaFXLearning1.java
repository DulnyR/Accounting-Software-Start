import java.io.IOException;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class JavaFXLearning1 extends Application {

	Stage window;
    Button epdButton, addEmployeeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Payroll Program");
        epdButton = new Button("Edit Payroll Dates");
        addEmployeeButton = new Button("Add employee");

        epdButton.setOnAction(e -> {
        	EditPayrollDatesBox epdBox = new EditPayrollDatesBox();
            epdBox.display("Edit Payroll Dates");
        });
        
        addEmployeeButton.setOnAction(e -> {
        	AddEmployeeBox employeeBox = new AddEmployeeBox();
        	try 
        	{
				employeeBox.display("Add employee");
			} catch (IOException e1) {e1.printStackTrace();}
        });

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(epdButton, addEmployeeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

}







