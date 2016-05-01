package com.Controlleur;


import com.Model.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Operation implements BienImmobilierDAO
{
    
	Connection con = Connexion.getCon();
    
    private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/*Verifie si un Commercial existe dans la base de donnée*/
	public boolean  isExiste(Commercial commercial) throws SQLException
    {   
		ResultSet rs=con.createStatement().executeQuery("select *from Commercial where login='"+commercial.getLogin()+"' and password='"+commercial.getPassword()+"'");      
        return rs.next();
    }
     
	/*Verifie si un Login existe*/
     public boolean loginExiste(String login ) throws SQLException
     {
        ResultSet rs =con.createStatement().executeQuery("select *from Commercial where login='"+login+"'");
        return rs.next();
     }
     
     /*Verifie si un email existe*/
     public boolean emailExiste(String email ) throws SQLException
     {
        ResultSet rs =con.createStatement().executeQuery("select *from Commercial where email='"+email+"'");
        return rs.next();
     }
    
     
             
     /*Recupère la question secrete*/
     public String getQuestion(String login , String email) throws SQLException
     { 
    	 String q="";
    	 ResultSet rs=con.createStatement().executeQuery("select QUESTIONSECRET from Commercial where login='"+login+"' and email='"+email+"'" );
      
    	 if(rs.next())
    	 {
    		 q+=rs.getString(1);
    	 }
       
    	 return q;
       
     }
   
     /*Verifie la réponse*/
     public String verifierep(Commercial us) throws SQLException 
     {
          String pass="";
          String req="select password from Commercial where login ='"+us.getLogin()+"' and email='"+us.getEmail()+"' and REPONSESECRET='"+us.getRepSecret()+"'";
          ResultSet rs=con.createStatement().executeQuery(req);
          
          if(rs.next())
          {
              pass+=rs.getString(1);
          }
          
          return pass;
          
      }
     
     /*----------------------------METHODE D'AJOUT-------------------------------------*/
     
     /*Ajoute un BienImmobilier dans la base de données*/
     public void addBienImmobilier(BienImmobilier bien) throws SQLException
     {
    	 PreparedStatement psm = con.prepareStatement("insert into BienImmobilier(TypeBien,DisponibleBien,StatutBien,EtatBien,PrixBien,LoyerBien,ChargeBien,AdresseBien,SuperficieBien) values(?,?,?,?,?,?,?,?,?)");
    	 psm.setString(1, bien.getTypeBien()+"");
    	 psm.setBoolean(2, bien.isDisponible());
    	 psm.setString(3, bien.getStatutBien().toString());
    	 psm.setString(4, bien.getEtatBien().toString());
    	 psm.setDouble(5, bien.getPrixAchat());
    	 psm.setDouble(6, bien.getLoyer());
    	 psm.setDouble(7, bien.getCharge());
    	 psm.setString(8, bien.getAdresse());
    	 psm.setInt(9, bien.getSuperficie());

    	 psm.executeUpdate();
     }
     
     /*Ajoute un commercial à la Base de données*/
     public void addCommercial(Commercial commercial) throws SQLException
     {
         PreparedStatement psm=con.prepareStatement("insert into Commercial(IDCommercial,Login,Password,Email,QuestionSecret,ReponseSecret) values (?,?,?,?,?,?) ");
         psm.setInt(1, commercial.getIDCommercial());
         psm.setString(2, commercial.getLogin());
         psm.setString(3, commercial.getPassword());
         psm.setString(4, commercial.getEmail());
         psm.setString(5, commercial.getQuesSecret());
         psm.setString(6, commercial.getRepSecret());         
         
         psm.executeUpdate();
         
     }
     
     public void addRendezVous(RendezVous rdv) throws SQLException
     {
    	 PreparedStatement psm=con.prepareStatement("insert into RendezVous (titre,contenu,dateAjout,IDCommercial) values (?,?,?,?)");
    	 psm.setString(1, rdv.getTitre());
    	 psm.setString(2, rdv.getContenu());
    	 psm.setString(3, rdv.getDateAjout());
    	 psm.setInt(4, rdv.getIDCommercial());
    	 
    	 psm.executeUpdate();
     }
     
     /*----------------------------METHODE DE SUPRESSION-------------------------------------*/
     
     /*Supprimer un BienImmobilier de la Base de données*/
     public void deleteBienImmobilier(BienImmobilier bien) throws SQLException
     {
    	 PreparedStatement psm = con.prepareStatement("Delete from BienImmobilier where IDBienImmobilier=?");
    	 psm.setInt(1, bien.getIDBienImmobilier());
    	 psm.executeUpdate();
    	 
     }
     
     /*Supprimer un Commercial de la Base de données*/
     public void deleteCommercial(Commercial commercial) throws SQLException
     {
    	 PreparedStatement psm = con.prepareStatement("Delete from Commercial where IDCommercial=?");
    	 psm.setInt(1, commercial.getIDCommercial()); //Peut être va t il falloir changer l'attribut IDCommercial en String
    	 psm.executeUpdate();
     }
     
     public void deleteRendezVous(RendezVous rdv) throws SQLException
     {
    	 PreparedStatement psm = con.prepareStatement("Delete from RendezVous where IDRendezVous=?");
    	 psm.setInt(1, rdv.getIdRendezVous());
    	 psm.executeUpdate();
     }
     
     /*----------------------------METHODE DE MODIFICATION-------------------------------------*/
     
     public void modifierRendezVous(RendezVous rdv) throws SQLException
     {
         PreparedStatement psm=con.prepareStatement("update RendezVous set titre=?,contenu=?,dateAjout=? where IDRendezVous=?");
         psm.setString(1, rdv.getTitre());
         psm.setString(2, rdv.getContenu());
         psm.setString(3, rdv.getDateAjout());
         psm.setInt(4, rdv.getIdRendezVous());
     
         psm.executeUpdate();
         
         System.out.println("Méthode appliqué modifier Rendez Vous");
     } 
     
     public void modifierBienImmobilier(BienImmobilier bien) throws SQLException
     {
    	 PreparedStatement psm=con.prepareStatement("update BienImmobilier set TypeBien=?,DisponibleBien=?,StatutBien=?,EtatBien=?,PrixBien=?,LoyerBien=?,ChargeBien=?,AdresseBien=?,SuperficieBien=? where IDBienImmobilier=?");
    	 psm.setString(1, bien.getTypeBien().toString());
    	 psm.setBoolean(2, bien.isDisponible());
    	 psm.setString(3, bien.getStatutBien().toString());
    	 psm.setString(4, bien.getEtatBien().toString());
    	 psm.setDouble(5, bien.getPrixAchat());
    	 psm.setDouble(6, bien.getLoyer());
    	 psm.setDouble(7, bien.getCharge());
    	 psm.setString(8, bien.getAdresse());
    	 psm.setInt(9, bien.getSuperficie());
    	 psm.setInt(10, bien.getIDBienImmobilier());
     
         psm.executeUpdate();
         
         System.out.println("Méthode appliqué modifier BienImmo" + bien.getIDBienImmobilier());
     }
     
     public RendezVous getRendezVous(String id)throws SQLException
     {
         RendezVous n=null;
         ResultSet rs=con.createStatement().executeQuery("select IDRendezVous,titre,contenu,DATEAJOUT from RendezVous where IDRendezVous="+id );
         
         if(rs.next())
         {
        	 n=new RendezVous(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getObject(4)+"");
        	 //rs.getInt(1)+""
         }
         
      return n;
      
     } 
     
     public BienImmobilier getBienImmobiliers(String id)throws SQLException
     {
         BienImmobilier n=null;
         ResultSet rs=con.createStatement().executeQuery("select * from BienImmobilier where IDBienImmobilier="+id );
         
         if(rs.next())
         {
        	 n=new BienImmobilier(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4)
            		 , rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9) ,rs.getInt(10)); 
         }
         
      return n;
      
     }

	public void genererListeClient() throws SQLException
	{
		
		
	}

	
	public void addBII(TypeBien t, boolean d, StatutBien s, EtatBien e, double p, double l, double c, String a,
			int sup) {
		
		String SQL = "insert into BienImmobilier(TypeBien,DisponibleBien,StatutBien,EtatBien,PrixBien,LoyerBien,ChargeBien,AdresseBien,SuperficieBien) values(?,?,?,?,?,?,?,?,?)";

		//jdbcTemplateObject.update(SQL, name, age);
		jdbcTemplateObject.update(SQL , t,d,s,e,p,l,c,a,sup);
		
	}

	@Override
	public void deleteBI(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBI(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	/*Classe Operation, utilisation de l'objet jdbcTemplateObject de Spring*/
	public void addBI(BienImmobilier b) 
	{
		String SQL = "insert into BienImmobilier(TypeBien,DisponibleBien,StatutBien,EtatBien,PrixBien,LoyerBien,"
				+ "ChargeBien,AdresseBien,SuperficieBien) values(?,?,?,?,?,?,?,?,?)";

		jdbcTemplateObject.update(SQL , b.getTypeBien().toString(),
				b.isDisponible(),b.getStatutBien().toString(),
				b.getEtatBien().toString(),b.getPrixAchat(),b.getLoyer(),b.getCharge(),
				b.getAdresse(),b.getSuperficie());
		
	}

	
       
       
   }
      
