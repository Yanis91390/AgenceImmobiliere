<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.Model.*"%>
<%@page import="com.Controlleur.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
Operation op =new Operation();
/*Note not1 =op.getNote(request.getParameter("n"));*/
/*RendezVous not1 = op.getRendezVous(request.getParameter("n"))*/


%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "Controler/ModifierRendezVous" method="post"> 
		titre <input type="text" name="pass"></br>
		contenue : <input type="text" name="email"></br>
		Date Ajout : <input type="text" name="question"></br>
		<input type="submit" value="confirmer" name="btnmodifierdv">
	</form>

</body>
</html>