package app.controllers;

import app.models.Empleado;
import javax.swing.table.DefaultTableModel;

public interface EmpleadoDao {
    public abstract void guardaEmpleado(Empleado empleado);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract Empleado consultarEmpleado (int id);
    public abstract Empleado modificarEmpleado(int id, Empleado empleado);
    public abstract void eliminaEmpleado(int id);
}
