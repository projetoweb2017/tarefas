package Model;

public class Registro {
	
	private String Nome_Completo;
    private String Data_de_Nascimento;
    private String Sexo;
    private String CPF;
    private String RG;
    private String CEP;
    private String Endereco;
    private String Numero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String UF;
    private String Email;
    private String Telefone_Residencial;
    private String Telefone_Celular;
    private String Universidade;
    private String EnderecoUniversidade;
    private String Curso;
    private String Usuario;
    private String Senha;
    private String ConfirmarSenha;
    private String PerguntaSecreta;
    private String Cargo;
    private String Categoria;
    private int ID;
    
    
	private static Registro instance;
	
    public static Registro getInstance() {
        if (instance == null)
            instance = new Registro();
        return instance;
    }
    
	
	public String getNome_Completo() {
		return Nome_Completo;
	}
	public void setNome_Completo(String nome_Completo) {
		Nome_Completo = nome_Completo;
	}
	public String getData_de_Nascimento() {
		return Data_de_Nascimento;
	}
	public void setData_de_Nascimento(String data_de_Nascimento) {
		Data_de_Nascimento = data_de_Nascimento;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone_Residencial() {
		return Telefone_Residencial;
	}
	public void setTelefone_Residencial(String telefone_Residencial) {
		Telefone_Residencial = telefone_Residencial;
	}
	public String getTelefone_Celular() {
		return Telefone_Celular;
	}
	public void setTelefone_Celular(String telefone_Celular) {
		Telefone_Celular = telefone_Celular;
	}
	public String getUniversidade() {
		return Universidade;
	}
	public void setUniversidade(String universidade) {
		Universidade = universidade;
	}
	public String getEnderecoUniversidade() {
		return EnderecoUniversidade;
	}
	public void setEnderecoUniversidade(String enderecoUniversidade) {
		EnderecoUniversidade = enderecoUniversidade;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
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
	public String getConfirmarSenha() {
		return ConfirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		ConfirmarSenha = confirmarSenha;
	}
	public String getPerguntaSecreta() {
		return PerguntaSecreta;
	}
	public void setPerguntaSecreta(String perguntaSecreta) {
		PerguntaSecreta = perguntaSecreta;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}


}
