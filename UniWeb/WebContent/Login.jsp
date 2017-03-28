<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente Cadastrado</title>
</head>
<body>
	<%Login login = Login.getInstance(); %>
	Id: <%=login.getId() %><br>
	Nome completo: <%=login.getNome_Completo() %><br>
	Data de Nascimento: <%=login.getData_de_Nascimento() %><br>
	Sexo: <%=login.getSexo() %><br>
	E-mail: <%=login.getEmail() %><br>
	Telefone Celular: <%=login.getTelefone_Celular() %><br>
	Curso: <%=login.getCurso() %><br>
</body>
</html>