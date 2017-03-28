<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Cadastro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<%Cadastro cadastro = (Cadastro)request.getAttribute("cadastro"); %>
	Id: <%=cadastro.getId() %><br>
	Nome completo: <%=cadastro.getNome_Completo() %><br>
	Data de Nascimento: <%=cadastro.getData_de_Nascimento() %><br>
	Sexo: <%=cadastro.getSexo() %><br>
	E-mail: <%=cadastro.getEmail() %><br>
	Telefone Celular: <%=cadastro.getTelefone_Celular() %><br>
	Curso: <%=cadastro.getCurso() %><br>
	

<a href="index.html"><input type="button"value="Retornar"></a>
</body>
</html>