package app.controllers;

import app.models.Cliente;
import app.models.Cuenta;
import app.models.Tarjeta;
import app.utils.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ClienteDaoImp implements ClienteDao{

    @Override
    public void guardarCliente(Cliente cliente) {
        System.out.println("Datos: "+cliente.getCurp());
        PreparedStatement psTarjeta= null;
        PreparedStatement psCuenta= null;
        PreparedStatement psPersona= null;
        PreparedStatement psCliente= null;
        
        Connection conn = Conexion.getConexion();
        
        try {
            String queryTarjeta = "INSERT INTO tarjetas (notarjeta, nip) VALUES (?, ?)";
            
            psTarjeta = conn.prepareStatement(queryTarjeta, Statement.RETURN_GENERATED_KEYS);
            psTarjeta.setString(1, cliente.getCuenta().getTarjeta().getNoTarjeta());
            psTarjeta.setString(2, cliente.getCuenta().getTarjeta().getNip());
            psTarjeta.executeUpdate();
            
            int idTarjeta = 0;
            ResultSet rs = psTarjeta.getGeneratedKeys();
            if (rs.next()) {
                idTarjeta = rs.getInt(1);
            }
            psTarjeta.close();
            ///
            String queryCuenta = "INSERT INTO cuentas (saldo, tarjeta_id) VALUES (?, ?)";
            
            psCuenta = conn.prepareStatement(queryCuenta, Statement.RETURN_GENERATED_KEYS);
            psCuenta.setDouble(1, cliente.getCuenta().getSaldo());
            psCuenta.setInt(2, idTarjeta);
            psCuenta.executeUpdate();
           
            int idCuenta = 0;
            rs = psCuenta.getGeneratedKeys();
            if (rs.next()) {
                idCuenta = rs.getInt(1);
            }
            psCuenta.close();
            ///
            String queryPersona = "INSERT INTO personas (rfc, curp, nombre, edad, sexo, correo) VALUES (?, ?, ?, ?, ?, ?)";
            
            psPersona = conn.prepareStatement(queryPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, cliente.getRfc());
            psPersona.setString(2, cliente.getCurp()); 
            psPersona.setString(3, cliente.getNombre());
            psPersona.setInt(4, cliente.getEdad());
            psPersona.setString(5, String.valueOf(cliente.getSexo()));
            psPersona.setString(6, cliente.getCorreo());
            psPersona.executeUpdate();
            
            int idPersona = 0;
            rs = psPersona.getGeneratedKeys();
            if (rs.next()) {
                idPersona = rs.getInt(1);
            }
            psPersona.close();
            ///
            String queryCliente = "INSERT INTO clientes (nocliente, persona_id, cuenta_id) VALUES (?, ?, ?)";
            
            psCliente = conn.prepareStatement(queryCliente);
            psCliente.setString(1, cliente.getNoCliente());
            psCliente.setInt(2, idPersona);
            psCliente.setInt(3, idCuenta);
            psCliente.executeUpdate();
            psCliente.close();
            
            System.out.println("Insertado correctamente");
            
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error en la base de datos: "+e.toString());
            
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
        PreparedStatement ps= null;
        
        Connection conn = Conexion.getConexion();
        
        try {
            String query = "SELECT cl.id, rfc, curp, nombre, edad, sexo, correo, nocliente, notarjeta, nip, saldo "
                    + "FROM personas p JOIN clientes cl on (p.id = cl.persona_id) "
                    + "JOIN  cuentas cu on (cu.id = cl.cuenta_id) JOIN tarjetas t on (t.id = cu.tarjeta_id)";
            
            ps= conn.prepareStatement(query);           
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice ++){
                    fila [indice] = rs.getObject(indice+1);
                }
                modeloTabla.addRow(fila);
            }
            
            System.out.println("Tabla mostrada correctamente");
            
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
    public Cliente consultarCliente(int id) {
        PreparedStatement ps= null;
        Connection conn = Conexion.getConexion();
        Cliente cliente = null;
        
        try {
            String query = "SELECT cl.id, rfc, curp, nombre, edad, sexo, correo, nocliente, notarjeta, nip, saldo "
                    + "FROM personas p, clientes cl, cuentas cu, tarjetas t "
                    + "WHERE p.id = cl.persona_id "
                    + "AND cu.id = cl.cuenta_id "
                    + "AND t.id = cu.tarjeta_id "
                    + "AND cl.id = ?;";
            
            ps= conn.prepareStatement(query);    
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tarjeta tarjeta = new Tarjeta (rs.getString("notarjeta"), rs.getString("nip"));
                Cuenta cuenta = new Cuenta(Double.parseDouble(rs.getString("saldo")), tarjeta);
                
                char sexoChar = (char) rs.getString("Sexo").charAt(0);
                
                cliente = new Cliente (rs.getString("Rfc"), rs.getString("Curp"), rs.getString("Nombre"), rs.getInt("Edad"), sexoChar, rs.getString("Correo"), rs.getString("NoCliente"), cuenta);
           }
            
            System.out.println("Tabla mostrada correctamente");
            
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
        return cliente;
    }
    
    @Override
    public void modificarCliente (int id,Cliente cliente){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConexion();
        ResultSet rs = null;
        
        try{
            String queryRecuperId = "SELECT cuenta_id, persona_id FROM clientes WHERE id=?";
            
            ps = conn.prepareStatement(queryRecuperId);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            
            int personaId=0;
            int cuentaId=0;
            int tarjetaId=0;
            
            while (rs.next()){
                personaId = rs.getInt("persona_id");
                cuentaId = rs.getInt("cuenta_id");
            }
            
            ///
            String queryIdTarjeta = "SELECT tarjeta_id FROM cuentas WHERE id=?";
            ps= conn.prepareStatement(queryIdTarjeta);
            ps.setInt(1, cuentaId);
            rs = ps.executeQuery();
            
            while (rs.next()){
                tarjetaId = rs.getInt("tarjeta_id");
            }
            
            ///
            String queryUpdatePersona = "UPDATE personas SET rfc=?, curp=?, nombre=?, edad=?, sexo=?, correo=? WHERE id=?";
            ps = conn.prepareStatement(queryUpdatePersona);
            ps.setString(1, cliente.getRfc());
            ps.setString(2, cliente.getCurp()); 
            ps.setString(3, cliente.getNombre());
            ps.setInt(4, cliente.getEdad());
            ps.setString(5, String.valueOf(cliente.getSexo()));
            ps.setString(6, cliente.getCorreo());
            
            ps.setString(7, String.valueOf(personaId));
            ps.executeUpdate();
            
            ///
            String queryUpdateCuenta = "UPDATE cuentas SET saldo=? WHERE id=?";
            ps = conn.prepareStatement(queryUpdateCuenta);
            ps.setDouble(1, cliente.getCuenta().getSaldo());
            
            ps.setString(2, String.valueOf(cuentaId));
            ps.executeUpdate();
            
            ///
            String queryUpdateTarjeta = "UPDATE tarjetas SET notarjeta=?, nip=? WHERE id=?";
            ps = conn.prepareStatement(queryUpdateTarjeta);
            ps.setString(1, cliente.getCuenta().getTarjeta().getNoTarjeta());
            ps.setString(2, cliente.getCuenta().getTarjeta().getNip());
            
            ps.setString(3, String.valueOf(tarjetaId));
            ps.executeUpdate();
            
            ///
            String queryUpdateCliente = "UPDATE clientes SET nocliente=? WHERE id=?";
            ps = conn.prepareStatement(queryUpdateCliente);
            ps.setString(1, cliente.getNoCliente());
            ps.setString(2,  String.valueOf(id));
            
            ps.executeUpdate();
            
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
    public void eliminarCliente(int id){
        PreparedStatement ps= null;
        Connection conn = Conexion.getConexion();
        ResultSet rs = null;
        
        try{
            String queryIds = "SELECT cuenta_id, persona_id FROM clientes WHERE id=?";
            ps = conn.prepareStatement(queryIds);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            
            int personaId=0;
            int cuentaId=0;
            int tarjetaId=0;    
            
            while (rs.next()){
                personaId = rs.getInt("persona_id");
                cuentaId = rs.getInt("cuenta_id");
            }
            ///
            String queryIdTarjeta = "SELECT tarjeta_id FROM cuentas WHERE id=?";
            ps= conn.prepareStatement(queryIdTarjeta);
            ps.setInt(1, cuentaId);
            rs = ps.executeQuery();
            
            while (rs.next()){
                tarjetaId = rs.getInt("tarjeta_id");
            }
            ///
            String queryElimCliente = "DELETE FROM clientes WHERE id=?";
            ps = conn.prepareStatement(queryElimCliente);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ///
            String queryElimCuenta = "DELETE FROM cuentas WHERE id=?";
            ps = conn.prepareStatement(queryElimCuenta);
            ps.setInt(1, cuentaId);
            
            ps.executeUpdate();
            ///
            String queryElimTarjeta = "DELETE FROM tarjetas WHERE id=?;";
            ps= conn.prepareStatement(queryElimTarjeta);
            ps.setInt(1, tarjetaId);
            
            ps.executeUpdate();
            ///
            String queryElimPersona = "DELETE FROM personas WHERE id=?";
            ps = conn.prepareStatement(queryElimPersona);
            ps.setInt(1, personaId);
            
            ps.executeUpdate();
            
        }catch (SQLException e){
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
}