package es.israeldelamo.jasperconmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EjemploJasper extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EjemploJasper.class.getResource("fxml/EjemploJasper.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Un lanzaador simple");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Punto de entrada de la aplicación
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}