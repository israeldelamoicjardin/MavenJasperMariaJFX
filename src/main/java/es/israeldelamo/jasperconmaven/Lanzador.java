package es.israeldelamo.jasperconmaven;

/**
 * Punto de entrada en la aplicación
 *
 * @author israel
 * @version $Id: $Id
 */
public class Lanzador {


    /**
     * <p>main.</p>
     *
     * @param args an array of {@link String} objects
     */
    public static void main(String[] args) {
        EjemploJasper.main(args);
        //Empezamos desde aquí
        System.out.println(System.getProperty("user.dir"));

    }
}
