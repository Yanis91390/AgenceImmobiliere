<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.Model.*"%>
<%@page import="com.Controlleur.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
Operation op =new Operation();
/*Note not1 =op.getNote(request.getParameter("n"));*/
RendezVous rendezvous = op.getRendezVous(request.getParameter("n"));


%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "Controler/ModifierRendezVous" method="post"> 
		<td><input type="hidden" name="idrdv" value="<%=rendezvous.getIdRendezVous()%>" size="30" /></td>
		Id rdv : <input type="text" name="id" value="<%=rendezvous.getIdRendezVous()%>" size="30"></br>
		titre <input type="text" name="titre1" value="<%=rendezvous.getTitre()%>" size="30"></br>
		contenue : <input type="text" name="contenu1"></br>
		Date Ajout : <input type="text" name="dateAjout1"></br>
		<input type="submit" value="confirmer" name="btnmodifierdv">
	</form>

</body>
</html>