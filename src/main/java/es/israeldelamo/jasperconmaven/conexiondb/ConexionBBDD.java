package es.israeldelamo.jasperconmaven.conexiondb;

import es.israeldelamo.jasperconmaven.util.Propiedades;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
    /**
     * Clase de conexión a la bbdd
     *
     * @author israel
     * @version $Id: $Id
     */
    public class ConexionBBDD {
        private final Connection conexion;

        /**
         * Es el constructor que se llama al crear un objeto de esta clase, lanzado la conexión
         *
         * @throws SQLException Hay que controlar errores de SQL
         */
        public ConexionBBDD() throws SQLException {
            // los parametros de la conexion leidos desde fuera
            String user = Propiedades.getValor("user");
            String password = Propiedades.getValor("password");
            String baseDeDatosAConectar = Propiedades.getValor("base");
            // las propiedades de la conexión
            Properties connConfig = new Properties();
            connConfig.setProperty("user", user);
            connConfig.setProperty("password", password);
            //la conexion en sí
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost/"+baseDeDatosAConectar+"?serverTimezone=Europe/Madrid", connConfig);
            conexion.setAutoCommit(true);
            DatabaseMetaData databaseMetaData = conexion.getMetaData();
            //debug
            System.out.println();
            System.out.println("--- Datos de conexión ------------------------------------------");
            System.out.printf("Base de datos: %s%n", databaseMetaData.getDatabaseProductName());
            System.out.printf("  Versión: %s%n", databaseMetaData.getDatabaseProductVersion());
            System.out.printf("Driver: %s%n", databaseMetaData.getDriverName());
            System.out.printf("  Versión: %s%n", databaseMetaData.getDriverVersion());
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            conexion.setAutoCommit(true);
        }

        /**
         * Esta clase devuelve la conexión creada
         *
         * @return una conexión a la BBDD
         */
        public Connection getConexion() {
            return conexion;
        }

        /**
         * Metodo de cerrar la conexion con la base de datos
         *
         * @return La conexión cerrada.
         * @throws SQLException Se lanza en caso de errores de SQL al cerrar la conexión.
         */
        public Connection CloseConexion() throws SQLException{
            conexion.close();
            return conexion;
        }

        public static void main(String[] args) {
            try {
                ConexionBBDD co = new ConexionBBDD();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

