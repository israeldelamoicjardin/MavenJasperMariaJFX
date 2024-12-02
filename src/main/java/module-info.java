module es.israeldelamo.jasperconmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires org.mariadb.jdbc;

requires slf4j.api;
requires slf4j.simple;

    opens es.israeldelamo.jasperconmaven to javafx.fxml, javafx.base;
    exports es.israeldelamo.jasperconmaven to javafx.graphics;
    exports es.israeldelamo.jasperconmaven.controlador;
    opens es.israeldelamo.jasperconmaven.controlador to javafx.fxml, javafx.base;
}