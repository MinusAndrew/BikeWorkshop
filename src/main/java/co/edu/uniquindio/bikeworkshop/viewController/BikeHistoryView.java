package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.BikeController;
import co.edu.uniquindio.bikeworkshop.model.Bike;
import co.edu.uniquindio.bikeworkshop.model.Client;
import co.edu.uniquindio.bikeworkshop.model.Enums.BikeType;
import co.edu.uniquindio.bikeworkshop.model.Order;
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

public class BikeHistoryView implements Initializable {
    private Workshop theWorkshop;

    private final BikeController bikeController = new BikeController();

    @FXML
    private Button backButton;

    @FXML
    private TableView<Bike> tblBike;

    @FXML
    private TableColumn<Bike, String> colId, colBrand, colColor, colYear, colType;

    @FXML
    private TextArea bikeRecord;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        BikeView.setupBikeTables(colId, colBrand, colColor, colYear, colType);
    }

    public void fillUpTable(){
        tblBike.getItems().addAll(bikeController.bikeList(theWorkshop));
    }

    public void getBikeRecord(){
        try {
            Bike bike = grabSelectedBike();
            Order order = bike.getTheOrder();
            String history = order.getWorkMade();
            bikeRecord.setText(history);
        } catch (Exception e) {
            alert(Alert.AlertType.ERROR, "Bicicleta sin orden", "La bicicleta seleccionada no tiene una orden asignada.");
        }

    }

    public void saveBikeRecord(){
        try {
            Bike bike = grabSelectedBike();
            Order order = bike.getTheOrder();
            String newRecord = bikeRecord.getText();
            order.setWorkMade(newRecord);
            alert(Alert.AlertType.INFORMATION, "Cambios Guardados", "El historial se ha guardado correctamente.");
        } catch (Exception e) {
            alert(Alert.AlertType.ERROR, "Bicicleta sin orden", "La bicicleta seleccionada no tiene una orden asignada.");
        }
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

    public Bike grabSelectedBike(){
        return tblBike.getSelectionModel().getSelectedItem();
    }

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }
}
