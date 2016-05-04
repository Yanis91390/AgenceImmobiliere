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
<%@include file="Header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<script type="text/javascript">
                <!--
                        function open_infos()
                        {
                                window.open('vuePrincipale.jsp','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=300, height=200');
                        }
                -->
                </script>
            
	<section id="top-b" class="grid-block">
			<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueil deepest" style="min-height: 0px;">
            <%=not%>
            <table border="1">
                <tr> <th>IDBien</th><th>Type</th><th>Disponible</th><th>statut</th><th>Etat</th><th>Prix</th><th>Loyer</th><th>Charge</th><th>Adresse</th><th>Superficie</th><th colspan="3">Operation ?</th></tr>
            <%
               for(int i=0;i<commercial.getBienImmobiliers().size();i++){
             %>
                
                
                
                <tr> 
                	  <td type ="hidden"><%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%></td>
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
                        <form action="modifierBienImmobilier.jsp" method ="post">
                            <input type="text" name="idbien" value="<%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%>" />
                            <input type="submit" value="Modifier" />
                        </form>
                    </td>
                        <td>
                             <form action="Controler/SupprimerBien" method ="post" >
                            <input type="hidden" name="n" value="<%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%>" />
                            <input type="submit" value="Supprimer" />
                        </form>      
                        </td>
                        <td>
                             <form action="vueClientGenere.jsp" method ="post">
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
            <!-- <form action ="Controler/SupprimerBien" method="post" >
            	<input type="submit" value="Supprimer" name="supprimerBienImmobilier" onclick="javascript:open_infos();" />
            </form> -->

</div></div></section>
<div class="grid-box width100 grid-h">
		<%@include file="Footer.jsp" %>
		     </div>
     </div>
    </body>
</html>