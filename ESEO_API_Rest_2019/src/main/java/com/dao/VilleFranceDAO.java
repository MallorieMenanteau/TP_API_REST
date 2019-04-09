package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.config.ConnexionBDD;
import com.dto.VilleFranceDTO;

public class VilleFranceDAO {
	
	private ConnexionBDD connexionbdd= new ConnexionBDD();	
	
	public VilleFranceDAO() {
		super();
	}
	
	public Connection creerConnexion() throws SQLException {
		return this.connexionbdd.connexion();
	}
	
	public List<VilleFranceDTO> getBDD() {
		List<VilleFranceDTO> liste = new ArrayList<>();
		try {
			Connection connect = this.creerConnexion();
			Statement stm = connect.createStatement();

			ResultSet rset = stm.executeQuery("SELECT * FROM ville_france");
			while(rset.next()) {
				VilleFranceDTO ville = new VilleFranceDTO();
				ville.setCodeCommune(rset.getString(1));
				ville.setNom(rset.getString(2));
				ville.setCodePostal(rset.getString(3));
				ville.setLatitude(rset.getString(6));
				ville.setLibelleAcheminement(rset.getString(4));
				ville.setLigne5(rset.getString(5));
				ville.setLongitude(rset.getString(7));
				liste.add(ville);
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	
	
	public String listeToString(List<VilleFranceDTO> liste) {
		String resultat = "";
		for(VilleFranceDTO ville : liste) {
			resultat = resultat+"["+ville.getCodeCommune()+", "+ville.getNom()+", "+ville.getCodePostal()
						+", "+ville.getLibelleAcheminement()+", "+ville.getLigne5()+", "
						+ville.getLatitude()+", "+ville.getLongitude()+"]<br>";
		}
		
		return resultat;
	}
	
	
	public List<VilleFranceDTO> getBDDparCodePostal(String codeP) {
		List<VilleFranceDTO> liste = new ArrayList<>();
		try {
			Connection connect = this.creerConnexion();
			Statement stm = connect.createStatement();
			
			ResultSet rset = stm.executeQuery("SELECT * FROM ville_france WHERE Code_postal='"+codeP+"' ORDER BY Nom_commune");
			while(rset.next()) {
				VilleFranceDTO ville = new VilleFranceDTO();
				ville.setCodeCommune(rset.getString(1));
				ville.setNom(rset.getString(2));
				ville.setCodePostal(rset.getString(3));
				ville.setLatitude(rset.getString(6));
				ville.setLibelleAcheminement(rset.getString(4));
				ville.setLigne5(rset.getString(5));
				ville.setLongitude(rset.getString(7));
				liste.add(ville);
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public void post(VilleFranceDTO ville) {
		String sql = "INSERT INTO ville_france VALUES (?,?,?,?,?,?,?)";
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(sql); 

			preparedStatement.setString(1,ville.getCodeCommune()); 
			preparedStatement.setString(2,ville.getNom()); 
			preparedStatement.setString(3,ville.getCodePostal()); 
			preparedStatement.setString(4,ville.getLibelleAcheminement()); 
			preparedStatement.setString(5,ville.getLigne5()); 
			preparedStatement.setString(6,ville.getLatitude()); 
			preparedStatement.setString(7,ville.getLongitude()); 

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void put(String param, int indiceParametreAChanger,String codeCommune) {
		
		List<String> requetes = new ArrayList<>();
		requetes.add("UPDATE ville_france SET `Nom_commune`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Code_postal`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Libelle_acheminement`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Ligne_5`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Latitude`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Longitude`=? WHERE Code_commune_INSEE = ? ");
		
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(requetes.get(indiceParametreAChanger-1)); 

			preparedStatement.setString(1,param); 
			preparedStatement.setString(2,codeCommune); 


			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}
	
	public void delete(String codeCommune) {
		String sql = "DELETE FROM ville_france WHERE Code_commune_INSEE = ?";
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(sql); 

			preparedStatement.setString(1,codeCommune); 

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
