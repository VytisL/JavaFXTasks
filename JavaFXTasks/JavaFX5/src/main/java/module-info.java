module com.example.javafx5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx5 to javafx.fxml;
    exports com.example.javafx5;
}