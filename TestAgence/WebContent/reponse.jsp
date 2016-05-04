<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.Commercial" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    
    Commercial commercial=(Commercial)request.getSession().getAttribute("commercial");
   



%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
        <form action="Controler/getRep" method="post">
            <fieldset style="width: 50px"><legend>Mon Compte</legend>
                <table border="0">
                 
                    <tbody>
                        <tr>
                            <td>Question :</td>
                            <td><%=commercial.getQuesSecret()%></td>
                        </tr>
                        <tr>
                            <td>Reponse</td>
                            <td><input type="text" name="reps" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Récupérer" /><input type="reset" value="Effacer" /></td>
                        </tr>
                    </tbody>
                </table>

            
            
            
            
            
        </fieldset>
        </form>
        
        </center>
        
        
        
        
        
        
    </body>
</html>