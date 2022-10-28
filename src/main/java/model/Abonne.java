package model;

import java.sql.Date;

public class Abonne {
	
	private int idClub;
	private String nomAbonne;
	private String prenomAbonne;
	private String dateAbonnement;

	public Abonne() {
		// TODO Auto-generated constructor stub
	}
	
	public Abonne(int idClub, String nomAbonne, String prenomAbonne, String dateAbonnement) {
		// TODO Auto-generated constructor stub
		this.idClub = idClub;
		this.nomAbonne = nomAbonne;
		this.prenomAbonne = prenomAbonne;
		this.dateAbonnement = dateAbonnement;
	}
	
	public Abonne(String nomAbonne, String prenomAbonne, String dateAbonnement) {
		// TODO Auto-generated constructor stub
		this.nomAbonne = nomAbonne;
		this.prenomAbonne = prenomAbonne;
		this.dateAbonnement = dateAbonnement;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNomAbonne() {
		return nomAbonne;
	}

	public void setNomAbonne(String nomAbonne) {
		this.nomAbonne = nomAbonne;
	}

	public String getPrenomAbonne() {
		return prenomAbonne;
	}

	public void setPrenomAbonne(String prenomAbonne) {
		this.prenomAbonne = prenomAbonne;
	}

	public String getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(String dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}
	
	
}
