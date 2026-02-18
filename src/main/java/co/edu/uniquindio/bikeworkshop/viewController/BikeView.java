package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.BikeController;
import co.edu.uniquindio.bikeworkshop.model.*;
import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
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

public class BikeView implements Initializable {
    private Workshop theWorkshop;

    private final BikeController bikeController = new BikeController();

    @FXML
    private Button backButton;

    @FXML
    private TableView<Bike> tblBike;

    @FXML
    private TableColumn<Bike, String> colId, colBrand, colColor, colYear, colType;

    @FXML
    private TextField txtSerialId, txtBrand, txtColor, txtYear, txtClientId;

    @FXML
    private ChoiceBox<String> BikeTypeBox;

    private final BikeType[] bikeTypes = BikeType.values();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        BikeTypeBox.getItems().addAll(getAllBikeType());
        setupBikeTables(colId, colBrand, colColor, colYear, colType);
        BikeTypeBox.setValue("RUTA");
    }

    public static void setupBikeTables(TableColumn<Bike, String> colId, TableColumn<Bike, String> colBrand, TableColumn<Bike, String> colColor, TableColumn<Bike, String> colYear, TableColumn<Bike, String> colType) {
        colId.setCellValueFactory(new PropertyValueFactory<>("serialId"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colType.setCellValueFactory(new PropertyValueFactory<>("bikeType"));
    }

    public void fillUpTable(){
        tblBike.getItems().addAll(bikeController.bikeList(theWorkshop));
    }

    public void saveBike(){
        String serialId = grabSerialId();
        String brand = grabBrand();
        String color = grabColor();
        int year = grabYear();
        String clientId = grabClientId();
        BikeType bikeOptions = BikeType.valueOf(BikeTypeBox.getValue());

        Client client = getClientFromId(theWorkshop, clientId);

        if (year < 1990 || year >= 7270){
            alert(Alert.AlertType.WARNING, "Año Invalido", "ingrese un año valido");
            return;
        }

        if(serialId.isEmpty() || brand.isEmpty() || color.isEmpty() || clientId.isEmpty()){
            alert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor llena todos los campos.");
            return;
        }

        boolean itExist = bikeController.checkBikeSerial(theWorkshop, serialId);
        if(itExist){
            alert(Alert.AlertType.ERROR, "Duplicado", "Ya existe una bicicleta con esa identificación.");
            return;
        }

        if (client != null){
            Bike tmp = bikeController.addBike(theWorkshop, year, brand, color, serialId, bikeOptions, client);
            clearForum();
            alert(Alert.AlertType.INFORMATION, "Guardado", "Bicicleta registrada correctamente.");
            tblBike.getItems().add(tmp);
        }
        else {
            alert(Alert.AlertType.ERROR, "Cliente Invalido", "No hay cliente con dicha indentificacion.");
        }

    }

    public Client getClientFromId(Workshop theWorkshop, String id){
        return bikeController.searchClient(theWorkshop, id);
    }

    public void clearForum(){
        txtYear.clear();
        txtColor.clear();
        txtBrand.clear();
        txtSerialId.clear();
        txtClientId.clear();
    }

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

    public String[] getAllBikeType(){
        String[] bikeType = new String[bikeTypes.length];
        for (int i = 0; i <= bikeType.length - 1; i++){
            String name = bikeTypes[i].name();
            bikeType[i] = name;
        }
        return bikeType;
    }

    public String grabSerialId(){
        return txtSerialId.getText().trim();
    }

    public String grabBrand(){
        return txtBrand.getText().trim();
    }

    public String grabColor(){
        return txtColor.getText().trim();
    }

    public int grabYear(){
        try {
            return Integer.parseInt(txtYear.getText().trim());
        } catch (NumberFormatException e) {
            alert(Alert.AlertType.WARNING, "Año Invalido", "ingrese un año valido");
            return Integer.parseInt(txtYear.getText().trim());
        }
    }

    public String grabClientId(){
        return txtClientId.getText().trim();
    }

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }
}
