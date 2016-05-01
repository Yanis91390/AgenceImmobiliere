<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
    <%@page import="com.Controlleur.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   
   	Operation op = new Operation();
	BienImmobilier bien = op.getBienImmobiliers(request.getParameter("idbien"));
  
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="menu.jsp" %>
	
	<input type="text" name="idbien" value="<%=bien.getIDBienImmobilier()%>" size="30"/>
	
	<div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
            
            <table border="1" style="width: 100%">
                <tr> <th>ID Client</th><th>Nom</th><th>Client</th>
            <%
               for(int i=0;i<8;i++){
             %>
                
                
                
                <tr> 
                	  <td><%=%></td>
                      <td><%=%></td>
                      <td><%=%></td> 
                      <td><%=%></td> 
                      <td><%=%></td> 
                      <td><%=%></td> 
                      <td><%=%></td> 
                      <td><%=%></td> 
                      <td><%=%></td>
                      <td><%=%></td>
                      <td>
                        <form action="modifierBienImmobilier.jsp">
                            <input type="text" name="idbien" value="<%=%>" />
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
                             <form action="vueClientGenere.jsp" >
                            <input type="hidden" name="idbien" value="<%=%>" />
                            <input type="submit" value="Générer Liste Client" />
                        </form>      
                        </td>             
                 </tr>
                 
                     
            <%}%>
            
            </table>
            
			
       

</body>
</html>