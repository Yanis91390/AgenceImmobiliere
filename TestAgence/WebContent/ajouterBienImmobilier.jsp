<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	//Operation op =new Operation();
	//RendezVous rendezvous = op.getRendezVous(request.getParameter("n"));


%>
<%@include file="Header.jsp" %>
            
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">

	<center><form action = "Controler/AjouterBien" method="post"> 
		TypeBien <input type="text" name="typebien" size="30"></br>
		Disponible : <input type="text" name="disponible"></br>
		Statut : <input type="text" name="statutbien"></br>
		Etat : <input type="text" name="etatbien"></br>
		Prix : <input type="text" name="prixbien"></br>
		Loyer : <input type="text" name="loyerbien"></br>
		Charge : <input type="text" name="chargebien"></br>
		Adresse : <input type="text" name="adressebien"></br>
		Superficie : <input type="text" name="superficiebien"></br>
		<input type="submit" value="confirmer" name="btnajouterbien">
	</form></center>
</div></div></section>

<%@include file="Footer.jsp" %>