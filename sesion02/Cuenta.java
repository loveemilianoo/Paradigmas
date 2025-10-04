import java.lang.*;
import java.util.*;

public class Cuenta{
	private double saldo;
	private Tarjeta tarjeta;

	public Cuenta (double saldo){
		this.saldo= saldo;
	}

	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double saldo){
		this.saldo=saldo;
	}
	public double consultarSaldo(){
		return this.saldo;
	}
	public double realizarDeposito(double deposito){
		this.saldo= this.saldo+deposito;
		return saldo;
	}
	public double realizarRetiro (double retiro){
		this.saldo=  this.saldo - retiro;
		return saldo;
	}

	public Tarjeta getTarjeta(){
		return this.Tarjeta;
	}
	public Tarjeta setTarjeta(Tarjeta tarjeta){
		this.Tarjeta= tarjeta;
	}

	//Get y Set de tarjeta y añadir la tarjeta al constructor
}