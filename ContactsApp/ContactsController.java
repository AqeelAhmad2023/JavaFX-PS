package ContactsApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.math.BigDecimal;

public class ContactsController {

    // instance variables for interacting with GUI
    @FXML
    private ListView<ContactDetails> contactListView;

    @FXML
    private TextField fNameTextField;

    @FXML
    private TextField lNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField genderTextField;

    // stores the list of Book Objects
    private final ObservableList<ContactDetails> contacts =
            FXCollections.observableArrayList();


    @FXML
    private void onClickAdd(ActionEvent event) {
        try {
            if (fNameTextField.getText().equals("") || fNameTextField.getText().equals("fill this field") || lNameTextField.getText().equals("")) {
                throw new Exception();
            }
            ContactDetails newContact = new ContactDetails(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText(), genderTextField.getText());


            contacts.removeIf(i -> i.getFirstName().equals(newContact.getFirstName()) && i.getLastName().equals(newContact.getLastName()));

            contacts.add(newContact);

            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");
            genderTextField.setText("");

        } catch (Exception ex) {
            fNameTextField.setText("Required");
            lNameTextField.setText("Required");
            phoneTextField.setText("Required");
            emailTextField.setText("Required");
            genderTextField.setText("Required");
        }
    }

    @FXML
    private void onClickDelete(ActionEvent event) {
        try {
            ContactDetails newContact = new ContactDetails(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText(), genderTextField.getText());

            contacts.removeIf(i -> i.getFirstName().equals(newContact.getFirstName()) && i.getLastName().equals(newContact.getLastName()));
            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");
            genderTextField.setText("");

        } catch (NumberFormatException ex) {
            fNameTextField.setText("Not found in the directory");
            lNameTextField.setText("Not found in the directory");

        }
    }

    // initialize controller
    public void initialize() {
        // populate the ObservableList<Book>
        ContactDetails one = new ContactDetails("Aqeel", "Ahmad", "+992005875995", "abc@gmail.com", "male");
        contacts.add(one);

        contactListView.setItems(contacts); // bind booksListView to books

        // when ListView selection changes, show large cover in ImageView
        contactListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<ContactDetails>() {
                            @Override
                            public void changed(ObservableValue<? extends ContactDetails> ov,
                                                ContactDetails oldValue, ContactDetails newValue) {
                                fNameTextField.setText(newValue.getFirstName());
                                lNameTextField.setText(newValue.getLastName());
                                phoneTextField.setText((newValue.getPhoneNumber()));
                                emailTextField.setText(newValue.getEmail());
                                genderTextField.setText(newValue.getGender());

                            }
                        }
                );
    }
}

