package co.edu.uniquindio.bikeworkshop.viewController;

import co.edu.uniquindio.bikeworkshop.WorkshopApplication;
import co.edu.uniquindio.bikeworkshop.model.Workshop;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static co.edu.uniquindio.bikeworkshop.WorkshopApplication.alert;

public class OrderView {
    private Workshop theWorkshop;

    @FXML
    private Button backButton;

    public void saveClient(){
        workInProgress("WIP");
    }

    public void clearForum(){
        workInProgress("WIP");
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

    public void workInProgress(String msg){
        Alert messageBox = new Alert(Alert.AlertType.INFORMATION);
        messageBox.setContentText(msg);
        messageBox.show();
    }

    public void setTheWorkshop(Workshop theWorkshop) {
        this.theWorkshop = theWorkshop;
    }
}
