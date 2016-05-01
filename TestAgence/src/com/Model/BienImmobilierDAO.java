package com.Model;

import java.util.List;
import javax.sql.DataSource;

public interface BienImmobilierDAO 
{	
	public void setDataSource(DataSource ds);
	   
		/*Méthode Ajout d'un Bien Immobilier*/
	   public void addBI(BienImmobilier bien) ;
	   
	   /*Méthode Modification d'un Bien Immobilier*/
	   public void deleteBI(Integer id);
	  
	   /*Méthode Suppresssion d'un Bien Immobilier*/
	   public void updateBI(Integer id);

}
