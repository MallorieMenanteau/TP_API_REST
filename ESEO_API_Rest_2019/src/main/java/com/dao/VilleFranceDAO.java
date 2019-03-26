package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.config.ConnexionBDD;

public class VilleFranceDAO {
	
	private ConnexionBDD connexionbdd= new ConnexionBDD();
	
	public static final String ATT_CODE_COMMUNE = "Code_commune_INSEE";
	public static final String ATT_NOM_COMMUNE = "Nom_commune";
	public static final String ATT_CODE_POSTAL = "Code_postal";
	public static final String ATT_LIBELLE_ACHEMINEMENT = "Libelle_acheminement";
	public static final String ATT_LIGNE_5 = "Ligne_5";
	public static final String ATT_LATITUDE = "Latitude";
	public static final String ATT_LONGITUDE = "Longitude";
	
	private static final String SQL_SELECT = "SELECT * FROM ville_france ";
	
	
	public VilleFranceDAO() {
	}
	
	public Connection creerConnexion() throws SQLException {
		return this.connexionbdd.connexion();
	}
	
	

}
