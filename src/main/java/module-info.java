module co.edu.uniquindio.bikeworkshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.bikeworkshop to javafx.fxml;
    exports co.edu.uniquindio.bikeworkshop;
    exports co.edu.uniquindio.bikeworkshop.model;
    exports co.edu.uniquindio.bikeworkshop.model.Enums;
    exports co.edu.uniquindio.bikeworkshop.viewController;
    opens co.edu.uniquindio.bikeworkshop.viewController to javafx.fxml;
}