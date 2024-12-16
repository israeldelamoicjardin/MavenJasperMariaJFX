package es.israeldelamo.jasperconmaven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Punto de entrada en la aplicación
 *
 * @author israel
 * @version $Id: $Id
 */
public class Lanzador {

    // Usamos SLF4J para el logger
    private static final Logger logger = LoggerFactory.getLogger(Lanzador.class);

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link String} objects
     */
    public static void main(String[] args) {
        //ejemplos de errores
        logger.info("UN INFO DE EJEMPLO");
        logger.error("Mensaje SEVERE");
        logger.warn("Mensaje WARNING");
        logger.info("Mensaje INFO");  // Este debería mostrarse si el nivel está configurado correctamente
       // EjemploJasper.main(args);

    }
}
