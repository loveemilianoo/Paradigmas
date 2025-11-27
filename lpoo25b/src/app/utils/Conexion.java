package app.utils;

import java.sql.*;

public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/dblpoo25b";
    static String usr= "root";
    static String pwd= "lpoo1234";
    
    public static Connection getConexion(){
        Connection conexion = null;
        
        try{
            String controller= "com.mysql.cj.jdbc.Driver";
            Class.forName(controller);
            
            conexion = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conexion exitosa");
        }catch (ClassNotFoundException e){
            System.out.println("Driver no encontrado "+e.toString());
        }catch (SQLException b){
            System.out.println("Error de conexion"+b.toString());
        }
        return conexion;
    }
}
