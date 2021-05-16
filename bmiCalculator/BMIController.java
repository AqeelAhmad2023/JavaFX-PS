package bmiCalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {

    ObservableList<String> weightChoice = FXCollections.observableArrayList("kgs", "lbs");
    ObservableList<String> heightChoice = FXCollections.observableArrayList("in", "m");


    @FXML
    private Label weightLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label bmiLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Button calcButton;

    @FXML
    private ChoiceBox<String> weightDropDown;

    @FXML
    private ChoiceBox<String> heightDropDown;

    @FXML
    private TextField resultTextField;

    @FXML
    void onClick(ActionEvent event) {
        try {
            String result = "";
            double valueBMI = 0;

            double height = Double.parseDouble(heightTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());


            if (weightDropDown.getValue().equals("kgs") && heightDropDown.getValue().equals("m")) {
                valueBMI = weight / Math.pow(height, 2);


            } else if (weightDropDown.getValue().equals("lbs") && heightDropDown.getValue().equals("in")) {
                valueBMI = 703 * (weight / Math.pow(height, 2));

            } else {
                result = "Incorrect Metrics";
            }

            if (valueBMI < 18.5) {
                result = "Underweight";
            } else if (valueBMI >= 18.5 && valueBMI <= 24.9) {
                result = "Normal";
            } else if (valueBMI >= 25 && valueBMI <= 29.9) {
                result = "Overweight";
            } else if (valueBMI > 30) {
                result = "Obese";
            }

            bmiTextField.setText(String.format("%.2f", valueBMI));
            resultTextField.setText(String.format("%s", result));

        } catch (NumberFormatException e) {
            weightTextField.setText("Error");
            heightTextField.setText("Error");

        }
    }

    public void initialize() {

        heightDropDown.setValue(" ");
        heightDropDown.setItems(heightChoice);

        heightDropDown.setValue(" ");
        weightDropDown.setItems(weightChoice);

    }

}
