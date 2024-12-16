package es.israeldelamo.jasperconmaven.controlador;

import es.israeldelamo.jasperconmaven.EjemploJasper;
import es.israeldelamo.jasperconmaven.Lanzador;
import es.israeldelamo.jasperconmaven.conexiondb.ConexionBBDD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


/**
 * Controlador de la ventana FXML con un botoncillo que lanza un Jasper
 */
public class ControladorEjemploJasper {
    @FXML
    private Label textoInformacionJasper;


    /**
     * Evento OnClickButton
     */
    @FXML
    protected void onLanzaJasperButtonClick() {
        textoInformacionJasper.setText("Vamos allá");
        System.out.println("Lanzando informe jasper");

        // comenzamos con el lanzamiento del informe
        try {
            // abrimos la base de datos
            ConexionBBDD con = new ConexionBBDD();
            //podemos crear un conjunto de parámetros si quisieramos pasárselo al informe
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("codigo", 5);
            parameters.put("nombre", "xxxx");





            InputStream reportStream = Lanzador.class.getResource("/es/israeldelamo/jasperconmaven/jasper/Cherry.jasper").openStream();


            if (reportStream == null) {
                System.out.println("El archivo no esta ahí");
            }else {
                System.out.println("El archivo se ha encontrado");
            }
            JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);

            //Atentos a la ruta del Jasper y a cómo enlazamos el archivo compilado por JasperReports
           // JasperReport report = (JasperReport) JRLoader.loadObject(new File("src/main/resources/es/israeldelamo/jasperconmaven/reports/Cherry.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, con.getConexion());
            //Preparamos un visor, no intentaremos usar el salvar a PDF; para eso el SO ya nos da las impresoras A PDF
            JasperViewer viewer = new JasperViewer(jprint, false);
            //lanzamos la visión
            viewer.setVisible(true);
        } catch (Exception e) {
            //como estamos en JavaFX tratamos la alerta aquí y comentamos el stack de consola.
            // en desarrollo sería conveniente tenerlo descomentado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ha ocurrido un error al abrir el informe. Pida ayuda en el foro");
            alert.showAndWait();
            //e.printStackTrace();
        }

    }



}