<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<%
	Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	commercial.setIDCommercial(commercial.getIDCommercial());
	commercial.setBienImmobilier(commercial.getBienImmobiliers());
   	
	String rep=(String)request.getSession().getAttribute("rep");
   
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
<title>Vue test</title>

<script type="text/javascript">
                <!--
                        function open_infos()
                        {
                                window.open('vuePrincipale.jsp','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=300, height=200');
                        }
                -->
                </script>
</head>
<body>

	<%@include file="menu.jsp" %>

	<h2>Ajouter un bien</h2>
	<div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
            <%=not%>
            <table border="1" style="width: 100%">
                <tr> <th>IDBien</th><th>Type</th><th>Disponible</th><th>statut</th><th>Etat</th><th>Prix</th><th>Loyer</th><th>Charge</th><th>Adresse</th><th>Superficie</th><th colspan="3">Operation ?</th></tr>
            <%
               for(int i=0;i<commercial.getBienImmobiliers().size();i++){
             %>
                
                
                
                <tr> 
                	  <td><%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%></td>
                      <td><%=commercial.getBienImmobiliers().get(i).getTypeBien()%></td>
                      <td><%=commercial.getBienImmobiliers().get(i).isDisponible()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getStatutBien()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getEtatBien()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getPrixAchat()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getLoyer()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getCharge()%></td> 
                      <td><%=commercial.getBienImmobiliers().get(i).getAdresse()%></td>
                      <td><%=commercial.getBienImmobiliers().get(i).getSuperficie()%></td>
                      <td>
                        <form action="modifierBienImmobilier.jsp">
                            <input type="text" name="idbien" value="<%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%>" />
                            <input type="submit" value="Modifier" />
                        </form>
                    </td>
                        <td>
                             <form action="Controler/SupprimerBien" >
                            <input type="hidden" name="n" value="" />
                            <input type="submit" value="Supprimer" />
                        </form>      
                        </td>
                        <td>
                             <form action="Controler/GenererListeClient" >
                            <input type="hidden" name="idbien" value="<%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%>" />
                            <input type="submit" value="Générer Liste Client" />
                        </form>      
                        </td>             
                 </tr>
                 
                     
            <%}%>
            
            </table>
            
            <form action ="ajouterBienImmobilier.jsp" method="post" >
            	<input type="submit" value="Ajouter" name="ajouterBienImmobilier" />
            </form>
            <form action ="Controler/SupprimerBien" method="post" >
            	<input type="submit" value="Supprimer" name="supprimerBienImmobilier" onclick="javascript:open_infos();" />
            </form>

</body>
</html>