import java.lang.*;
import java.util.*;

public class Cuenta{
	private double saldo;

	public Cuenta(double saldo){
		this.saldo= saldo;
	}

	public double deposito(double ingreso){
		saldo= saldo+ingreso;
		System.out.println("Su saldo ha aumentado a: "+saldo);
		return saldo;
	}

	public double retiro (double retiro){
		if ( saldo <=  0 ){
			System.out.println("No hay suficiente saldo");
		} else  if (retiro < saldo){
			saldo= saldo - retiro;
			System.out.println("Su saldo ha disminuido a: "+saldo);
		} else {
			System.out.println("No hay suficiente saldo");
		}
		return saldo;
	}

	public double mostrar(){
		System.out.println("Su saldo general es: "+saldo);
		return saldo;
	}
	
}