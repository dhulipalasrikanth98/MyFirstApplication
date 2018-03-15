package com.java.app;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
	@FXML
	private Label welcome;
	@FXML
	public ChoiceBox<String> choice;
	@FXML
	public TextField text;
	@FXML
	public Button btn;
	private boolean isCelcuis=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {


		choice.getItems().add("farenhiet to celcius");
		choice.getItems().add("celcuis to farenhiet");
		choice.setValue("farenhiet to celcius");
		choice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals("farenhiet to celcius")){
				isCelcuis=true;
			}
			else
				isCelcuis=false;
		});
		btn.setOnAction(event -> {

			convert();
		});



	}

	private void convert() {
		String input=text.getText();
		float newTemparature=0.0f;
		try {
			newTemparature = Float.parseFloat(input);
		}catch(Exception e) {
			warn();
			return;
		}
		float temparature=0.0f;
		if(isCelcuis){
			temparature=(newTemparature*9/5)+32;
		}
		else
			temparature=(newTemparature-32)*5/9;
		display(temparature);
	}

	private void warn() {
		Alert dialog = new Alert(Alert.AlertType.ERROR);
		dialog.setTitle("WARNING");
		dialog.setContentText("PLEASE ENTER THE VALID TEMPARATURE");
		dialog.show();
	}

	private void display(float temparature) {
		String unit=isCelcuis ? "F":"C";
		System.out.println(temparature +" "+unit);
		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Result");
		dialog.setContentText(temparature +" "+unit);
		dialog.show();

	}
}
