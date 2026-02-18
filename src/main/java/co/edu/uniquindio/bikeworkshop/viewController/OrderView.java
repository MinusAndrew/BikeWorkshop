package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.OrderController;
import co.edu.uniquindio.bikeworkshop.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.alert;
import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.workInProgress;

public class OrderView implements Initializable {
    private Workshop theWorkshop;
    private final OrderController orderController = new OrderController();

    @FXML
    private Button backButton;
    @FXML
    private TableView<Mechanic> tblMechanic;
    @FXML
    private TableView<Order> tblOrder;
    @FXML
    private TableColumn<Mechanic, String> colMechName, colMechId, colMechSkillset;
    @FXML
    private TableColumn<Order, String> colDateOfEntry, colHourOfEntry, colReason, colDiagnosis, colWorkMade, colTotalCost;
    @FXML
    private TableView<Bike> tblBike;
    @FXML
    private TableColumn<Bike, String> colYear, colBrand, colColor, colSerialId, colBikeType, colClient;
    @FXML
    private TextField txtReason, txtDiagnosis, txtTotalCost, txtClientId;
    @FXML
    private TextArea txtWorkMade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMechName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colMechId.setCellValueFactory(new PropertyValueFactory<>("internalId"));
        colMechSkillset.setCellValueFactory(new PropertyValueFactory<>("mechanicSkillset"));

        colDateOfEntry.setCellValueFactory(new PropertyValueFactory<>("dateOfEntry"));
        colHourOfEntry.setCellValueFactory(new PropertyValueFactory<>("hour"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        colWorkMade.setCellValueFactory(new PropertyValueFactory<>("workMade"));
        colTotalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colSerialId.setCellValueFactory(new PropertyValueFactory<>("serialId"));
        colBikeType.setCellValueFactory(new PropertyValueFactory<>("bikeType"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("theClient"));

    }

    public void fillUpTables() {
        tblMechanic.getItems().addAll(orderController.grabFreeMechanicList(theWorkshop));
        tblOrder.getItems().addAll(orderController.orderList(theWorkshop));
    }

    public void fillUpBikeTable(Client client){
        tblBike.getItems().addAll(client.getBikeList());
    }

    public void searchButtonAction(){
        String id = grabClientId();
        Client client = orderController.searchClientById(id, theWorkshop);
        if (client != null){
            fillUpBikeTable(client);
        }
        else {
            alert(Alert.AlertType.ERROR, "Error: Cliente", "Cliente no encontrado.");
        }
    }

    public void saveOrder(){
        int totalCost = grabTotalCost();

        LocalDate date = grabDate();
        LocalTime hour = grabHour();

        String reason = grabReason();
        String diagnosis = grabDiagnosis();
        String workMade = grabWorkMake();

        Bike bike = grabSelectedBike();
        Mechanic mechanic = grabSelectedMechanic();

        //checks
        if (reason.isEmpty() || diagnosis.isEmpty() || workMade.isEmpty() || txtTotalCost.getText().isEmpty()) {
            if (totalCost < 0){
                alert(Alert.AlertType.WARNING, "Costo Invalido", "ingrese un costo valido");
                return;
            }
            alert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor llena todos los campos.");
            return;
        }

        boolean itExists = orderController.checkMechanic(mechanic);
        if (itExists) {
            alert(Alert.AlertType.ERROR, "Duplicado", "Ya hay un mecanico con una orden existente.");
            return;
        }

        //here is the mess
        Order tmp = orderController.addOrder(theWorkshop, date, hour, reason, diagnosis, workMade, totalCost, mechanic, bike);
        clearForum();

        alert(Alert.AlertType.INFORMATION, "Guardado", "Orden creada correctamente.");

        tblOrder.getItems().add(tmp);

    }

    public void clearForum(){
        txtTotalCost.clear();
        txtClientId.clear();
        txtReason.clear();
        txtDiagnosis.clear();
        txtWorkMade.setText("N/A");
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

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }

    public Mechanic grabSelectedMechanic(){
        return tblMechanic.getSelectionModel().getSelectedItem();
    }

    public Bike grabSelectedBike(){
        return tblBike.getSelectionModel().getSelectedItem();
    }

    public LocalDate grabDate(){
        return LocalDate.now();
    }

    public LocalTime grabHour(){
        return LocalTime.now();
    }

    public String grabReason(){
        return txtReason.getText().trim();
    }

    public String grabDiagnosis(){
        return txtDiagnosis.getText();
    }

    public String grabWorkMake(){
        return txtWorkMade.getText();
    }

    public int grabTotalCost(){
        return Integer.parseInt(txtTotalCost.getText());
    }

    public String grabClientId(){
        return txtClientId.getText().trim();
    }

}
