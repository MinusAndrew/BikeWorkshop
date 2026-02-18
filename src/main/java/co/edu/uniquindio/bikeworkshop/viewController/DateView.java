package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.DateController;
import co.edu.uniquindio.bikeworkshop.model.Mechanic;
import co.edu.uniquindio.bikeworkshop.model.Order;
import co.edu.uniquindio.bikeworkshop.model.Workshop;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.alert;

public class DateView implements Initializable {
    private Workshop theWorkshop;
    private final DateController dateController = new DateController();

    @FXML
    private Button backButton;

    @FXML
    private TableView<Order> tblOrder;
    @FXML
    private TableColumn<Order, String> colDateOfEntry, colHourOfEntry, colReason, colDiagnosis, colWorkMade, colTotalCost;

    @FXML
    private DatePicker orderDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderView.setOrderTables(colDateOfEntry, colHourOfEntry, colReason, colDiagnosis, colWorkMade, colTotalCost);
    }

    public void fillUpTable(LocalDate date){
        if(dateController.orderList(theWorkshop ,date).isEmpty()){
            alert(Alert.AlertType.INFORMATION, "Cero Ordenes", "No hay ordenes para dicha fecha");
            return;
        }
        tblOrder.getItems().addAll(dateController.orderList(theWorkshop, date));
    }

    public void searchOrders(){
        try {
            LocalDate date = grabDate();
            fillUpTable(date);
        } catch (Exception e) {
            alert(Alert.AlertType.ERROR, "Fecha valida", "Seleccione minimo una fecha valida");
        }
    }

    public LocalDate grabDate(){
        return orderDate.getValue();
    }

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
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
}
