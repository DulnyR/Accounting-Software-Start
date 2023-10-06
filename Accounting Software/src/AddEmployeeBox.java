import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddEmployeeBox {
	
	public void display(String title) throws IOException 
	{	
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);
		window.setMinHeight(300);
		
		Parent root = FXMLLoader.load(getClass().getResource("AddEmployeeBox.fxml"));
		/*
		saveButton.setOnAction(e -> saveButtonClicked());
		*/
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public void saveButtonClicked()
	{
		Employee employee = new Employee();
		/*
		employee.setEmployeeCode(employeeCodeDropdown.getValue());
		employee.setPPSNo(PPSNoField.getValue());
		employee.setSurname(surnameField.getValue());
		employee.setFirstName(firstNameField.getValue());
		employee.setEmploymentID(employmentIDField.getValue());
		employee.setDepartment(departmentDropdown.getValue());
		employee.setCostCentre(costCentreDropdown.getValue());
		employee.setProfile(profileDropdown.getValue());
		employee.setAddress(line1Field.getValue(), line2Field.getValue(), line3Field.getValue(), line4Field.getValue());
		employee.setPostCode(postCodeField.getValue());
		employee.setCounty(countryDropdown.getValue());
		employee.setCountry(countryDropdown.getValue());
		employee.setHousePhone(housePhoneField.getValue());
		employee.setMobilePhone(mobilePhoneField.getValue());
		employee.setEmail(emailField.getValue());
		employee.setPayslipPin(payslipPinField.getValue());
		employee.setGender(genderRadio.getValue());
		employee.setEmploymentType(employmentRadio.getValue());
		*/
	}
}
