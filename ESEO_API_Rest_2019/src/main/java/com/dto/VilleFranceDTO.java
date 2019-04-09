package com.dto;

import java.io.Serializable;

public class VilleFranceDTO  implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	String codeCommune;
	String nom;
	String codePostal;
	String libelleAcheminement;
	String ligne5;
	String latitude;
	String longitude;
	
	public VilleFranceDTO() {
		
	}
	
	public VilleFranceDTO(String codeCommune,String nom,String codePostal,String libelleAcheminement,String ligne5,String latitude,String longitude){
		this.codeCommune = codeCommune;
		this.nom = nom;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne5 = ligne5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String code_commune) {
		this.codeCommune = code_commune;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
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

