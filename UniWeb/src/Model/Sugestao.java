package Model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Sugestao {
	
	private int id;
	private String titulo;
	private String texto;
	private String data;
	private String status = "Aguardando Avaliador";
	private int like = 0;
	private int deslike = 0;
	private String categoria;
	private int Cadastro_ID;
	private String autor;
	
	private static Sugestao instance;
	
    public static Sugestao getInstance() {
        if (instance == null)
            instance = new Sugestao();
        return instance;
    }

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}	
	public String getDate(){
		return getDateTime();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getDeslike() {
		return deslike;
	}
	public void setDeslike(int deslike) {
		this.deslike = deslike;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCadastro_ID() {
		return Cadastro_ID;
	}

	public void setCadastro_ID(int cadastro_ID) {
		Cadastro_ID = cadastro_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

}
