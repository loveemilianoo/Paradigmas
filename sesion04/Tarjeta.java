public class Tarjeta{
	private String noTarjeta;
	private String nip;

	public Tarjeta (String noTarjeta, String nip){
		this.noTarjeta= noTarjeta;
		this.nip= nip;
	}

	public String getNoTarjeta(){
		return this.noTarjeta;
	}
	public void setNoTarhjeta(String noTarjeta){
		this.noTarjeta = noTarjeta;
	}
	public String getNip (){
		return this.nip;
	}
	public void setNip(String nip){
		this.nip= nip;
	}
}