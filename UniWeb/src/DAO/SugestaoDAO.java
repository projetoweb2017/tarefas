package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


import Model.Login;
import Model.Sugestao;

public class SugestaoDAO {

	private static SugestaoDAO instance;

	public static SugestaoDAO getInstance() {
		if (instance == null)
			instance = new SugestaoDAO();
		return instance;
	}

	public void InserirSugestao(Sugestao su) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO sugestoes (Titulo, Texto, Data_Postada, Status_Sugestao, Like_Positivo, Deslike_Negativo, Categoria, Cadastro_ID, Autor)VALUES(?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, su.getTitulo());
			stmt.setString(2, su.getTexto());
			stmt.setString(3, su.getDate());
			stmt.setString(4, su.getStatus());
			stmt.setInt(5, su.getLike());
			stmt.setInt(6, su.getDeslike());
			stmt.setString(7, su.getCategoria());
			stmt.setInt(8, su.getCadastro_ID());
			stmt.setString(9, su.getAutor());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null,
					"Sua sugestão foi enviada com sucesso." + " \nAguarde até um de nossos avaliadores visualizá-la!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio da sugestão, tente novamente.");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Sugestao> TopSugestoes() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement("SELECT * FROM sugestoes Order By Like_Positivo desc LIMIT 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesInfraestrutura() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Infraestrutura' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesApoio() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Apoio' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesCursos() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Cursos' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesEventos() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Eventos' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesSeguranca() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Segurança' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	public List<Sugestao> TopSugestoesSugestoesLivres() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Sugestões Livres' Order By Like_Positivo desc Limit 10");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				sugestao.setAutor(rs.getString(10));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	//////////////////////////////////// Carrega sugestões feitas pelo usuario -
	//////////////////////////////////// Historico
	//////////////////////////////////// ////////////////////////////////////////////////////
	public List<Sugestao> CarregarSugestoesHistorico() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			Login lo = Login.getInstance();

			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE cadastro_ID = ? ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");
			stmt.setInt(1, lo.getID());

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setTitulo(rs.getString(2));
				sugestao.setData(rs.getString(4));
				sugestao.setStatus(rs.getString(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}
	////////////////////////////// Alterar a sugestão para aprovada
	////////////////////////////// /////////////////////////////////////////////////////////////////

	public boolean AprovarSugestao(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		boolean check = false;

		try {
			stmt = con.prepareStatement("UPDATE sugestoes SET Status_Sugestao = 'Aprovada' WHERE ID_Sugestao= ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

			check = true;

		} catch (SQLException ex) {
			Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}
	////////////////////////////// Alterar a sugestão para Reprovada
	////////////////////////////// /////////////////////////////////////////////////////////////////

	public boolean ReprovarSugestao(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		boolean check = false;

		try {
			stmt = con.prepareStatement("UPDATE sugestoes SET Status_Sugestao = 'Reprovada' WHERE ID_Sugestao= ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

			check = true;

		} catch (SQLException ex) {
			Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	//////////////////////////////// Aprovadas///////////////////////////////////////////////////////////////////////////////////////

	// Carrega apenas sugestões com categoria Infraestrutura
	public List<Sugestao> CarregarSugestoesInfraestruturaAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Infraestrutura' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Cursos
	public List<Sugestao> CarregarSugestoesCursosAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Cursos' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Eventos
	public List<Sugestao> CarregarSugestoesEventosAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Eventos' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Apoio
	public List<Sugestao> CarregarSugestoesApoioAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Apoio' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Segurança
	public List<Sugestao> CarregarSugestoesSegurancaAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Segurança' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Sugestoes Livres
	public List<Sugestao> CarregarSugestoesSugestoesLivresAprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Sugestões Livres' and Status_Sugestao = 'Aprovada' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	///////////////////////////// Aguardando
	///////////////////////////// Aprovação//////////////////////////////////////////////////////////////////////////////////////////////
	// Carrega apenas sugestões com categoria Infraestrutura
	public List<Sugestao> CarregarSugestoesInfraestruturaAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Infraestrutura' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Cursos
	public List<Sugestao> CarregarSugestoesCursosAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Cursos' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Eventos
	public List<Sugestao> CarregarSugestoesEventosAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Eventos' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Apoio
	public List<Sugestao> CarregarSugestoesApoioAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Apoio' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Segurança
	public List<Sugestao> CarregarSugestoesSegurancaAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Segurança' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Sugestoes Livres
	public List<Sugestao> CarregarSugestoesSugestoesLivresAguardando() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Sugestões Livres' and Status_Sugestao = 'Aguardando Avaliador' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));
				sugestao.setAutor(rs.getString(10));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	///////////////////////////// Reprovadas//////////////////////////////////////////////////////////////////////////////////////////////
	// Carrega apenas sugestões com categoria Infraestrutura
	public List<Sugestao> CarregarSugestoesInfraestruturaReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Infraestrutura' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Cursos
	public List<Sugestao> CarregarSugestoesCursosReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Cursos' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Eventos
	public List<Sugestao> CarregarSugestoesEventosReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Eventos' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Apoio
	public List<Sugestao> CarregarSugestoesApoioReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Apoio' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Segurança
	public List<Sugestao> CarregarSugestoesSegurancaReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Segurança' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}

	// Carrega apenas sugestões com categoria Sugestoes Livres
	public List<Sugestao> CarregarSugestoesSugestoesLivresReprovadas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Sugestao> sugestoes = new ArrayList<Sugestao>();

		try {
			stmt = con.prepareStatement(
					"SELECT * FROM sugestoes WHERE Categoria = 'Sugestões Livres' ORDER BY SUBSTR( Data_Postada, 7, 4) desc , SUBSTR( Data_Postada, 4, 2) desc ,  SUBSTR( Data_Postada, 1, 2) desc");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Sugestao sugestao = new Sugestao();

				// sugestao.setId(rs.getInt(1));
				sugestao.setTitulo(rs.getString(2));
				// sugestao.setTexto(rs.getString(3));
				sugestao.setData(rs.getString(4));
				// sugestao.setStatus(rs.getInt(5));
				sugestao.setLike(rs.getInt(6));
				sugestao.setDeslike(rs.getInt(7));
				// sugestao.setCategoria(rs.getString(8));
				// sugestao.setCadastro_ID(rs.getInt(9));

				sugestoes.add(sugestao);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return sugestoes;
	}
}
