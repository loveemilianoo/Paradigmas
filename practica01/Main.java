//practica01
import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String args []){
		Scanner sc = new Scanner(System.in);
		Cuenta c1= new Cuenta(100);
		int opci= 0;

		while (opci!= 4){
		System.out.println("Que operacion desea hacer?");
		System.out.println("1. Deposito");
		System.out.println("2. Retiro");
		System.out.println("3. Consulta de saldo");
		System.out.println("4. Salir");
		opci = sc.nextInt();
		
		switch (opci){
			case 1:
				System.out.println("Cuando desea ingresar? ");
				double ingreso = sc.nextDouble();
				c1.deposito(ingreso);
				break;
			case 2:
			 	System.out.println("Cuanto desea retirar?");
				double retiro = sc.nextDouble();
				c1.retiro(retiro);
				break;
			case 3:
				System.out.println("Su saldo total es: "+c1.mostrar());
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("No valido");
		}
	}
	}
}