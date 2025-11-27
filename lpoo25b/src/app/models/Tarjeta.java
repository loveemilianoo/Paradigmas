package app.models;

public class Tarjeta {
    private String noTarjeta;
    private String nip;

    public Tarjeta(String noTarjeta, String nip) {
        this.noTarjeta = noTarjeta;
        this.nip = nip;
    }

    public String getNoTarjeta() {
        return noTarjeta;
    }
    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }
    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    
}
