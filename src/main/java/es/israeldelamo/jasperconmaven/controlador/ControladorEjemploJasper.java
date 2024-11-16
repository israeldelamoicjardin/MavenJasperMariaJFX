package es.israeldelamo.jasperconmaven.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControladorEjemploJasper {
    @FXML
    private Label textoInformacionJasper;


    /**
     * Evento OnMo
     */
    @FXML
    protected void onLanzaJasperButtonClick() {
        textoInformacionJasper.setText("Vamos allá");
        System.out.println("Lanzando informe jasper");
        lanzarInformeJasper();

    }

    /**
     * Lanza un informe de JasperReports a partir de su archivo compilado jasper
     * Sería mejor que como parámetro de entrada fuera el nombre del jasper
     */

    private void lanzarInformeJasper()
    {

    }

}