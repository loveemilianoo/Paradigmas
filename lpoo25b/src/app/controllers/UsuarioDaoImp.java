package app.controllers;

import app.utils.Conexion;
import java.sql.*;
import app.models.Usuario;

public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public Usuario validarUsuario(String login, String password) {
        Usuario usuario = null;
        PreparedStatement ps= null;
        Connection conn = Conexion.getConexion();
        ResultSet rs = null;
        
        try{
            String query = "SELECT * from usuarios u, personas p WHERE p.id = u.persona_id AND login = ? AND password =?";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
    
    
    }
    
}
