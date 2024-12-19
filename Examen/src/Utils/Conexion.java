package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// * REQ: PATRONES DE DISEÑO
public class Conexion {
    private static Connection connection;
    private static String database, user, password;

    private Conexion(){

    }

    public static Connection getConexion() {
        try {
            if(connection==null || connection.isClosed()){
                try{
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,user,password);
                    return connection;
                } catch (SQLException e){
                    System.out.println(e);
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Conexion.connection = connection;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        Conexion.database = database;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Conexion.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Conexion.password = password;
    }
}
