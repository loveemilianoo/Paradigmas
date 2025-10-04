import java.lang.*;
import java.util.*;

public class Persona{
	private String nombre;
	private int edad;
	private char sexo;

	public Persona (){
	}
	
	public Persona (String nombre, int edad, char sexo){
		this.nombre= nombre;
		this.edad= edad;
		this.sexo= sexo;
	}


	public String getNombre (){
		return this.nombre;
	}
	public void setNombre (String nombre){
		this.nombre= nombre;
	}
	public int getEdad (){
		return this.edad;
	}

	public void setEdad (int edad){
		this.edad= edad;
	}
	public char getSexo (){
		return this.sexo;
	}

	public void setSexo (char sexo){
		this.sexo= sexo;
	}

	public String obtenerDatos(){
		String cadena= "Nombre: "+ this.nombre+ " Edad: "+this.edad+ " Sexo: "+this.sexo;
		return cadena;
	}


}