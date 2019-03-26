package com.dto;

public class VilleFranceDTO {

	String code_commune;
	String nom;
	String code_postal;
	String libelle_acheminement;
	String ligne_5;
	String latitude;
	String longitude;
	
	public VilleFranceDTO() {
		
	}
	
	public VilleFranceDTO(String code_commune,String nom,String code_postal,String libelle_acheminement,String ligne_5,String latitude,String longitude){
		this.code_commune = code_commune;
		this.nom = nom;
		this.code_postal = code_postal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public String getCode_commune() {
		return code_commune;
	}

	public void setCode_commune(String code_commune) {
		this.code_commune = code_commune;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}

