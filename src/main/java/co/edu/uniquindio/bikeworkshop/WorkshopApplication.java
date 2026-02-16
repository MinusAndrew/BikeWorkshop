package co.edu.uniquindio.bikeworkshop;

import co.edu.uniquindio.bikeworkshop.model.Client;
import co.edu.uniquindio.bikeworkshop.model.Workshop;
import co.edu.uniquindio.bikeworkshop.viewController.MainView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkshopApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Workshop workshop = new Workshop("BikeWorkshop", "WYSI727");
            workshop.registerClient("Wincohax", "727W", "+838433", "XX24", workshop);

            FXMLLoader fxmlLoader = new FXMLLoader(WorkshopApplication.class.getResource("MainView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            MainView mainView = fxmlLoader.getController();
            mainView.setTheWorkshop(workshop);

            stage.setTitle(workshop.getName());
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void alert(Alert.AlertType type, String title ,String msg){
        Alert messageBox = new Alert(type);
        messageBox.setContentText(msg);
        messageBox.setTitle(title);
        messageBox.show();
    }

    public static void workInProgress(String msg){
        Alert messageBox = new Alert(Alert.AlertType.INFORMATION);
        messageBox.setContentText(msg);
        messageBox.show();
    }

}
