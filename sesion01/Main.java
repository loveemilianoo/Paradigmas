//Sesion01
import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String [] args){
		Persona persona1 =new Persona ();
		persona1.setNombre("Juanito Perez");
		persona1.setEdad(23);
		persona1.setSexo('M');

		System.out.println("Nombre: " + persona1.getNombre());
		System.out.println("Edad: " + persona1.getEdad());
		System.out.println("Sexo: " + persona1.getSexo());

		Persona persona2 = new Persona("Luis Perez", 18, 'M');

		System.out.println("Nombre: " + persona2.getNombre());
		System.out.println("Edad: " + persona2.getEdad());
		System.out.println("Sexo: " + persona2.getSexo());

		Persona persona3 = new Persona("Ana", 19, 'F');
		System.out.println(persona3.obtenerDatos());

		/**System.out.println("Especie: " + Personaespecie);
		System.out.println("Especie persona1: " + persona1.especie);
		System.out.println("Especie persona2: " + persona2.especie);
		System.out.println("Especie persona3: " + persona3.especie);

		Persona.especie = "Vegetal";
		System.out.println("Especie persona1: " + persona1.especie);
		System.out.println("Especie persona2: " + persona2.especie);
		System.out.println("Especie persona3: " + persona3.especie);**/

	}
}
