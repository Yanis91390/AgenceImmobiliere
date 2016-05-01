package com.Model;

public class Client 
{
	private int IDClient;
	private String nomClient;
	private String prenomClient;
	
	public Client (int id,String n , String p)
	{
		this.setIDClient(id);
		this.setNomClient(n);
		this.setPrenomClient(p);
	}

	int getIDClient() {
		return IDClient;
	}

	void setIDClient(int iDClient) {
		IDClient = iDClient;
	}

	String getNomClient() {
		return nomClient;
	}

	void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	String getPrenomClient() {
		return prenomClient;
	}

	void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

}
