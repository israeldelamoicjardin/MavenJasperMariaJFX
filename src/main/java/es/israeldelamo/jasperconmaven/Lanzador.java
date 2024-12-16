package es.israeldelamo.jasperconmaven;

import es.israeldelamo.jasperconmaven.controlador.ControladorEjemploJasper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Punto de entrada en la aplicación
 *
 * @author israel
 * @version $Id: $Id
 */
public class Lanzador {

    private static final Logger logger = LoggerFactory.getLogger(Lanzador.class); // Logger de SLF4J

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link String} objects
     */
    public static void main(String[] args) {
        logger.info("UN INFO DE EJEMPLO");
        logger.warn("UN WARN DE EJEMPLO");
        logger.debug("UN DEBUG DE EJEMPLO");
        logger.error("UN ERROR DE EJEMPLO");
        EjemploJasper.main(args);

    }
}
