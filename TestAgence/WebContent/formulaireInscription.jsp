<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>
            
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">

	<form action = "Controler/AjouterCommercial" method="post"> 
		Login:<input type="text" name="login"></br>
		Mot de passe :<input type="text" name="pass"></br>
		email:<input type="text" name="email"></br>
		Question:<input type="text" name="question"></br>
		Reponse:<input type="text" name="reponse"></br>
		<input type="submit" value="confirmer" name="btninscription">
	</form>
</div></div></section>
<%@include file="Footer.jsp"%>