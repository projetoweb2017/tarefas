package Model;

public class Recuperar {
	
	private String Usuario;
	private String Senha;
	
	private static Recuperar instance;
	
    public static Recuperar getInstance() {
        if (instance == null)
            instance = new Recuperar();
        return instance;
    }
	
	
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}

}
