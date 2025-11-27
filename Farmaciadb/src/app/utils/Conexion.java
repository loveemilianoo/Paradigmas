package app.utils;

import java.sql.*;

public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/farmaciadb";
    static String usr = "root";
    static String pwd = "lpoo1234";
    
    public static Connection obtenerConexion(){
        Connection conexion = null;
        
        try{
            String controller = "com.mysql.cj.jdbc.Driver";
            Class.forName(controller);
            
            conexion = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conexion exitosa");
        } catch (SQLException e){
            System.out.println("Error de Conexion: "+e.toString());
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Driver no encontrado "+e.toString());
            e.printStackTrace();
        }
        return conexion;
    }    
}
