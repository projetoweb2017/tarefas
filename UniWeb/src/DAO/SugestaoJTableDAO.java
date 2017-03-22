package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Model.SugestoesJTable;

public class SugestaoJTableDAO {

	SugestoesJTable suj = SugestoesJTable.getInstance();

		  public void PreencherSugestaoAprovada(String titulo , String data){
		      
			  
		      Connection con = ConnectionFactory.getConnection();
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
      
		      try {
		            stmt = con.prepareStatement("SELECT * FROM sugestoes WHERE Titulo = ? and Data_Postada = ?");
		          
		            stmt.setString(1, titulo);
		            stmt.setString(2, data);
		            rs = stmt.executeQuery();
		            
		            if(rs.next()){
		            	
		            	suj.setId(rs.getInt(1));
		            	suj.setTitulo(rs.getString(2));
		            	suj.setTexto(rs.getString(3));
		            	suj.setData(rs.getString(4));
		            	suj.setLike(rs.getInt(6));
		            	suj.setDeslike(rs.getInt(7));
		            	suj.setCategoria(rs.getString(8));
		            	suj.setCadastro_ID(rs.getInt(9));
		            	suj.setAutor(rs.getString(10));
		            	
		           
		            }

		      } catch (SQLException ex) {
		          JOptionPane.showMessageDialog(null, "Sugestão não encontrada, tente novamente");
		          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
		        
		      }finally{
		          ConnectionFactory.closeConnection(con, stmt);
		     }
		  }
		  public void PreencherSugestaoAguardando(String titulo , String data){
		      
			  
		      Connection con = ConnectionFactory.getConnection();
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
      
		      try {
		            stmt = con.prepareStatement("SELECT * FROM sugestoes WHERE Titulo = ? and Data_Postada = ?");
		          
		            stmt.setString(1, titulo);
		            stmt.setString(2, data);
		            rs = stmt.executeQuery();
		            
		            if(rs.next()){
		            	
		            	suj.setId(rs.getInt(1));
		            	suj.setTitulo(rs.getString(2));
		            	suj.setTexto(rs.getString(3));
		            	suj.setData(rs.getString(4));
		            	suj.setLike(rs.getInt(6));
		            	suj.setDeslike(rs.getInt(7));
		            	suj.setCadastro_ID(rs.getInt(9));
		            	suj.setAutor(rs.getString(10));
		            	
		           
		            }

		      } catch (SQLException ex) {
		          JOptionPane.showMessageDialog(null, "Sugestão não encontrada, tente novamente");
		          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
		        
		      }finally{
		          ConnectionFactory.closeConnection(con, stmt);
		     }
		  }
		  public void PreencherSugestaoReprovada(String titulo , String data){
		      
			  
		      Connection con = ConnectionFactory.getConnection();
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
      
		      try {
		            stmt = con.prepareStatement("SELECT * FROM sugestoes WHERE Titulo = ? and Data_Postada = ?");
		          
		            stmt.setString(1, titulo);
		            stmt.setString(2, data);
		            rs = stmt.executeQuery();
		            
		            if(rs.next()){
		            	
		            	suj.setId(rs.getInt(1));
		            	suj.setTitulo(rs.getString(2));
		            	suj.setTexto(rs.getString(3));
		            	suj.setData(rs.getString(4));
		            	suj.setLike(rs.getInt(6));
		            	suj.setDeslike(rs.getInt(7));
		            	suj.setCadastro_ID(rs.getInt(9));
		            	suj.setAutor(rs.getString(10));
		            	
		           
		            }

		      } catch (SQLException ex) {
		          JOptionPane.showMessageDialog(null, "Sugestão não encontrada, tente novamente");
		          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
		        
		      }finally{
		          ConnectionFactory.closeConnection(con, stmt);
		     }
		  }
		  public void PreencherSugestaoAguardando(int id){
		      
			  
		      Connection con = ConnectionFactory.getConnection();
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
      
		      try {
		            stmt = con.prepareStatement("SELECT * FROM sugestoes WHERE ID_Sugestao = ?");
		          
		            stmt.setInt(1, id);
		            rs = stmt.executeQuery();
		            
		            if(rs.next()){
		            	
		            	suj.setId(rs.getInt(1));
		            	suj.setTitulo(rs.getString(2));
		            	suj.setTexto(rs.getString(3));
		            	suj.setData(rs.getString(4));
		            	suj.setCadastro_ID(rs.getInt(9));
		            	suj.setAutor(rs.getString(10));
		            	
		           
		            }

		      } catch (SQLException ex) {
		          JOptionPane.showMessageDialog(null, "Sugestão não encontrada, tente novamente");
		          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
		        
		      }finally{
		          ConnectionFactory.closeConnection(con, stmt);
		     }
		  }
		  
 public void PreencherSugestaoTop(String titulo , String autor , int like){
		      
			  
		      Connection con = ConnectionFactory.getConnection();
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
      
		      try {
		            stmt = con.prepareStatement("SELECT * FROM sugestoes WHERE Titulo = ? and Autor = ? and Like_Positivo = ?");
		          
		            stmt.setString(1, titulo);
		            stmt.setString(2, autor);
		            stmt.setInt(3, like);
		            rs = stmt.executeQuery();
		            
		            if(rs.next()){
		            	
		            	suj.setId(rs.getInt(1));
		            	suj.setTitulo(rs.getString(2));
		            	suj.setTexto(rs.getString(3));
		            	suj.setData(rs.getString(4));
		            	suj.setLike(rs.getInt(6));
		            	suj.setDeslike(rs.getInt(7));
		            	suj.setCategoria(rs.getString(8));
		            	suj.setCadastro_ID(rs.getInt(9));
		            	suj.setAutor(rs.getString(10));
		            	
		           
		            }

		      } catch (SQLException ex) {
		          JOptionPane.showMessageDialog(null, "Sugestão não encontrada, tente novamente");
		          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
		        
		      }finally{
		          ConnectionFactory.closeConnection(con, stmt);
		     }
		  }

}
