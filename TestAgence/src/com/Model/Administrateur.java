package com.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrateur 
{
	public String nom;
	public String prenom;
	public ArrayList<Commercial> liste_commercial = new ArrayList<Commercial>();
	Commercial c1 = new Commercial("m", "password", "email", "QuesSecret", "RepSecret");
	Commercial c2 = new Commercial("m2", "password2", "email2", "QuesSecret2", "RepSecret2");
	
	public Administrateur()
	{
		this.liste_commercial = getCommercial();
		
	}
	
	public ArrayList<Commercial> getCommercial()
	{
		ArrayList<Commercial> list = new ArrayList<Commercial>();
		
		try 
        { 
            java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select Login,Password ,Email,QuestionSecret,ReponseSecret from Commercial");
             
            
            while(rs.next())
            {
                 list.add(new Commercial(rs.getString(1)+"", rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
                 System.out.println("" + list);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUUUUUUUUUUUR");
        }
		
		return list;
	}
	
	public void setCommercial(ArrayList<Commercial> liste)
	{
		this.liste_commercial = liste;
	}
	
	

}
