<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
  	Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	commercial.setIDCommercial(commercial.getIDCommercial());//(commercial.getLogin())+"");
	//commercial.setRendezVous(commercial.getRendezVous(commercial.getLogin()));
	//commercial.setBienImmobilier(commercial.getBienImmobiliers());
	
	Administrateur admin = (Administrateur)request.getSession().getAttribute("administrateur");
	//administrateur.setCommercial(administrateur.getCommercial());
	
   	
	String rep=(String)request.getSession().getAttribute("rep");
   
	//if(commercial==null){
       
      //response.sendRedirect("Connexion.jsp");
   //}
   
	String not=(String)request.getSession().getAttribute("n1");
    
   if(not==null){
       not="";
   }
  

%>

	<table border="1" style="width: 100%">
                <tr> <th>IDCommercial</th><th>Login</th><th>password</th><th>Email</th><th colspan="2">Operation ?</th></tR>
            <%
            	for(int i=0;i<admin.getCommercial().size();i++){
             %>
                
                
                
                <tr>
             		<td><%=admin.getCommercial().get(i).getIDCommercial() %></td>
             		<td><%=admin.getCommercial().get(i).getLogin() %></td>
             		<td><%=admin.getCommercial().get(i).getEmail() %></td>
             		<td><%=admin.getCommercial().get(i).getEmail() %></td>
                    <td>
                        <form action="modifierCommercial.jsp">
                            <input type="hidden" name="n" value="" />
                            <input type="submit" value="Modifier" />
                        </form>
                    </td>
                        <td>
                             <form action="Controler/del" >
                            <input type="hidden" name="n" value="" />
                            <input type="submit" value="Supprimer" />
                        </form>      
                        </td>
                 </tr>
             
            
            
            
            <%}%>
            
            
            </table>
            
            
                        <form action="formulaireInscription.jsp">
                            <input type="hidden" name="n" value="" />
                            <input type="submit" value="Ajouter" />
                        </form>