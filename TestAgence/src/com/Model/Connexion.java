package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    public static Connection getCon(){
        
          Connection con =null;
          int nbCon = 0;
        try {
          
            nbCon ++;
            System.out.println("Nombre Connexion : " + nbCon+" ");
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","010375");
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          return con;
    }
    
    
    
    
}
