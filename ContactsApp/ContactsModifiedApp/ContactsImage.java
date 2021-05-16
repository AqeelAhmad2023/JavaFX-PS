package ContactsModifiedApp;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ContactsImage extends ListCell<ContactsModifiedDetails> {
    private VBox vbox = new VBox(8.0); // 8 points of gap between controls
    private ImageView imageView = new ImageView(); // initially empty
    private Label label = new Label();


    public ContactsImage() {
        vbox.setAlignment(Pos.CENTER); // center VBox contents horizontally

        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100.0); // thumbnail 100 points tall
        vbox.getChildren().add(imageView); // attach to Vbox

        label.setWrapText(true); // wrap if text too wide to fit in label
        label.setTextAlignment(TextAlignment.CENTER); // center text
        vbox.getChildren().add(label); // attach to VBox

        setPrefWidth(USE_PREF_SIZE); // use preferred size for cell width
    }

    // called to configure each custom ListView cell
    @Override
    protected void updateItem(ContactsModifiedDetails item, boolean empty) {
        // required to ensure that cell displays properly
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null); // don't display anything
        }
        else {
            // set ImageView's thumbnail image
            imageView.setImage(new Image(item.getImage()));
            label.setText(item.getLastName()); // configure Label's text
            setGraphic(vbox); // attach custom layout to ListView cell
        }
    }

}
