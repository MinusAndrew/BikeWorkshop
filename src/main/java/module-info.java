module co.edu.uniquindio.bikeworkshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.bikeworkshop to javafx.fxml;
    exports co.edu.uniquindio.bikeworkshop;
    exports co.edu.uniquindio.bikeworkshop.controller;
    opens co.edu.uniquindio.bikeworkshop.controller to javafx.fxml;
}