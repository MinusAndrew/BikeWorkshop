package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.controller.MechanicController;
import co.edu.uniquindio.bikeworkshop.model.Enums.MechanicSkillset;
import co.edu.uniquindio.bikeworkshop.model.Mechanic;
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
import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.workInProgress;

public class MechanicView implements Initializable {
    private Workshop theWorkshop;

    private final MechanicController mechanicController = new MechanicController();

    @FXML
    private Button backButton;

    @FXML
    private TableView<Mechanic> tblMechanic;

    @FXML
    private TableColumn<Mechanic, String> colName, colId, colSkill;

    @FXML
    private TextField txtFullName, txtInternalId;

    @FXML
    private ChoiceBox<String> MechanicSkillsetBox;


    private final MechanicSkillset[] mechanicSkillset = MechanicSkillset.values();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        MechanicSkillsetBox.getItems().addAll(getAllMechanicSkillset());
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colId.setCellValueFactory(new PropertyValueFactory<>("internalId"));
        colSkill.setCellValueFactory(new PropertyValueFactory<>("mechanicSkillset"));
    }

    public void fillUpTable(){
        tblMechanic.getItems().addAll(mechanicController.mechanicList(theWorkshop));
    }

    public void saveMechanic(){
        String fullName = grabFullName();
        String internalId = grabInternalId();
        MechanicSkillset skillOption = MechanicSkillset.valueOf(MechanicSkillsetBox.getValue());

        if(fullName.isEmpty() || internalId.isEmpty() || MechanicSkillsetBox.getValue().isEmpty()){
            alert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor llena todos los campos.");
            return;
        }

        boolean itExist = mechanicController.checkMechanicId(theWorkshop, internalId);
        if(itExist){
            alert(Alert.AlertType.ERROR, "Duplicado", "Ya existe un mecanico con esa identificación.");
            return;
        }

        Mechanic tmp = mechanicController.addMechanic(theWorkshop, fullName, internalId, skillOption);
        clearForum();
        alert(Alert.AlertType.INFORMATION, "Guardado", "Mecanico registrado correctamente.");
        tblMechanic.getItems().add(tmp);
    }

    public void clearForum(){
        txtFullName.clear();
        txtInternalId.clear();
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

    public String[] getAllMechanicSkillset(){
        String[] mechanicSkills = new String[mechanicSkillset.length];
        for (int i = 0; i <= mechanicSkills.length - 1; i++){
            String name = mechanicSkillset[i].name();
            mechanicSkills[i] = name;
        }
        return mechanicSkills;
    }

    public String grabFullName() {
        return txtFullName.getText().trim();
    }

    public String grabInternalId(){
        return txtInternalId.getText().trim();
    }

}
