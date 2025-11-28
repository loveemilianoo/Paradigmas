package app.models;

public class Usuario extends Persona{
    private String login;
    private String password;

    public Usuario( String rfc, String curp, String nombre, int edad, char sexo, String correo, String login, String password) {
        super(rfc, curp, nombre, edad, sexo, correo);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
   
    
}
