package ColorChooser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorChooserMain extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ColorChooserapp.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Color Chooser App");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }

}
