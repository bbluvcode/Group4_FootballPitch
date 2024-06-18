module com.mycompany.democrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
         
    opens com.mycompany.democrud to javafx.fxml;
    exports com.mycompany.democrud;
}
