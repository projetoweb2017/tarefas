package Service;

import DAO.LoginDAO;

public class LoginService {
	
	LoginDAO dao = new LoginDAO();
	
	public boolean checkLogin(String usuario, String senha){
		return dao.checkLogin(usuario, senha);
	}

}
