<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Controlleur.*" %>
<%@ page import="com.Model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Operation op = new Operation();
	BienImmobilier bien = op.getBienImmobiliers(request.getParameter("idbien"));




%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@include file="menu.jsp" %>

	<form action = "Controler/ModifierBien" method="post"> 
		<td><input type="hidden" name="idbien" value="<%=bien.getIDBienImmobilier()%>" size="30" /></td>
		Id Bien : <input type="text" name="id" value="<%=bien.getIDBienImmobilier()%>" size="30"></br>
		TypeBien <input type="text" name="type" value="<%=bien.getTypeBien()+""%>" size="30"></br>
		Disponible : <input type="text" name="disponible" value="<%=bien.isDisponible()+""%>" size="30"></br>
		Statut : <input type="text" name="statut" value="<%=bien.getStatutBien()+""%>"></br>
		Etat : <input type="text" name="etat" value="<%=bien.getEtatBien()+""%>"></br>
		Prix : <input type="text" name="prix" value="<%=bien.getPrixAchat()+""%>"></br>
		Loyer : <input type="text" name="loyer" value="<%=bien.getLoyer()+""%>"></br>
		Charge : <input type="text" name="charge" value="<%=bien.getCharge()+""%>"></br>
		Adresse : <input type="text" name="adresse" value="<%=bien.getAdresse()+""%>"></br>
		Superficie : <input type="text" name="superficie" value="<%=bien.getSuperficie()+""%>"></br>
		<input type="submit" value="confirmer" name="btnmodifiebien">
	</form>
</body>
</html>