import java.lang.*;
import java.util.*;

public class Cuenta{
	private double saldo;
	private Tarjeta tarjeta;

	public Cuenta (double saldo, Tarjeta tarjeta){
		this.saldo= saldo;
		this.tarjeta= tarjeta;
	}
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
		return this.tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta){
		this.tarjeta= tarjeta;
	}
}