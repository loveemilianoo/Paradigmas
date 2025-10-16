import java.lang.*;
import java.util.*;

public class Empleado extends Persona{
	private String noEmpleado;

	public Empleado(String nombre, int edad, char sexo, String noEmpleado){
		super (nombre, edad, sexo);
		this.noEmpleado= noEmpleado;
	}

	public void setNoEmpleado (){
		this.noEmpleado= noEmpleado;
	}
	public String getNoEmpleado(){
		return noEmpleado;
	}
}