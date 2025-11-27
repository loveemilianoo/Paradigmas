package app.models;

public class Empleado extends Persona {
    private String noEmpleado;
    private Persona persona;

    public Empleado(String noEmpleado, String rfc, String curp, String nombre, int edad, char sexo, String correo) {
        super(rfc, curp, nombre, edad, sexo, correo);
        this.noEmpleado = noEmpleado;
    }

    public String getNoEmpleado() {
        return noEmpleado;
    }
    public void setNoEmpleado(String noEmpleado) {
        this.noEmpleado = noEmpleado;
    }
}
