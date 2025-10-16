//Sesion03
import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String args []){
		float x= 21.5f;
		System.out.println("Valor de x: "+x);

		for (int i=0; i<= 10;++i){
			System.out.println("El valor de i es: "+i);
		}

		byte xx=10;
		byte y=20;
		byte z=0;

		z= (byte)(xx+y);
		System.out.println("Valor de z = "+z);

		int var1=3, var2=0;
		boolean var3= (var1>=var2) ;
		System.out.println("Valor de var3= "+var3);

		int edad =10;
		String mensaje= "";
		/*if (edad<=18){
			mensaje= "Soy un niño";
		} else {
			mensaje= "Soy un adulto";
		}*/

		mensaje = (edad<=18) ? "Soy un niño" : "Soy un adulto";
		System.out.println(mensaje);
	}
}
