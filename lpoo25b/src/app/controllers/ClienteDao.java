package app.controllers;

import app.models.Cliente;
import javax.swing.table.DefaultTableModel;

public interface ClienteDao {
    
    public abstract void guardarCliente(Cliente cliente);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract Cliente consultarCliente (int id);
    public abstract void modificarCliente (int id, Cliente cliente);
    public abstract void eliminarCliente(int id);
}
