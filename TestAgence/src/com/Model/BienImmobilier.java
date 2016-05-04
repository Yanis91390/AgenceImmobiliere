package com.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BienImmobilier 
{
	
	private int idBienImmobilier;
	public TypeBien typeBien ;
	boolean isDisponible;
	private StatutBien statutBien ;
	private EtatBien etatBien ;
	private double prixAchat, loyer, charge;
	private String adresse;
	private int superficie ;
	private String departementBien;
	
	private ArrayList<Client> listeClient = new ArrayList<Client>();
	
	public BienImmobilier()
	{
		
	}
	
	/*public Vector trouverBien(String departement, String prixachat, String loyer) throws SQLException{

        Vector v=new Vector();
        ResultSet rs=con.createStatement().executeQuery("select * from BienImmobilier where Departement='"+departement+"' || Loyer<='"+loyer+"' || PrixAchat<='"+prixachat+"' ");
        while(rs.next()){
        BienImmobilier b = new BienImmobilier();
        b.setIDBienImmobilier(rs.getInt(1));
        //b.setTypeBien(typeBien);(rs.getString(2));
        b.setAdresse(rs.getString(4));
        b.setPrixAchat(rs.getDouble(5));
        b.setLoyer(rs.getDouble(6));
        b.setCharge(rs.getDouble(7));
        b.setDepartementBien(rs.getString(8));
         v.addElement(b);
        }
        return v;

    }*/
	
	public BienImmobilier(int idBienImmobilier, TypeBien type,boolean disponible,StatutBien statut,
			EtatBien etat,double prix,double loyer,double charge,String adresse,int superficie )
	{
		this.idBienImmobilier = idBienImmobilier;
		//this.setTypeBien(type.APPARTEMENT);
		//this.typeBien= type;
		this.setDisponible(disponible);
		//this.setStatutBien(statut.A_VENDRE);
		this.statutBien=  statut;
		//this.setEtatBien(etat.NEUF);
		this.etatBien = etat;
		this.setPrixAchat(prix);
		this.setLoyer(loyer);
		this.setCharge(charge);
		this.setAdresse(adresse);
		this.setSuperficie(superficie);
		
	}
	
	public BienImmobilier(int idBienImmobilier, Object type,boolean disponible,Object statut,
			Object etat,double prix,double loyer,double charge,String adresse,int superficie )
	{
		this.idBienImmobilier = idBienImmobilier;
		//this.typeBien=(TypeBien) type;
		this.setDisponible(disponible);
		//this.setStatutBien(statutBien.A_VENDRE);
		//this.statutBien= (StatutBien) statut;
		///this.setEtatBien(etatBien.NEUF);
		//this.etatBien = (EtatBien) etat;
		this.setPrixAchat(prix);
		this.setLoyer(loyer);
		this.setCharge(charge);
		this.setAdresse(adresse);
		this.setSuperficie(superficie);
		//this.listeClient = getClients();
		
	}
	
	/*55555555555555555555555555555555555555555555555555*/
	public BienImmobilier(int idBienImmobilier, String type,boolean disponible,String statut,
			String etat,double prix,double loyer,double charge,String adresse,int superficie )
	{
		this.idBienImmobilier = idBienImmobilier;
		this.typeBien = TypeBien.valueOf(type);
		//this.setTypeBien(TypeBien.valueOf(type));
		this.setDisponible(disponible);
		this.statutBien = StatutBien.valueOf(statut);
		this.etatBien = EtatBien.valueOf(etat);
		this.setPrixAchat(prix);
		this.setLoyer(loyer);
		this.setCharge(charge);
		this.setAdresse(adresse);
		this.setSuperficie(superficie);
		
	}
	
	
	/*public BienImmobilier(int idBienImmobilier,boolean disponible,
			double prix,double loyer,double charge,String adresse,int superficie )
	{
		this.idBienImmobilier = idBienImmobilier;
		this.setTypeBien(getTypeBien().APPARTEMENT);
		this.setDisponible(disponible);
		this.setStatutBien(getStatutBien().A_VENDRE);
		this.setEtatBien(getEtatBien().NEUF);
		this.setPrixAchat(prix);
		this.setLoyer(loyer);
		this.setCharge(charge);
		this.setAdresse(adresse);
		this.setSuperficie(superficie);
	}*/
	
	public ArrayList<Client> getClients(String idbien) 
	{
		
		ArrayList<Client> list=new ArrayList<Client> ();
        try 
        { 
            java.sql.ResultSet rs=Connexion.getCon().createStatement().executeQuery("select * from Client c ,BienImmobilier b "
				+ "where  c.CriterePrixMin <= b.PrixBien AND c.CriterePrixMax >= b.PrixBien "
				+ "AND IDBienImmobilier="+idbien);
             
            
            while(rs.next())
            {
                 list.add(new Client (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),
     					rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9)));  
                 
            }
        
        } catch (SQLException ex) 
        {
            Logger.getLogger(Commercial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        System.out.println("Clients correspondant " + list.size());
        return list;
	}
	
	public ArrayList<Client> getClients() 
	{
		return listeClient;
	}
	
	public void setClients(ArrayList<Client> liste) 
	{
        this.listeClient = liste;
    }
	
	
	public int getIDBienImmobilier()
	{
		return this.idBienImmobilier;
	}
	
	public void setIDBienImmobilier(int id)
	{
		this.idBienImmobilier=id;
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public StatutBien getStatutBien() {
		return statutBien;
	}

	public void setStatutBien(StatutBien statutBien) {
		this.statutBien = statutBien;
	}

	public EtatBien getEtatBien() {
		return etatBien;
	}

	public void setEtatBien(EtatBien etatBien) {
		this.etatBien = etatBien;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getDepartementBien() {
		return departementBien;
	}

	public void setDepartementBien(String departementBien) {
		this.departementBien = departementBien;
	}
	

}
