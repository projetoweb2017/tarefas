package Model;

public class Cadastro {
    
	private int Id;
    private String Nome_Completo;
    private String Data_de_Nascimento;
    private String Sexo;
    private String CPF = "0";
    private String RG = "0";
    private String CEP = "0";
    private String Endereco = "0";
    private String Numero = "0";
    private String Complemento = "0";
    private String Bairro = "0";
    private String Cidade = "0";
    private String UF = "0";
    private String Email;
    private String Telefone_Residencial = "0";
    private String Telefone_Celular;
    private String Universidade = "0";
    private String EnderecoUniversidade = "0";
    private String Curso;
    private String Usuario;
    private String Senha;
    private String ConfirmarSenha = "0";
    private String PerguntaSecreta = "0";
    private String Cargo = "Colaborador";
    private String Categoria = "Colaborador";

    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String Nome_Completo) {
        this.Nome_Completo = Nome_Completo;
    }

    public String getData_de_Nascimento() {
        return Data_de_Nascimento;
    }

    public void setData_de_Nascimento(String Data_de_Nascimento) {
        this.Data_de_Nascimento = Data_de_Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone_Residencial() {
        return Telefone_Residencial;
    }

    public void setTelefone_Residencial(String Telefone_Residencial) {
        this.Telefone_Residencial = Telefone_Residencial;
    }

    public String getTelefone_Celular() {
        return Telefone_Celular;
    }

    public void setTelefone_Celular(String Telefone_Celular) {
        this.Telefone_Celular = Telefone_Celular;
    }

    public String getUniversidade() {
        return Universidade;
    }

    public void setUniversidade(String Universidade) {
        this.Universidade = Universidade;
    }

    public String getEnderecoUniversidade() {
        return EnderecoUniversidade;
    }

    public void setEnderecoUniversidade(String EnderecoUniversidade) {
        this.EnderecoUniversidade = EnderecoUniversidade;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getConfirmarSenha() {
        return ConfirmarSenha;
    }

    public void setConfirmarSenha(String ConfirmarSenha) {
        this.ConfirmarSenha = ConfirmarSenha;
    }

    public String getPerguntaSecreta() {
        return PerguntaSecreta;
    }

    public void setPerguntaSecreta(String PerguntaSecreta) {
        this.PerguntaSecreta = PerguntaSecreta;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
            
}
