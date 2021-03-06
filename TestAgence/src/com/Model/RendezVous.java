package com.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RendezVous 
{
	 private int idRendezVous ;
	 private String  titre;
	 private String  contenu ;
	 private String  dateAjout ;
	 private int  IDCommercial ;
	 //
	 private String  IDBienImmobilier ;

	 public RendezVous()
	 {}
	 
	 public RendezVous(int idRendezVous, String titre, String contenu, String dateAjout,String IDBienImmobilier ) 
	 {
	        this.idRendezVous = idRendezVous;
	        this.titre = titre;
	        this.contenu = contenu;
	        this.dateAjout = dateAjout;
	        this.IDBienImmobilier = IDBienImmobilier;
	      
	    }
	 
	 public RendezVous(int idRendezVous, String titre, String contenu, String dateAjout) 
	 {
	        this.idRendezVous = idRendezVous;
	        this.titre = titre;
	        this.contenu = contenu;
	        this.dateAjout = dateAjout;  
	 }

	    public int getIdRendezVous() {
	        return idRendezVous;
	    }

	    public void setIdRendezVous(int idRendezVous) {
	        this.idRendezVous = idRendezVous;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public void setTitre(String titre) {
	        this.titre = titre;
	    }

	    public String getContenu() {
	        return contenu;
	    }

	    public void setContenu(String contenu) {
	        this.contenu = contenu;
	    }

	    public String getDateAjout() {
	        return dateAjout;
	    }

	    public void setDateAjout(String dateAjout) {
	        this.dateAjout = dateAjout;
	    }

	    public int getIDCommercial() {
	        return IDCommercial;
	    }

	    public void setIDCommercial(int IDCommercial) {
	        this.IDCommercial = IDCommercial;
	    }
	    
	    public String getIDBienImmobilier() {
	        return IDBienImmobilier;
	    }

	    public void setIDBienImmobilier(String IDBienImmobilier) {
	        this.IDBienImmobilier = IDBienImmobilier;
	    }
	    
	    
}
