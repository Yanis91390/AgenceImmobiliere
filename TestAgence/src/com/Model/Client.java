package com.Model;

public class Client 
{
	private int IDClient;
	private String nomClient;
	private String prenomClient;
	
	private double prixMin;
	private double prixMax;
	private double loyerMin;
	private double loyerMax;
	private double superficieMin;
	private double superficieMax;
	
	public Client (int id, String n , String p)
	{
		this.setIDClient(id);
		this.setNomClient(n);
		this.setPrenomClient(p);
	}
	
	public Client (int id, String n , String p,double a, double b, double c , double d, double e, double f)
	{
		this.setIDClient(id);
		this.setNomClient(n);
		this.setPrenomClient(p);
		this.setPrixMin(a);
		this.setPrixMax(b);
		this.setLoyerMin(c);
		this.setLoyerMax(d);
		this.setSuperficieMin(e);
		this.setSuperficieMax(f);
	}

	public int getIDClient() {
		return IDClient;
	}

	public void setIDClient(int iDClient) {
		IDClient = iDClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public double getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getLoyerMin() {
		return loyerMin;
	}

	public void setLoyerMin(double loyerMin) {
		this.loyerMin = loyerMin;
	}

	public double getLoyerMax() {
		return loyerMax;
	}

	public void setLoyerMax(double loyerMax) {
		this.loyerMax = loyerMax;
	}

	public double getSuperficieMin() {
		return superficieMin;
	}

	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}

	public double getSuperficieMax() {
		return superficieMax;
	}

	public void setSuperficieMax(double superficieMax) {
		this.superficieMax = superficieMax;
	}

}
