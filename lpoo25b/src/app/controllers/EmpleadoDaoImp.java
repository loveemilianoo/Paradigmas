package app.controllers;

import app.models.Empleado;
import app.utils.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class EmpleadoDaoImp implements EmpleadoDao {
    
    @Override
    public void guardaEmpleado(Empleado empleado){
        System.out.println("Empleado guardado: "+empleado.getNombre());
        PreparedStatement psPersona= null;
        PreparedStatement psEmpleado = null;
        Connection conn = Conexion.getConexion();
        
        try{
            String queryPersona = "INSERT INTO personas (rfc, curp, nombre, edad, sexo, correo) VALUES (?,?,?,?,?,?)";
            
            psPersona= conn.prepareStatement(queryPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, empleado.getRfc());
            psPersona.setString(2, empleado.getCurp());
            psPersona.setString(3, empleado.getNombre());
            psPersona.setInt(4, empleado.getEdad());
            psPersona.setString(5, String.valueOf(empleado.getSexo()));
            psPersona.setString(6, empleado.getCorreo());
            psPersona.executeUpdate();
            
            int idPersona =0;
            ResultSet rs = psPersona.getGeneratedKeys();
            if(rs.next()){
                idPersona = rs.getInt(1);
            }
            psPersona.close();
            
            ///
            String query = "INSERT INTO empleados (noempleado, persona_id) VALUES (?,?)";
            
            psEmpleado = conn.prepareStatement(query);
            psEmpleado.setString(1, empleado.getNoEmpleado());
            psEmpleado.setInt(2, idPersona);
            
            psEmpleado.executeUpdate();
            System.out.println("Insertado correctamente");
        
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Error al cerrar recursos: "+e.toString());
            }
        }
    }
    
    @Override
    public void construirTabla (DefaultTableModel modeloTabla){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConexion();
        
        try{
            String query = "SELECT e.id, rfc, curp, nombre, edad, sexo, correo, noempleado "
                    + "FROM personas p, empleados e WHERE p.id = e.persona_id";
            
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object [columnas];
                for (int i=0; i < columnas; i++){
                    fila [i] = rs.getObject(i+1);
                }
                modeloTabla.addRow(fila);
            }
            System.out.println("Tabla bien mostrada");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error en la base de datos: "+e.toString());
            
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Error al cerrar recursos: "+e.toString());
            }
        }
    }

    @Override
    public Empleado consultarEmpleado (int id){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConexion();
        Empleado empleado = null;
        
        try{
            String query = "SELECT e.id, e.noempleado, p.rfc, p.curp, p.nombre, p.edad, p.sexo, p.correo "
                    + "FROM personas p, empleados e "
                    + "WHERE p.id = e.persona_id "
                    + "AND e.id = ?";
            
           ps = conn.prepareStatement(query);
           ps.setInt(1, id);
           
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               char sexoChar = rs.getString("sexo") != null ? rs.getString("sexo").charAt(0) : ' ';
            
                empleado = new Empleado(
                rs.getString("noempleado"),
                rs.getString("rfc"), 
                rs.getString("curp"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                sexoChar,
                rs.getString("correo"));
           }
        } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return empleado;
    }
    
    @Override
    public  Empleado modificarEmpleado(int id, Empleado empleado){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConexion();
        ResultSet rs = null;
        
        try{
            String queryId = "SELECT persona_id FROM empleados WHERE id=?";
            
            ps = conn.prepareStatement(queryId);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            int personaId=0;
            
            while (rs.next()){
                personaId = rs.getInt("persona_id");
            }
            ///
            String queryUpPersona = "UPDATE personas SET rfc=?, curp=?, nombre=?, edad=?, sexo=?, correo=? WHERE id=?";
            ps = conn.prepareStatement(queryUpPersona);
            ps.setString(1, empleado.getRfc());
            ps.setString(2, empleado.getCurp()); 
            ps.setString(3, empleado.getNombre());
            ps.setInt(4, empleado.getEdad());
            ps.setString(5, String.valueOf(empleado.getSexo()));
            ps.setString(6, empleado.getCorreo());
            
            ps.setString(7, String.valueOf(personaId));
            ps.executeUpdate();
            ///
            String queryUpEmpleado = "UPDATE empleados SET noempelado=? WHERE id=?";
            ps = conn.prepareStatement(queryUpEmpleado);
            ps.setString(1, empleado.getNoEmpleado());
            
            ps.setString(2, String.valueOf(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error"+e.toString());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
        return empleado;
    }
    
    @Override
    public void eliminaEmpleado(int id){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConexion();
        ResultSet rs = null;
        
        try{
            String queryIds = "SELECT persona_id FROM empleados WHERE id=?";
            ps = conn.prepareStatement(queryIds);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            int idPersona=0;
            
            while(rs.next()){
                idPersona= rs.getInt("persona_id");
            }
            ///
            String queryElimEmpleado = "DELETE FROM empleados WHERE id=?";
            ps = conn.prepareStatement(queryElimEmpleado);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            ///
            String queryElimPersona = "DELETE FROM personas WHERE id=?";
            ps = conn.prepareStatement(queryElimPersona);
            ps.setString(1, String.valueOf(idPersona));
            ps.executeUpdate();
            }catch (SQLException e) {
                System.out.println("Error"+e.toString());
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

