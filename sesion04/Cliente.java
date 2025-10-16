import java.lang.*;
import java.util.*;

public class Cliente extends Persona{
	private String noCliente;
	private Cuenta cuenta;

	public Cliente (String nombre,int edad, char sexo, String noCliente, Cuenta cuenta){
        super(nombre, edad, sexo);
		this.noCliente= noCliente;
		this.cuenta= cuenta;
	}

	
    public String getNoCliente() {
        return noCliente;
    }
    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }
    public void setCuenra(Cuenta cuenta){
    	this.cuenta= cuenta;
    }
    public Cuenta getCuenta(){
    	return cuenta;
    }

    @Override
	public String toString() {
    return "Persona{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", sexo=" + sexo +
            ", noCliente='" + noCliente + 
            /*", Cuenta=" + cuenta +*/ '\'' +
            '}';
    }
}