package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comentario {

	private int ID;
	private String comentario;
	private String data;
	private String hora;
	
	private int ID_sugestao;
	private int ID_cadastro;
	
	private String autor;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	private String getDatee() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}	

	public String getDate() {
		return getDatee();
	}
	
	private String getTimee() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}	

	public String getTime() {
		return getTimee();
	}


	public int getID_sugestao() {
		return ID_sugestao;
	}

	public void setID_sugestao(int iD_sugestao) {
		ID_sugestao = iD_sugestao;
	}

	public int getID_cadastro() {
		return ID_cadastro;
	}

	public void setID_cadastro(int iD_cadastro) {
		ID_cadastro = iD_cadastro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

}
