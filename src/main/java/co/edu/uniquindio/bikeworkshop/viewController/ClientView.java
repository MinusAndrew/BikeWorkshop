package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.ClientController;
import co.edu.uniquindio.bikeworkshop.model.Client;
import co.edu.uniquindio.bikeworkshop.model.Workshop;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.alert;

public class ClientView implements Initializable {

    private Workshop theWorkshop;
    //Needed controller, create a new class and interact with model from there.
    private final ClientController clientController = new ClientController();

    //Vars linked to their respective fxml
    @FXML
    private Button backButton;

    @FXML
    private TableView<Client> tblClient;

    @FXML
    private TableColumn<Client, String> colName, colId, colPhoneNum, colAddress;

    @FXML
    private TextField txtName, txtId, txtPhoneNum, txtAddress;

    //need it for the table to know what to expect
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPhoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    //Called before in order to fill the table
    public void fillUpTable(){
        tblClient.getItems().addAll(clientController.clientList(theWorkshop));
    }

    public void saveClient(){
        //Grabs data
        String name = grabName();
        String id = grabId();
        String phoneNum = grabPhoneNum();
        String address = grabAddress();

        //checks
        if (name.isEmpty() || id.isEmpty() || phoneNum.isEmpty() || address.isEmpty()) {
            alert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor llena todos los campos.");
            return;
        }


        boolean itExists = clientController.checkClientId(theWorkshop, id);

        if (itExists) {
            alert(Alert.AlertType.ERROR, "Duplicado", "Ya existe un cliente con esa identificación.");
            return;
        }

        //here is the mess
        Client tmp = clientController.addClient(theWorkshop, name, id, phoneNum, address);
        clearForum();

        alert(Alert.AlertType.INFORMATION, "Guardado", "Cliente registrado correctamente.");

        tblClient.getItems().add(tmp);
    }

    // it just clears the textlables.
    public void clearForum(){
        txtName.clear();
        txtId.clear();
        txtAddress.clear();
        txtPhoneNum.clear();
    }

    // ahh back button
    public void backToMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("MainView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);

            MainView mainView = fxmlLoader.getController();
            mainView.setTheWorkshop(theWorkshop);

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Taller de Bicicletas");
        } catch (Exception e) {
            alert(Alert.AlertType.ERROR, "Error", "No se pudo volver al menú.\n" + e.getMessage());
        }
    }


    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }

    // simple methods
    public String grabName(){
        return txtName.getText().trim();
    }

    public String grabAddress(){
        return txtAddress.getText().trim();
    }

    public String grabId(){
        return txtId.getText().trim();
    }

    public String grabPhoneNum(){
        return txtPhoneNum.getText().trim();
    }

}

