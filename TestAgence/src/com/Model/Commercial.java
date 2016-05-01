package com.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commercial 
{
		private int IDCommercial;
		private String IdCommercial;
		private String Login =""  ;
		private String password="";
		private String email  =""  ;
		private String QuesSecret  ="";
		private String RepSecret  ="" ;
		private ArrayList<BienImmobilier> liste_bienImmobilier = new ArrayList<BienImmobilier>();
		private ArrayList<RendezVous> liste_rendezVous = new ArrayList<RendezVous>();
		private int nbRendezVous;
		private int nbrNote=0;

	    public Commercial() 
	    {
	    	this.liste_bienImmobilier=getBienImmobiliers();
		}
	    

	    public Commercial(String Login, String password, String email, String QuesSecret, String RepSecret) {
	        //this.IDCommercial=getIDCommercial(Login); //+"";
	        this.Login = Login;
	        this.password = password;
	        this.email = email;
	        this.QuesSecret = QuesSecret;
	        this.RepSecret = RepSecret;
	        //this.liste_rendezVous=getRendezVous(Login);
	        this.liste_bienImmobilier=getBienImmobiliers();
	        //this.n=getNote(Login);
	        //nbrNote=getNbrNote(Login);
	    }

		public Commercial(int IDCommercial,String Login, String password, String email, String QuesSecret, String RepSecret)  {
	        this.IDCommercial=IDCommercial;
	        this.Login = Login;
	        this.password = password;
	        this.email = email;
	        this.QuesSecret = QuesSecret;
	        this.RepSecret = RepSecret;
	        this.liste_rendezVous=getRendezVous(Login);
	        this.liste_bienImmobilier=getBienImmobiliers();
	        //nbrNote= getNbrNote(Login);
	    }

	    public Commercial(String IdCommercial, String Login, String password, String email, String QuesSecret, String RepSecret) 
	    {
	    	//this.IdCommercial
	    	this.Login = Login;
	        this.password = password;
	        this.email = email;
	        this.QuesSecret = QuesSecret;
	        this.RepSecret = RepSecret;
	        //this.liste_rendezVous=getRendezVous(Login);
	        this.liste_bienImmobilier=getBienImmobiliers();
	        //this.n=getNote(Login);
	        //nbrNote=getNbrNote(Login);
		}


	


		public int getIDCommercial() {
	        return IDCommercial;
	    }

	    public void setIDCommercial(int IDCommercial) {
	        this.IDCommercial = IDCommercial;
	    }

	    public String getLogin() {
	        return Login;
	    }

	    public void setLogin(String Login) {
	        this.Login = Login;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getQuesSecret() {
	        return QuesSecret;
	    }

	    public void setQuesSecret(String QuesSecret) {
	        this.QuesSecret = QuesSecret;
	    }

	    public String getRepSecret() {
	        return RepSecret;
	    }

	    public void setRepSecret(String RepSecret) 
	    {
	        this.RepSecret = RepSecret;
	    }
	    
	    public ArrayList<RendezVous> getRendezVous() {
	        return liste_rendezVous;
	    }

	    public void setRendezVous(ArrayList<RendezVous> liste) {
	        this.liste_rendezVous = liste;
	    }
	    
	    public int getIDCommercial(String login )
	    {
	        int nb=0;
	        try 
	        {
	         
	          java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select IDCommercial from Commercial where login='"+login+"'");
	           
	          if(rs.next())
	          {    
	             nb+=rs.getInt(1);   
	          }
	        }
	        catch (SQLException ex) 
	        {
	            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	        return nb;

	    }
	    
	    public ArrayList<RendezVous> getRendezVous(String login)
	    {  
	        ArrayList<RendezVous> list=new ArrayList<RendezVous> ();
	        try 
	        { 
	            java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select IDRendezVous,titre ,contenu ,dateAjout from RendezVous where IDCommercial in (select IDCommercial from Commercial where login='"+login+"')");
	             
	            
	            while(rs.next())
	            {
	                 list.add(new RendezVous(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getObject(4)+""));  
	                 //rs.getInt(1)+""
	            }
	        
	        } catch (SQLException ex) {
	            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return list;
	        
	    }
	    
	    public ArrayList<BienImmobilier> getBienImmobiliers() 
	    {
	    	ArrayList<BienImmobilier> list=new ArrayList<BienImmobilier> ();
	        try 
	        { 
	            java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select * from BienImmobilier");
	            //MyEnum enumVal =  MyEnum.valueOf(rs.getString("EnumColumn"));
	            
	            while(rs.next())
	            {
	                 list.add(new BienImmobilier(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4)
	                		 , rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9) ,rs.getInt(10)));  
	            }
	        
	        } catch (SQLException ex) {
	            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        //System.out.println("SUCCEEEEEEEEEEEEEEEEEES " + list.size());
	        return list;
	       
		}
	    
	    public void setBienImmobilier(ArrayList<BienImmobilier> list)
	    {
	    	this.liste_bienImmobilier = list;
	    }

}
