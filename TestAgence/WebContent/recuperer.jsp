<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form action="Controler/getCompte" method="post">
            <fieldset style="width: 50px"><legend>Mon Compte</legend>
                <table border="0">
                 
                    <tbody>
                        <tr>
                            <td>Login :</td>
                            <td><input type="text" name="log" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="text" name="mail" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="GetQuestion" /><input type="reset" value="Effacer" /></td>
                        </tr>
                    </tbody>
                </table>

            
            
            
            
            
        </fieldset>
        </form>
        
        </center>
        
    </body>
</html>