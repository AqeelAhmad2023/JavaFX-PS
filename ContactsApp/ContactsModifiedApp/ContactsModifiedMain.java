package ContactsModifiedApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactsModifiedMain extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ContactsappModified.fxml"));
        Scene scene=new Scene(root);
        stage.setTitle("Contacts App");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
