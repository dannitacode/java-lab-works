package Persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
/**
 *
 * @author dannita
 */
public class DbConexion {
    public static Connection establecerConexion() {
        Properties prop = new Properties();
        Connection conn = null;

        try {
            prop.load(new FileInputStream("config.properties"));

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.pass");

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (IOException e) {
            System.out.println("No se encontró config.properties: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        return conn;
    }
}


