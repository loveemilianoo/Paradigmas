package app.models;

public class Cliente extends Persona {
    private String noCliente;
    private Cuenta cuenta;
    
    public Cliente(String rfc, String curp, String nombre, int edad, char sexo, String correo, String noCliente, Cuenta cuenta) {
        super(rfc, curp, nombre, edad, sexo, correo);
        this.noCliente = noCliente;
        this.cuenta = cuenta;
    }

    public String getNoCliente() {
        return noCliente;
    }
    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
