package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.model.Workshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.workInProgress;

public class MainView {
    private Workshop theWorkshop;


    // Check this first if u encounter weird crashes.
    public void registerClient(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("SubMenu/ClientView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 450);

            ClientView clientView = fxmlLoader.getController();
            clientView.setTheWorkshop(theWorkshop);
            clientView.fillUpTable();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registrar Cliente");

        } catch (Exception e) {
            error("Error abriendo ClientView: " + e.getMessage());
        }

    }

    public void registerBike(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("SubMenu/BikeView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 450);

            BikeView bikeView = fxmlLoader.getController();
            bikeView.setTheWorkshop(theWorkshop);
            bikeView.fillUpTable();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registrar Bicicleta");

        } catch (Exception e) {
            error("Error abriendo BikeView: " + e.getMessage());
        }
    }

    public void registerMechanic(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("SubMenu/MechanicView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 450);

            MechanicView mechanicView = fxmlLoader.getController();
            mechanicView.setTheWorkshop(theWorkshop);
            mechanicView.fillUpTable();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registrar Mecanico");

        } catch (Exception e) {
            error("Error abriendo MechanicView: " + e.getMessage());
        }
    }

    public void newOrder(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("SubMenu/OrderView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 800);

            OrderView orderView = fxmlLoader.getController();
            orderView.setTheWorkshop(theWorkshop);
            orderView.fillUpTables();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registrar Mechanico");

        } catch (Exception e) {
            error("Error abriendo OrderView: " + e.getMessage());
        }
    }

    public void bikeRecord(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("SubMenu/BikeHistoryView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 450);

            BikeHistoryView bikeHistoryView = fxmlLoader.getController();
            bikeHistoryView.setTheWorkshop(theWorkshop);
            bikeHistoryView.fillUpTable();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Historial de Bicicletas");

        } catch (Exception e) {
            error("Error abriendo BikeHistoryView: " + e.getMessage());
        }
    }

    public void orderByDate(){
        workInProgress("WIP");
    }

    public void error(String msg){
        Alert messageBox = new Alert(Alert.AlertType.ERROR);
        messageBox.setContentText(msg);
        messageBox.show();
    }

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }

}
