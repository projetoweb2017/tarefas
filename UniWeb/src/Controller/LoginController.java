package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Login;
import Service.LoginService;


@WebServlet("/LoginS.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean status;
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		
		LoginService lose = new LoginService();
		
		status = lose.checkLogin(pUsuario, pSenha);
		

		if(status == true){
			
			//enviar para o jsp
			RequestDispatcher view =
			request.getRequestDispatcher("Login.jsp");
			view.forward(request, response);
			}

	}
}
