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


import Model.Comentario;
import Model.SugestoesJTable;

public class ComentarioDAO {
	
	
	private static ComentarioDAO instance;
	
    public static ComentarioDAO getInstance() {
        if (instance == null)
            instance = new ComentarioDAO();
        return instance;
    }
	
	  public void InserirComentario(Comentario c){
	      
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      
	      
	      try {
	            stmt = con.prepareStatement("INSERT INTO comentario (Comentario, Data_Comentario, Hora_Comentario, sugestoes_ID_Sugestao, cadastro_ID, Autor)VALUES(?,?,?,?,?,?)");
	          
	            stmt.setString(1,c.getComentario());
	            stmt.setString(2,c.getDate());
	            stmt.setString(3,c.getTime());
	            stmt.setInt(4,c.getID_sugestao());
	            stmt.setInt(5,c.getID_cadastro());
	            stmt.setString(6,c.getAutor());

	            
	            
	            stmt.executeUpdate();
	      
	            JOptionPane.showMessageDialog(null, "Seu comentário foi postado com sucesso!");


	      } catch (SQLException ex) {
	          JOptionPane.showMessageDialog(null, "Ocorreu uma falha no envio do seu comentário, tente novamente.");
	          Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	  }
//////////////////////////////////// Carrega comentarios da sugestão ////////////////////////////////////////////////////
	 public List<Comentario> CarregarComentarios(){
		 
	      Connection con = ConnectionFactory.getConnection();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
	      
	      try {
	    	  	SugestoesJTable su = SugestoesJTable.getInstance();
	    	  	
	    	  
	            stmt = con.prepareStatement("SELECT * FROM comentario WHERE sugestoes_ID_Sugestao = ? ORDER BY SUBSTR( ID_Comentario, 1, 1) desc");	 
	            stmt.setInt(1, su.getId());
	            
	            rs = stmt.executeQuery();	            

	            while(rs.next()){
	            	
	            Comentario c = new Comentario();
	           
	            c.setComentario(rs.getString(2));
	            c.setData(rs.getString(3));
	            c.setHora(rs.getString(4));
	            c.setAutor(rs.getString(7));
	            
	            comentarios.add(c);

	            
	          }
	      } catch (Exception e) {
	    	  JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());
	        
	      }finally{
	          ConnectionFactory.closeConnection(con, stmt);
	     }
	     return comentarios;
	 }
}
