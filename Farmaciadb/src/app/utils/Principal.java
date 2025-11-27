package app.utils;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {
        Connection conn = Conexion.obtenerConexion();

        System.out.println("conn" + conn);
    }

}
