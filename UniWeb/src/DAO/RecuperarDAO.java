package DAO;

import Model.Recuperar;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RecuperarDAO {

	Recuperar re = Recuperar.getInstance();
	
    public boolean recuperarUsuario(String email){
      
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      boolean check = false;
              
      try {
            stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Email = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
           
            
            if(rs.next()){
            	
            	re.setUsuario(rs.getString(20));
            	check = true;
            
            	
           }
            
       }catch (SQLException ex) {
        Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
          ConnectionFactory.closeConnection(con, stmt, rs);
      }
      return check;
   }
   public boolean recuperarSenha(String usuario, String pergunta){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
                
        try {
              stmt = con.prepareStatement("SELECT * FROM cadastro WHERE usuario = ? and perguntasecreta = ?");
              stmt.setString(1, usuario);
              stmt.setString(2, pergunta);
              rs = stmt.executeQuery();
              
              
              if(rs.next()){
               re.setSenha(rs.getString(21));    
              check = true;
              }
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
     }
}
