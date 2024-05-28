module com.example.hqtqlsv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.hqtqlsv to javafx.fxml;
    exports com.example.hqtqlsv;
    exports com.example.hqtqlsv.Model;
    opens com.example.hqtqlsv.Model to javafx.fxml;
    exports com.example.hqtqlsv.Controller;
    opens com.example.hqtqlsv.Controller to javafx.fxml;
    exports com.example.hqtqlsv.Controller.admin;
    opens com.example.hqtqlsv.Controller.admin to javafx.fxml;
    exports com.example.hqtqlsv.Controller.student;
    opens com.example.hqtqlsv.Controller.student to javafx.fxml;
}