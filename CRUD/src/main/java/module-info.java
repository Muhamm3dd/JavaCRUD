module com.example.crud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
}