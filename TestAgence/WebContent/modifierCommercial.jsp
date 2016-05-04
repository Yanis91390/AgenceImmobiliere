<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Model.*" %>
    <%@ page import="com.Controlleur.Operation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Administrateur admin = (Administrateur)request.getSession().getAttribute("administrateur");
	Operation op = new Operation();
	Commercial commercial = op.getCommercial(request.getParameter("n"));


%>





<%@include file="Header.jsp" %>
            
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">

	<form action = "Controler/ModifierCommercial" method="post"> 
		<td><input type="hidden" name="idcom" value="<%=commercial.getIDCommercial()%>" size="30" /></td>
		Id Commercial : <input type="text" name="id" value="<%=commercial.getIDCommercial()%>" size="30"></br>
		login <input type="text" name="login" value="<%=commercial.getLogin()%>" size="30"></br>
		mot de passe  <input type="text" name="pass" value="<%=commercial.getPassword()%>" size="30"></br>
		Email : <input type="text" name="email" value="<%=commercial.getEmail()%>" size="30"></br>
		Question : <input type="text" name="quest" value="<%=commercial.getQuesSecret()%>" size="30"></br>
		Question : <input type="text" name="rep" value="<%=commercial.getRepSecret()%>" size="30"></br>
		
		<input type="submit" value="confirmer" name="btnmodifiecommercial">
	</form>
</div></div></section>
	
	
	
</div></div></section>
<%@include file="Footer.jsp"%>