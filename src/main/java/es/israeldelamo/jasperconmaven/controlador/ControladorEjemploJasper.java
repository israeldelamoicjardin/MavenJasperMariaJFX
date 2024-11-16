package es.israeldelamo.jasperconmaven.controlador;

import es.israeldelamo.jasperconmaven.conexiondb.ConexionBBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileNotFoundException;
import java.util.HashMap;

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
        try {
            ConexionBBDD con = new ConexionBBDD();
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("codigo", 5);
            parameters.put("nombre", "xxxx");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/informe.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, con.getConexion());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ha ocurrido un error");
            alert.showAndWait();
            e.printStackTrace();
        }

    }



}