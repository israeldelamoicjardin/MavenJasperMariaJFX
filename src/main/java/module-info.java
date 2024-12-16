module es.israeldelamo.jasperconmaven {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.mariadb.jdbc;

requires slf4j.api;
requires slf4j.simple;
    requires jasperreports;
    requires org.apache.logging.log4j;

    opens es.israeldelamo.jasperconmaven to javafx.fxml, javafx.base;
    exports es.israeldelamo.jasperconmaven to javafx.graphics;
    exports es.israeldelamo.jasperconmaven.controlador;
    opens es.israeldelamo.jasperconmaven.controlador to javafx.fxml, javafx.base;
}