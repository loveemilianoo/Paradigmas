import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String args []){
		Cuenta c1= new Cuenta(100);
		
		System.out.println("Saldo: "+ c1.consultarSaldo());

		c1.realizarDeposito(200);
		System.out.println("Saldo: "+ c1.consultarSaldo());

		c1.realizarRetiro(150);
		System.out.println("Saldo: "+ c1.consultarSaldo());

		Cuenta c2= new Cuenta(1000);
		System.out.println("Saldo: "+ c2.consultarSaldo());

		Tarjeta t1= new Tarjeta ("1234567898761236", "1234");
		System.out.println("Numero de tarjeta: "+ t1.getNoTarjeta());
		System.out.println("Numero de tarjeta: "+ t1.getNip());

	}
}