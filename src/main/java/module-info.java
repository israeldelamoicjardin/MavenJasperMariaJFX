module es.israeldelamo.jasperconmaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.israeldelamo.jasperconmaven to javafx.fxml;
    exports es.israeldelamo.jasperconmaven;
}