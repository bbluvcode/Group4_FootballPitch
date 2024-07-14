module com.mycompany.group4_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires java.mail;
    requires kernel;
    requires layout;
    requires html2pdf;
     
    opens com.mycompany.group4_project to javafx.fxml;
    exports com.mycompany.group4_project;
    exports Entities;
    opens Entities to javafx.fxml;
}
