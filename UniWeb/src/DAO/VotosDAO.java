package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class VotosDAO {
	
	
	  public void InserirLike(int id , int like){
	      
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      
	      try {
	            stmt = con.prepareStatement("UPDATE sugestoes SET Like_Positivo = ? WHERE ID_Sugestao= ?");
	          
	            stmt.setInt(1, like);
	            stmt.setInt(2, id);
	            stmt.executeUpdate();
	            
	            
	            JOptionPane.showMessageDialog(null, "Seu Like foi enviado com sucesso!");
	      } catch (SQLException ex) {
	          JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio do seu voto, tente novamente.");
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  }
	  
	  public void InserirDeslike(int id , int deslike){
	      
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      
	      try {
	            stmt = con.prepareStatement("UPDATE sugestoes SET Deslike_Negativo = ? WHERE ID_Sugestao= ?");
	          
	            stmt.setInt(1, id);
	            stmt.setInt(2, deslike);
	            stmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Seu Deslike foi enviado com sucesso!");

	      } catch (SQLException ex) {
	          JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio do seu voto, tente novamente.");
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  }

	  
	public void InserirVoto(int ID_Usuario , int ID_Sugestao){
	      
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      
	      
	      try {
	            stmt = con.prepareStatement("INSERT INTO votos(cadastro_ID, sugestoes_ID_Sugestao)VALUES(?,?)");
	          
	            stmt.setInt(1,ID_Usuario);
	            stmt.setInt(2,ID_Sugestao);

	            
	            
	            stmt.executeUpdate();


	      } catch (SQLException ex) {
	          JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio do seu voto ,tente novamente.");
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  }
	
	
	
	//Procura no banco de dados se o usuario ID já deu o like alguma vez na sugestão ID 
	  public boolean CheckVoto(int ID_Usuario , int ID_Sugestao){
		  
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      boolean check = false;
	      
	      try {
	          stmt = con.prepareStatement("SELECT * FROM votos WHERE cadastro_ID = ? and sugestoes_ID_Sugestao = ?");
	          stmt.setInt(1, ID_Usuario);
	          stmt.setInt(2, ID_Sugestao);
	          rs = stmt.executeQuery();
	          
	          
	        if(rs.next()){
	        	check = true;
	        }  
	      }
	      catch (SQLException ex) {
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	     return check;
	  } 

}
