package Model;

public class SugestoesJTable {
		
		private int id;
		private String titulo;
		private String texto;
		private String data;
		private String status;
		private int like;
		private int deslike ;
		private String categoria;
		private int Cadastro_ID;
		private String autor;
		private static SugestoesJTable instance;
		
		
	    public static SugestoesJTable getInstance() {
			if (instance == null)
	            instance = new SugestoesJTable();
	        return instance;
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

