/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import app.utils.Conexion;
import java.sql.*;

/**
 *
 * @author root
 */
public class TestConexion {
    public static void main(String[] args) {
        Connection conn = Conexion.getConexion();
        
        if (conn != null){
            System.out.println("Todo funciona bien");
            try {
                conn.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Hay problemas");
        }
    }
    
}
