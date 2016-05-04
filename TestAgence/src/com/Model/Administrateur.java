package com.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrateur 
{
	public String nom;
	public String prenom;
	public ArrayList<Commercial> liste_commercial ;
	//Commercial c1 = new Commercial("m", "password", "email", "QuesSecret", "RepSecret");
	//Commercial c2 = new Commercial("m2", "password2", "email2", "QuesSecret2", "RepSecret2");
	//Connection con = Connexion.getCon();
	
	public Administrateur()
	{
		//this.liste_commercial = getCommercial();	
	}
	
	public Administrateur (ArrayList<Commercial> liste)
	{
		this.liste_commercial = liste;
	}
	
	public ArrayList<Commercial> getCommercial() 
	{
		ArrayList<Commercial> list = new ArrayList<Commercial>();
		
		try 
        { 
            java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select * from Commercial");
             
            
            while(rs.next())
            {
                 list.add(new Commercial(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                 System.out.println("GETCOMMERCIAL" + rs.getString(3));
            }
        
        } catch (SQLException ex) 
		{
            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUUUUUUUUUUUR");
        }
		
		/*finally
		{
			try
			{
				if(Connexion.getCon() != null)  
				 Connexion.getCon().close();
				System.out.println("Connexion administrateur commercial");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}*/
		 System.out.println("Taille liste Commerciaux " + list.size());
			return list;
		}
		
		
	
	
	public void setCommercial(ArrayList<Commercial> liste)
	{
		this.liste_commercial = liste;
	}
	
	

}
