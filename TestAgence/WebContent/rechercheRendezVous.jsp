<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.Model.*"%>
  <%@page import="java.util.ArrayList"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%
    Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	commercial.setIDCommercial(commercial.getIDCommercial());
	commercial.setRendezVous(commercial.getRendezVous(commercial.getLogin()));
	//commercial.setBienImmobilier(commercial.getBienImmobiliers());
	
	ArrayList<RendezVous> n =( ArrayList<RendezVous>)request.getSession().getAttribute("n");
	//commercial.setRendezVous(n);
    String err=(String)request.getSession().getAttribute("err");
    String rep=(String)request.getSession().getAttribute("rep");
    
    if(err==null)
  	{
      err="";
  	}
  
 if(n==null)
 {
     n=new ArrayList<RendezVous>();
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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controler/RechercherRendezVous" method="post">
        <div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
        
            <select name="crit">
                <option ></option>
                <option value="titre">Titre</option>
                <option value="date">Date</option>
                <option value="contenu">Contenu</option>
            </select><input type="text" name="rech" value="" size="30" /><input type="submit" value="rechercher" />
               </form>
            <div>
                <%=err%>
               
                   <table border="1" style="width: 100%">
                  <%
                     for(int i=0;i< n.size();i++){
                     %>
                  
                     <tr><td><%=n.get(i).getIdRendezVous()%></td><td><%=n.get(i).getTitre()%></td><td><%=n.get(i).getContenu()%></td><td><%=n.get(i).getDateAjout()%></td></tr>
                
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
    </body>
</html>
				
				
	   
              