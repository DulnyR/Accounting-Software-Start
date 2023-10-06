import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class EditPayrollDatesBox {
	
	ComboBox<Integer> periodChoiceBox, insWeeksChoiceBox;
	DatePicker myDatePicker;
	TableView<PayrollDate> table;

	@SuppressWarnings("unchecked")
	public void display(String title)
	{	
		Stage window = new Stage();
		myDatePicker = new DatePicker();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);
		window.setMinHeight(300);
		
		TableColumn<PayrollDate, Integer> periodNumberColumn = new TableColumn<>("Period Number");
		periodNumberColumn.setMinWidth(50);
		periodNumberColumn.setCellValueFactory(new PropertyValueFactory<>("periodNumber"));
		periodNumberColumn.setSortType(TableColumn.SortType.ASCENDING);
		
		TableColumn<PayrollDate, Integer> insWeeksColumn = new TableColumn<>("Insurance Weeks");
		insWeeksColumn.setMinWidth(50);
		insWeeksColumn.setCellValueFactory(new PropertyValueFactory<>("insWeeks"));
		
		TableColumn<PayrollDate, LocalDate> payrollDateColumn = new TableColumn<>("Payroll Date");
		payrollDateColumn.setMinWidth(100);
		payrollDateColumn.setCellValueFactory(new PropertyValueFactory<>("payrollDate"));
		
		TableColumn<PayrollDate, LocalDate> chequeDateColumn = new TableColumn<>("Cheque Date");
		chequeDateColumn.setMinWidth(100);
		chequeDateColumn.setCellValueFactory(new PropertyValueFactory<>("chequeDate"));
		
		TableColumn<PayrollDate, LocalDate> giroDateColumn = new TableColumn<>("Giro Date");
		giroDateColumn.setMinWidth(100);
		giroDateColumn.setCellValueFactory(new PropertyValueFactory<>("giroDate"));
		
		TableColumn<PayrollDate, LocalDate> bankDateColumn = new TableColumn<>("Bank Date");
		bankDateColumn.setMinWidth(100);
		bankDateColumn.setCellValueFactory(new PropertyValueFactory<>("bankDate"));
		
		TableColumn<PayrollDate, LocalDate> costYearColumn = new TableColumn<>("Cost Year");
		costYearColumn.setMinWidth(100);
		costYearColumn.setCellValueFactory(new PropertyValueFactory<>("costYear"));
		
		TableColumn<PayrollDate, LocalDate> costPeriodColumn = new TableColumn<>("Cost Period");
		costPeriodColumn.setMinWidth(100);
		costPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("costPeriod"));
		
		periodChoiceBox = new ComboBox<>();
		for(int i = 1; i <= 12; i++)
		{
			periodChoiceBox.getItems().add(i);
		}
		
		insWeeksChoiceBox = new ComboBox<>();
		for(int i = 1; i <= 5; i++)
		{
			insWeeksChoiceBox.getItems().add(i);
		}
		
		table = new TableView<>();
		table.setItems(getPayrollDates());
		table.getColumns().addAll(periodNumberColumn, insWeeksColumn, payrollDateColumn, chequeDateColumn, giroDateColumn,
									bankDateColumn, costYearColumn, costPeriodColumn);
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearButtonClicked());
		
		Label periodLabel = new Label("Period");
		Label insWeeksLabel = new Label("Insurance Weeks");
		Label payrollDateLabel = new Label("Payroll Date");
		
		HBox selection = new HBox(10);
		selection.setPadding(new Insets(20, 20, 20, 20));
		selection.getChildren().addAll(periodLabel, periodChoiceBox, insWeeksLabel, insWeeksChoiceBox, 
										payrollDateLabel, myDatePicker, addButton, deleteButton, clearButton, closeButton);
		selection.setAlignment(Pos.CENTER_LEFT);
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(table, selection);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 900, 500);
		window.setScene(scene);
		window.showAndWait();
	}

	public static ObservableList<PayrollDate> getPayrollDates(){
        ObservableList<PayrollDate> payrollDates = FXCollections.observableArrayList();
        payrollDates.add(new PayrollDate(1, 4, LocalDate.now()));
        payrollDates.add(new PayrollDate(2, 5, LocalDate.now()));
        return payrollDates;
    }
	
	public void addButtonClicked(){
		LocalDate chosenDate = myDatePicker.getValue();
		if(!periodChoiceBox.getSelectionModel().isEmpty() || !insWeeksChoiceBox.getSelectionModel().isEmpty() ||
				chosenDate != null)
		{
			int periodNumber = periodChoiceBox.getValue();
	        int insWeeks = insWeeksChoiceBox.getValue();
	        LocalDate dayBefore = chosenDate.minusDays(1);
			PayrollDate payrollDate = new PayrollDate();
			
			payrollDate.setPeriodNumber(periodNumber);
			payrollDate.setInsWeeks(insWeeks);
			payrollDate.setPayrollDate(chosenDate);
			payrollDate.setChequeDate(dayBefore);
			payrollDate.setGiroDate(dayBefore);
			payrollDate.setBankDate(dayBefore);
			payrollDate.setCostYear(dayBefore.getYear());
			payrollDate.setCostPeriod(periodNumber);
			table.getItems().add(payrollDate);
			
			periodChoiceBox.valueProperty().set(null);
			insWeeksChoiceBox.valueProperty().set(null);
			myDatePicker.valueProperty().set(null);
		}
    }

    public void deleteButtonClicked(){
        ObservableList<PayrollDate> dateSelected, allDates;
        allDates = table.getItems();
        dateSelected = table.getSelectionModel().getSelectedItems();
        dateSelected.forEach(allDates::remove);
    }
    
    public void clearButtonClicked() {
		table.getItems().clear();
	}
}
