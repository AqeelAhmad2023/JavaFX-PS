package ColorChooser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.text.NumberFormat;

public class ColorChooserController {


    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private TextField redTextField;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private Rectangle colorRectangle;
    @FXML
    private Label resultTextField;

    float redV;
    float greenV;
    float blueV;


    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;


    public void initialize() {
        //bind TextField values to corresponding Slider values
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getNumberInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getNumberInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getNumberInstance());


        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue));
                    }
                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue));
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue));
                    }
                }
        );


        redTextField.textProperty().addListener((args, oldValue, newValue) -> {
            float val;
            try {
                val = Float.parseFloat(newValue.trim());
            } catch (Exception e) {
                val = 0;
            }
            if (val < 0 || val > 255) {
                val = 0;
            }
            val = (float) (Math.round(val * 100.0) / 100.0);
            red = (int) val;
            colorRectangle.setFill(Color.rgb(red, green, blue));
            resultTextField.setText("(" + val + ", " + green + ", " + blue + ")");
        });
        blueTextField.textProperty().addListener((args, oldValue, newValue) -> {
            float val;
            try {
                val = Float.parseFloat(newValue.trim());
            } catch (Exception e) {
                val = 0;
            }
            if (val < 0 || val > 255) {
                val = 0;
            }
            val = (float) (Math.round(val * 100.0) / 100.0);
            blue = (int) val;
            colorRectangle.setFill(Color.rgb(red, green, blue));
            resultTextField.setText("(" + red + ", " + green + ", " + val + ")");
        });
        greenTextField.textProperty().addListener((args, oldValue, newValue) -> {
            float val;
            try {
                val = Float.parseFloat(newValue.trim());
            } catch (Exception e) {
                val = 0;
            }
            if (val < 0 || val > 255) {
                val = 0;
            }
            val = (float) (Math.round(val * 100.0) / 100.0);
            green = (int) val;
            colorRectangle.setFill(Color.rgb(red, green, blue));
            resultTextField.setText("(" + red + ", " + val + ", " + blue + ")");
        });


    }
}