package EnhancedTipCalculator;

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

public class EnhancedTipController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentage = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentageVal = new BigDecimal(0.15);

    @FXML
    private Button calcButton;

    @FXML
    private TextField individualTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField memberTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label amountLabel;

    @FXML
    private Label memberLabel;

    @FXML
    private Label tipPercentLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Label individualLabel;

    @FXML
    private Slider tipSlider;

    @FXML
    void onClick(ActionEvent event) {
        try{
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal num = new BigDecimal(memberTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentageVal);
            BigDecimal total = amount.add(tip);
            BigDecimal individualAmount = amount.divide(num);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
            individualTextField.setText(currency.format(individualAmount));
        }
        catch (NumberFormatException ex){
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }

    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        tipSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldvalue, Number newValue) {
                        tipPercentageVal = BigDecimal.valueOf(newValue.intValue()/100.0);
                        tipPercentLabel.setText(percentage.format(tipPercentageVal));
                    }
                }


        );
    }

}
