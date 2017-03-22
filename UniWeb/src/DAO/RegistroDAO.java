package DAO;

import Model.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RegistroDAO {
	
	Registro re = Registro.getInstance();
    
    public RegistroDAO() {}
    
  //Update no banco de dados apartir do JTable da tela Registros do SUperior
    public boolean AlterarInformacoesDoPerfil(){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
                
        try {
        	
            stmt = con.prepareStatement("UPDATE cadastro SET Categoria = ? , Cargo = ? WHERE ID= ?");
            stmt.setString(1, re.getCategoria());
            stmt.setString(2, re.getCargo());
            stmt.setInt(3, re.getID());
            stmt.executeUpdate();

            check = true;
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return check;
     }            
}