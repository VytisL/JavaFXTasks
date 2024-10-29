module com.example.javafx3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx3 to javafx.fxml;
    exports com.example.javafx3;
}