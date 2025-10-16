import java.lang.*;
import java.util.*;

public class Main{
	public static void main (String args []){
		Cliente cl1= new Cliente("pepe", 21, 'M', "CL01", new Cuenta(250, new Tarjeta("12345","4567")));
		System.out.println("##### Cliente #####");
		System.out.println("Nombre: "+cl1.getNombre());
		System.out.println("No. de Cliente: "+cl1.getNoCliente());
		System.out.println("Saldo: "+cl1.getCuenta().getSaldo());
		System.out.println("Numero de tarjeta: "+cl1.getCuenta().getTarjeta().getNoTarjeta());

		Empleado em1= new Empleado ("Luis", 34, 'M', "EMP01");
		System.out.println("##### Empleado #####");
		System.out.println("Nombre: "+em1.getNombre());
		System.out.println("No. de Empleado: "+em1.getNoEmpleado());
	}
}