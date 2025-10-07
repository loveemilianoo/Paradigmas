import java.lang.*;
import java.util.*;

public class Cliente{
	private String nombre;
	private int edad;
	private char sexo;
	private String noCliente;
	private Cuenta cuenta;

	public Cliente (String nombre, int edad, char sexo, String noCliente, Cuenta cuenta){
		this.nombre= nombre;
		this.edad= edad;
		this.sexo= sexo;
		this.noCliente= noCliente;
		this.cuenta= cuenta;
	}



	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
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