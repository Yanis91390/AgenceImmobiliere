<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.Model.*"%>
<%@page import="com.Controlleur.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Operation op =new Operation();
	RendezVous rendezvous = op.getRendezVous(request.getParameter("n"));


%>

<%@include file="Header.jsp" %>
            
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">

	<form action = "Controler/AjouterRendezVous" method="post"> 
		titre <input type="text" name="titre" size="30"></br>
		contenue : <input type="text" name="contenu"></br>
		Date Ajout : <input type="text" name="dateAjout"></br>
		<input type="submit" value="confirmer" name="btnajouterrdv">
	</form>

</div></div></section>
<%@include file="Footer.jsp"%>