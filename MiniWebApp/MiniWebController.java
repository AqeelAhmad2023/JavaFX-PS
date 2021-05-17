package MiniWebApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MiniWebController implements Initializable {

    String httpsLink = "https://";
    String addressLink;
    WebEngine engine;
    boolean state = true;
    ArrayList<String> store = new ArrayList<String>();
    int pageNow;


    @FXML TextField addressTextField;
    @FXML WebView myWebView;
    @FXML Button searchButton;
    @FXML private Button pButton;

    @FXML private Button nButton;
    @FXML private Button refreshButton;

    public void search(){
        addressLink = addressTextField.getText().trim();
        engine.load(httpsLink+addressLink);
        store.add(addressLink);
        pButton.setDisable(false);
        nButton.setDisable(true);
        pageNow = store.size()-1;


    }


    public void back(){
        engine.load(httpsLink+ store.get(pageNow-1));
        nButton.setDisable(false);
        if(pageNow == 0){
            pButton.setDisable(true);
        }
        addressTextField.setText(httpsLink+ store.get(pageNow));
        pageNow-=1;

    }
    public void refresh(){
        addressLink = addressTextField.getText().trim();
        engine.load(httpsLink+addressLink);
        store.add(addressLink);
        pButton.setDisable(false);
        nButton.setDisable(true);
        pageNow = store.size()-1;


    }
    public void next(){
        engine.load(httpsLink+ store.get(pageNow));
        pButton.setDisable(false);
        if(pageNow == store.size() - 1){
            nButton.setDisable(true);
        }
        addressTextField.setText(httpsLink+ store.get(pageNow));
        pageNow+=1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = myWebView.getEngine();
        engine.load(httpsLink+"www.google.com");
        nButton.setDisable(true);
        pButton.setDisable(true);
        store.add("www.google.com");
    }

}