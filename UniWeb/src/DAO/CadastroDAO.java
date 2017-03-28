package DAO;

import Model.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroDAO {

	private boolean check = false;

	public int InserirCadastro(Cadastro ca) {
		
		String sqlInsert = "INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlInsert);) {
				stmt.setString(1, ca.getNome_Completo());
				stmt.setString(2, ca.getData_de_Nascimento());
				stmt.setString(3, ca.getSexo());
				stmt.setString(4, ca.getCPF());
				stmt.setString(5, ca.getRG());
				stmt.setString(6, ca.getCEP());
				stmt.setString(7, ca.getEndereco());
				stmt.setString(8, ca.getNumero());
				stmt.setString(9, ca.getComplemento());
				stmt.setString(10, ca.getBairro());
				stmt.setString(11, ca.getCidade());
				stmt.setString(12, ca.getUF());
				stmt.setString(13, ca.getEmail());
				stmt.setString(14, ca.getTelefone_Residencial());
				stmt.setString(15, ca.getTelefone_Celular());
				stmt.setString(16, ca.getUniversidade());
				stmt.setString(17, ca.getEnderecoUniversidade());
				stmt.setString(18, ca.getCurso());
				stmt.setString(19, ca.getUsuario());
				stmt.setString(20, ca.getSenha());
				stmt.setString(21, ca.getPerguntaSecreta());
				stmt.setString(22, ca.getCargo());
				stmt.setString(23, ca.getCategoria());
				stmt.execute();
				
				String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					ca.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ca.getId();
	}

	
	public Cadastro carregar(int id) {
		Cadastro cadastro = new Cadastro();
		cadastro.setId(id);
		String sqlSelect = "SELECT Nome_Completo, Data_de_Nascimento, Sexo , Email , Telefone_Celular, Curso FROM cadastro WHERE cadastro.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cadastro.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cadastro.setNome_Completo(rs.getString("Nome_Completo"));
					cadastro.setData_de_Nascimento(rs.getString("Data_de_Nascimento"));
					cadastro.setSexo(rs.getString("Sexo"));
					cadastro.setEmail(rs.getString("Email"));
					cadastro.setTelefone_Celular(rs.getString("Telefone_Celular"));
					cadastro.setCurso(rs.getString("Curso"));
				} else {
					cadastro.setId(-1);
					cadastro.setNome_Completo(null);
					cadastro.setData_de_Nascimento(null);
					cadastro.setSexo(null);
					cadastro.setEmail(null);
					cadastro.setTelefone_Celular(null);
					cadastro.setCurso(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cadastro;
	}

	public boolean CheckUsuario(String Usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Usuario = ?");
			stmt.setString(1, Usuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este Usuário registrado.");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	public boolean CheckEmail(String Email) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Email = ?");
			stmt.setString(1, Email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este email registrado");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros
	public List<Cadastro> CarregarCadastros() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNome_Completo(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros no
	// campo de busca
	public List<Cadastro> CarregarCadastrosBuscar(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Nome_Completo LIKE ?");
			stmt.setString(2, "%" + nome + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNome_Completo(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os colaboradores
	public List<Cadastro> CarregarCadastrosColaborador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Colaborador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNome_Completo(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os avaliadores
	public List<Cadastro> CarregarCadastrosAvaliador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Avaliador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNome_Completo(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar os superiores
	public List<Cadastro> CarregarCadastrosSuperior() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Superior'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNome_Completo(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}
}
