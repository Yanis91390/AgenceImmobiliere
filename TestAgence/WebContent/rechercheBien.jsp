<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
  <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	commercial.setIDCommercial(commercial.getIDCommercial());
	commercial.setRendezVous(commercial.getRendezVous(commercial.getLogin()));
	//commercial.setBienImmobilier(commercial.getBienImmobiliers());
	
	ArrayList<BienImmobilier> n =( ArrayList<BienImmobilier>)request.getSession().getAttribute("n");
	//commercial.setRendezVous(n);
    String err=(String)request.getSession().getAttribute("err");
    String rep=(String)request.getSession().getAttribute("rep");
    
    if(err==null)
  	{
      err="";
  	}
  
 if(n==null)
 {
     n=new ArrayList<BienImmobilier>();
 }
   	
	
   
	if(commercial==null){
       
      response.sendRedirect("Connexion.jsp");
   }
   
	String not=(String)request.getSession().getAttribute("n1");
    
   if(not==null){
       not="";
   }
  
  

%>

<%@include file="Header.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="Controler/RechercherBien" method="post">
        <div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
        
            <select name="crit">
            	<option></option>
                <option value="id">ID</option>
                <option value="disponible">Disponible</option>
                <option value="statut">Statut</option>
                <option value="etat"> Etat</option>
                <option value="prixmax">Prix max</option>
            </select><input type="text" name="rech" value="" size="30" /><input type="submit" value="rechercher" />
               </form>
            <div>
                <%=err%>
               
                   <table border="1" style="width: 100%">
                   <tr> <th>IDBien</th><th>Type</th><th>Disponible</th><th>statut</th><th>Etat</th><th>Prix</th><th>Loyer</th><th>Charge</th><th>Adresse</th><th>Superficie</th><th colspan="3">Operation ?</th></tr>
                  <%
                     for(int i=0;i< n.size();i++){
                     %>
                  
                     <tr>
                     	<td><%=n.get(i).getIDBienImmobilier()%></td>
                     	<td><%=n.get(i).getTypeBien()%></td>
                     	<td><%=n.get(i).isDisponible()%></td>
                     	<td><%=n.get(i).getStatutBien()%></td>
                     	<td><%=n.get(i).getEtatBien()%></td>
                     	<td><%=n.get(i).getPrixAchat()%></td>
                     	<td><%=n.get(i).getLoyer()%></td>
                     	<td><%=n.get(i).getCharge()%></td>
                     	<td><%=n.get(i).getAdresse()%></td>
                     	<td><%=n.get(i).getSuperficie()%></td>
                     </tr>
                
                       <%
                     }
                     
                     %>
                       
                              </table>
                         <br>
                         <br>
                         <br>
                         <br>
                         <br>
                         <br>
                
               
            </div>                 

     </div>
 
		
		<div class="grid-box width100 grid-h">
		<%@include file="Footer.jsp" %>
		     </div>
		     </div>
    </body>
</html>