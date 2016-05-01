package com.Model;

import java.util.*;

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
	
	private ArrayList<Client> listeClient = new ArrayList<Client>();
	
	public BienImmobilier()
	{
		
	}
	
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
		this.listeClient = getClients();
		
	}
	private ArrayList<Client> getClients() {
		// TODO Auto-generated method stub
		return null;
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
	

}
