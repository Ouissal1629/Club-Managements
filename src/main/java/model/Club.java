package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Club {
	
	private int idClub;
	private String nomClub;
	private String nomPresident;
	private Date dateCreation;

	public Club() {
		// TODO Auto-generated constructor stub
	}
	
	public Club(String nomClub, String nomPresident, Date dateCreation) {
		// TODO Auto-generated constructor stub
		super();
		this.nomClub = nomClub;
		this.nomPresident = nomPresident;
		this.dateCreation = dateCreation;
	}
	
	public Club(int idClub, String nomClub, String nomPresident, Date dateCreation) {
		// TODO Auto-generated constructor stub
		super();
		this.idClub = idClub;
		this.nomClub = nomClub;
		this.nomPresident = nomPresident;
		this.dateCreation = dateCreation;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}

	public String getNomPresident() {
		return nomPresident;
	}

	public void setNomPresident(String nomPresident) {
		this.nomPresident = nomPresident;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
}
