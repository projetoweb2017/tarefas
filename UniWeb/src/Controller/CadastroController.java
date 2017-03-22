package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cadastro;
import Service.CadastroService;


@WebServlet("/CadastroS.do")
public class CadastroController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cadastro ca = new Cadastro();
        CadastroService se = new CadastroService();
        
        String pNome = request.getParameter("nome");
		String pData = request.getParameter("data");
		String pSexo = request.getParameter("sexo");
		String pEmail = request.getParameter("email");
		String pCelular = request.getParameter("celular");
		String pCurso = request.getParameter("curso");
		
		
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		
		ca.setNome_Completo(pNome);
		ca.setData_de_Nascimento(pData);
		ca.setSexo(pSexo);
		ca.setEmail(pEmail);
		ca.setTelefone_Celular(pCelular);
		ca.setCurso(pCurso);
		
		ca.setUsuario(pUsuario);
		ca.setSenha(pSenha);
		
		
		se.InserirCadastro(ca);	
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println("<h2>Cadastro feito com Sucesso!<h2/>");
	    out.println("</body></html>");



	}
}

