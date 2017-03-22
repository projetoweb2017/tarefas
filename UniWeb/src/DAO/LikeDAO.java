package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


import Model.Sugestao;

public class LikeDAO {
	
	
	
	public void InserirLike(int ID_Usuario , int ID_Sugestao){
	      
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      
	      
	      try {
	            stmt = con.prepareStatement("INSERT INTO like_gostei (cadastro_ID, sugestoes_ID_Sugestao)VALUES(?,?)");
	          
	            stmt.setInt(1,ID_Usuario);
	            stmt.setInt(2,ID_Sugestao);

	            
	            
	            stmt.executeUpdate();
	      
	            JOptionPane.showMessageDialog(null, "Like enviado com sucesso, obrigado!");


	      } catch (SQLException ex) {
	          JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio do Like ,tente novamente.");
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  }
	
	
	
	//Procura no banco de dados se o usuario ID já deu o like alguma vez na sugestão ID 
	  public boolean CheckLike(int ID_Usuario , int ID_Sugestao){
		  
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      boolean check = false;
	      
	      try {
	          stmt = con.prepareStatement("SELECT * FROM like_gostei WHERE cadastro_ID = ? and sugestoes_ID_Sugestao = ?");
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
	  public void ContadorLike(int ID_Sugestao){
		  
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	          stmt = con.prepareStatement("select count(*) from like_gostei where sugestoes_ID_Sugestao = ?");
	          stmt.setInt(1, ID_Sugestao);
	          rs = stmt.executeQuery();
	          
	          
	        if(rs.next()){
	        	
	        	Sugestao sugestao = new Sugestao();
	        	
	        	sugestao.setLike(rs.getInt(1));

	        }  
	      }
	      catch (SQLException ex) {
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  } 

}
