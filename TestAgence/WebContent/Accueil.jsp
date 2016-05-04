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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%@include file="Header.jsp" %>
               
            
	
           <div>
            <table border="1" style="width: 100%">
                <tr> <th>IDRendezVous</th><th>Titre</th><th>Contenu</th><th>DateAjout</th><th colspan="2">Operation ?</th></tR>
            <%
               for(int i=0;i<commercial.getRendezVous().size();i++){
             %>
                
                
                
                <tr> <td><%=commercial.getRendezVous().get(i).getIdRendezVous()+""%></td>
                    <td><%=commercial.getRendezVous().get(i).getTitre()%></td>
                    <td><%=commercial.getRendezVous().get(i).getContenu()%></td>
                    <td><%=commercial.getRendezVous().get(i).getDateAjout()%></td>
                    <td>
                        <form action="modifierRendezVous.jsp">
                            <input type="hidden" name="n" value="<%=commercial.getRendezVous().get(i).getIdRendezVous()%>" />
                            <input type="submit" value="Modifier" />
                        </form>
                    </td>
                        <td>
                             <form action="Controler/SupprimerRendezVous" method="post">
                			<input type="text" name="n" value="<%=commercial.getRendezVous().get(i).getIdRendezVous()+""%>" />
                            <input type="submit" value ="Supprimer" />
                        </form>      
                        </td>
                 </tr>
             
             <%} %>
            
            </table><br>
       		
			

        
        <form action ="ajouterRendezVous.jsp">
        	<input type="submit" value="Ajouter" />
        </form>
			
			
			
		
		
		
        <div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueilInfo deepest" style="min-height: 0px;">
						<div id="googleMap" style="width:800px;height:400px;"></div>
				</div>
			</div></section>
				<%@include file="Footer.jsp" %>
		     </div>
    </body>
</html>