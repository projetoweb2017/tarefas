package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			Login lo = Login.getInstance();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
			out.println("id: " + lo.getID() + "<br>");
			out.println("Nome completo: " + lo.getNome_Completo() + "<br>");
			out.println("Data de nascimento: " + lo.getData_de_Nascimento() + "<br>");
			out.println("Sexo: " + lo.getSexo() + "<br>");
			out.println("CPF: " + lo.getCPF() + "<br>");
			out.println("RG: " + lo.getRG() + "<br>");
			out.println("CEP: " + lo.getCEP() + "<br>");
			out.println("Endereço: " + lo.getEndereco() + "<br>");
			out.println("Numero: " + lo.getNumero() + "<br>");
			out.println("Complemento: " + lo.getComplemento() + "<br>");
			out.println("Bairro: " + lo.getBairro() + "<br>");
			out.println("Cidade: " + lo.getCidade() + "<br>");
			out.println("UF: " + lo.getUF() + "<br>");
			out.println("Email: " + lo.getEmail() + "<br>");
			out.println("Residencial: " + lo.getTelefone_Residencial() + "<br>");
			out.println("Celular: " + lo.getTelefone_Celular() + "<br>");
			out.println("Universidade: " + lo.getUniversidade() + "<br>");
			out.println("Endereco Universidade: " + lo.getEnderecoUniversidade() + "<br>");
			out.println("Curso: " + lo.getCurso() + "<br>");
			out.println("</body></html>");
		}else{
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cadastro não localizado</title></head><body>");
			out.println("<h3>Cadastro não localizado<h3/>");
			out.println("</body></html>");
		}
		


	}
}
