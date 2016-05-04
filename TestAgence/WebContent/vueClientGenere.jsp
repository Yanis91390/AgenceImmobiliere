<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
    <%@page import="com.Controlleur.*"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   
   	Operation op = new Operation();
	BienImmobilier bien = op.getBienImmobiliers(request.getParameter("idbien"));
	Client c = op.genererListeClient(request.getParameter("idbien"));
	ArrayList<Client> clients = op.genererListeClients(request.getParameter("idbien"));
	//bien.getClients(request.getParameter("idbien"));
	//Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	//commercial.setIDCommercial(commercial.getIDCommercial());
	//commercial.setBienImmobilier(commercial.getBienImmobiliers());
	//bien.setClients(bien.getClients(request.getParameter("idbien")));
	
	String not=(String)request.getSession().getAttribute("n1");
    
   if(not==null){
       not="";
   }
  
	%>


            

	<%@include file="Header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">
				
				<p><%c.getLoyerMax();%></p>
            
            <%=not%>
            <table border="1" style="width: 100%">
                <tr> <th>IDRendezVous</th><th>Nom</th><th>Prenom</th><th colspan="2">Operation ?</th></tR>
                
                <%
               for(int i=0;i<bien.getClients(request.getParameter("idbien")).size();i++) {
             %>
            
            	<tr>
            		<td><%=bien.getClients(request.getParameter("idbien")).get(i).getIDClient()%></td>
            		<td><%=bien.getClients(request.getParameter("idbien")).get(i).getNomClient()%></td>
            		<td><%=bien.getClients(request.getParameter("idbien")).get(i).getPrenomClient()%></td>
            	</tr>
            
            <%}%>
            
            </table><br>
            
			
<div class="grid-box width100 grid-h">
		<%@include file="Footer.jsp" %>
		     </div>
     </div>
    </body>
</html>