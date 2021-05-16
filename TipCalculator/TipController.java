package TipCalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentage = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentageVal = new BigDecimal(0.15);

    @FXML
    private Label amountLabel;

    @FXML
    private Label tipPercentage;

    @FXML
    private Label tipLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField amountextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private Button calculateButton;

    @FXML
    void calculateOnClick(ActionEvent event) {
        try{
            BigDecimal amount=new BigDecimal(amountextField.getText());
            BigDecimal tip = amount.multiply(tipPercentageVal);
            BigDecimal total = amount.add(tip);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        }
        catch (NumberFormatException ex){
            amountextField.setText("Enter amount");
            amountextField.selectAll();
            amountextField.requestFocus();
        }
    }

    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        tipPercentageSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldvalue, Number newValue) {
                        tipPercentageVal = BigDecimal.valueOf(newValue.intValue()/100.0);
                        tipPercentage.setText(percentage.format(tipPercentageVal));
                    }
                }


        );
    }


}
