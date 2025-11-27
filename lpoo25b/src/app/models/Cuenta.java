package app.models;

public class Cuenta {
    private double saldo;
    private Tarjeta tarjeta;

    public Cuenta(double saldo, Tarjeta tarjeta) {
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Tarjeta getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
