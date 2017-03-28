package DAO;


import Model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

	Login lo = Login.getInstance();
	
    public boolean checkLogin(String usuario , String senha){
        
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      boolean check = false;
              
      try {
            stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Usuario = ? and Senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            
            if(rs.next()){
            	lo.setId(rs.getInt(1));
            	lo.setNome_Completo(rs.getString(2));
            	lo.setData_de_Nascimento(rs.getString(3));
            	lo.setSexo(rs.getString(4));
            	lo.setCPF(rs.getString(5));
            	lo.setRG(rs.getString(6));
            	lo.setCEP(rs.getString(7));
            	lo.setEndereco(rs.getString(8));
            	lo.setNumero(rs.getString(9));
            	lo.setComplemento(rs.getString(10));
            	lo.setBairro(rs.getString(11));
            	lo.setCidade(rs.getString(12));
            	lo.setUF(rs.getString(13));
            	lo.setEmail(rs.getString(14));
            	lo.setTelefone_Residencial(rs.getString(15));
            	lo.setTelefone_Celular(rs.getString(16));
            	lo.setUniversidade(rs.getString(17));
            	lo.setEnderecoUniversidade(rs.getString(18));
            	lo.setCurso(rs.getString(19));
            	lo.setUsuario(rs.getString(20));
            	lo.setSenha(rs.getString(21));
            	lo.setPerguntaSecreta(rs.getString(22));
            	lo.setCargo(rs.getString(23));
            	lo.setCategoria(rs.getString(24));
            	
            check = true;

            }
            
       }catch (SQLException ex) {
        Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
          ConnectionFactory.closeConnection(con, stmt, rs);
      }
      return check;
   }
    
    public boolean AlterarInformacoesColaborador(int ID){
    	
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        boolean check = false;
                
        try {
              stmt = con.prepareStatement("UPDATE cadastro SET Nome_Completo = ? , Data_de_Nascimento = ? , Email = ? , Telefone_Residencial = ? , Telefone_Celular = ? , Usuario= ? , Senha = ? , Curso = ? WHERE ID= ?");
              stmt.setString(1, lo.getNome_Completo());
              stmt.setString(2, lo.getData_de_Nascimento());
              stmt.setString(3, lo.getEmail());
              stmt.setString(4, lo.getTelefone_Residencial());
              stmt.setString(5, lo.getTelefone_Celular());
              stmt.setString(6, lo.getUsuario());
              stmt.setString(7, lo.getSenha());
              stmt.setString(8, lo.getCurso());
              stmt.setInt(9, lo.getID());
              stmt.executeUpdate();
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return check;
     }
    
    public boolean AlterarInformacoesAvaliador(int ID){
    	
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        boolean check = false;
                
        try {
              stmt = con.prepareStatement("UPDATE cadastro SET Nome_Completo = ? , Data_de_Nascimento = ? , Email = ? , Telefone_Residencial = ? , Telefone_Celular = ? , Usuario= ? , Senha = ? WHERE ID= ?");
              stmt.setString(1, lo.getNome_Completo());
              stmt.setString(2, lo.getData_de_Nascimento());
              stmt.setString(3, lo.getEmail());
              stmt.setString(4, lo.getTelefone_Residencial());
              stmt.setString(5, lo.getTelefone_Celular());
              stmt.setString(6, lo.getUsuario());
              stmt.setString(7, lo.getSenha());
              stmt.setInt(9, lo.getID());
              stmt.executeUpdate();
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return check;
     }
    
}
