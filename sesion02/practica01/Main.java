//Sesion02-Practica01
import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String args []){
		/*Cuenta c1= new Cuenta(100);
		
		System.out.println("Saldo: "+ c1.consultarSaldo());

		c1.realizarDeposito(200);
		System.out.println("Saldo: "+ c1.consultarSaldo());

		c1.realizarRetiro(150);
		System.out.println("Saldo: "+ c1.consultarSaldo());

		Cuenta c2= new Cuenta(1000);
		System.out.println("Saldo: "+ c2.consultarSaldo());*/

		Tarjeta t1= new Tarjeta ("1234567898761236", "1234");
		System.out.println("Numero de tarjeta: "+ t1.getNoTarjeta());
		System.out.println("Numero de nip: "+ t1.getNip());

		Cuenta c1= new Cuenta (100, t1);
		System.out.println("#################");
		System.out.println("Saldo: "+ c1.consultarSaldo());
		System.out.println("Numero de tarjeta: "+c1.getTarjeta().getNoTarjeta());
		System.out.println("Numero de nip: "+c1.getTarjeta().getNip());

		Cuenta c2= new Cuenta (200, new Tarjeta ("9876543219876543", "4321"));
		System.out.println("#################");
		System.out.println("Saldo: "+ c2.consultarSaldo());
		System.out.println("Numero de tarjeta: "+c2.getTarjeta().getNoTarjeta());
		System.out.println("Numero de nip: "+c2.getTarjeta().getNip());

		Cliente cl1= new Cliente("pepe", 21, 'M', "CL01", new Cuenta(250, new Tarjeta("12345","4567")));
		System.out.println("##### Cliente #####");
		System.out.println("Nombre: "+cl1.getNombre());
		System.out.println("No. de Cliente: "+cl1.getNoCliente());
		System.out.println("Saldo: "+cl1.getCuenta().getSaldo());
		System.out.println("Numero de tarjeta: "+cl1.getCuenta().getTarjeta().getNoTarjeta());

		cl1.getCuenta().realizarDeposito(250);
		System.out.println("Saldo: "+cl1.getCuenta().getSaldo());	
	}
}