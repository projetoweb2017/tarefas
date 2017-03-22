package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import Model.Login;
import Model.Relatorio;

public class RelatorioDAO {
	
	Login Lo = Login.getInstance();
	
	Relatorio rel = Relatorio.getInstance();
    
////////////////////////////////////Total Superior/////////////////////////////////////////////////////////////////
    
public void TotalPostadasSuperior(){

Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
ResultSet rs = null;    

try {
stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes");
rs = stmt.executeQuery();



if(rs.next()){
rel.setTotal(rs.getString(1));

}

}catch (SQLException ex) {
Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
}finally {
ConnectionFactory.closeConnection(con, stmt, rs);
}
}


////////////////////////////////////Aguardando Superior/////////////////////////////////////////////////////////////////

public void AguardandoSuperior(){

Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
ResultSet rs = null;    

try {
stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Status_Sugestao = 'Aguardando Avaliador'");
rs = stmt.executeQuery();




if(rs.next()){
rel.setAguardando(rs.getString(1));

}

}catch (SQLException ex) {
Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
}finally {
ConnectionFactory.closeConnection(con, stmt, rs);
}
}

////////////////////////////////////Aprovadas Superior/////////////////////////////////////////////////////////////////

public void AprovadasSuperior(){

Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
ResultSet rs = null;    

try {
stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Status_Sugestao = 'Aprovada'");
rs = stmt.executeQuery();


if(rs.next()){
	rel.setAprovadas(rs.getString(1));

}

}catch (SQLException ex) {
Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
}finally {
ConnectionFactory.closeConnection(con, stmt, rs);
}
}

////////////////////////////////////Rperovadas Superior/////////////////////////////////////////////////////////////////

public void ReprovadaSuperior(){

Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
ResultSet rs = null;    

try {
stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Status_Sugestao = 'Reprovada'");
rs = stmt.executeQuery();


if(rs.next()){
	rel.setReprovadas(rs.getString(1));

}

}catch (SQLException ex) {
Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
}finally {
ConnectionFactory.closeConnection(con, stmt, rs);
}
}

////////////////////////////////////Total Avaliador/////////////////////////////////////////////////////////////////
    
    public void TotalPostadas(String categoria){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
                
        try {
              stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Categoria = ?");
              stmt.setString(1, categoria);
              rs = stmt.executeQuery();
              
      
              
              if(rs.next()){
            	  rel.setTotal(rs.getString(1));

              }
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
     }
    

////////////////////////////////////Aguardando Avaliador/////////////////////////////////////////////////////////////////
    
    public void Aguardando(String categoria){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
                
        try {
              stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Categoria = ? and Status_Sugestao = 'Aguardando Avaliador'");
              stmt.setString(1, categoria);
              rs = stmt.executeQuery();
              
         
              
              
              if(rs.next()){
            	  rel.setAguardando(rs.getString(1));

              }
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
     }
    
    ////////////////////////////////////Aprovadas Avaliador/////////////////////////////////////////////////////////////////
    
    public void Aprovadas(String categoria){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
                
        try {
              stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Categoria = ? and Status_Sugestao = 'Aprovada'");
              stmt.setString(1, categoria);
              rs = stmt.executeQuery();
              
              
              if(rs.next()){
            	  rel.setAprovadas(rs.getString(1));

              }
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
     }
    
    ////////////////////////////////////Reprovadas Avaliador/////////////////////////////////////////////////////////////////
    
    public void Reprovada(String categoria){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
                
        try {
              stmt = con.prepareStatement("SELECT COUNT(Categoria) FROM sugestoes WHERE Categoria = ? and Status_Sugestao = 'Reprovada'");
              stmt.setString(1, categoria);
              rs = stmt.executeQuery();
              
              
              if(rs.next()){
            	  rel.setReprovadas(rs.getString(1));

              }
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
     }
}
