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
				ville.setCode_commune(rset.getString(1));
				ville.setNom(rset.getString(2));
				ville.setCode_postal(rset.getString(3));
				ville.setLatitude(rset.getString(6));
				ville.setLibelle_acheminement(rset.getString(4));
				ville.setLigne_5(rset.getString(5));
				ville.setLongitude(rset.getString(7));
				liste.add(ville);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	
	
	public String listeToString(List<VilleFranceDTO> liste) {
		String resultat = "";
		for(VilleFranceDTO ville : liste) {
			resultat = resultat+"["+ville.getCode_commune()+", "+ville.getNom()+", "+ville.getCode_postal()
						+", "+ville.getLibelle_acheminement()+", "+ville.getLigne_5()+", "
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
				ville.setCode_commune(rset.getString(1));
				ville.setNom(rset.getString(2));
				ville.setCode_postal(rset.getString(3));
				ville.setLatitude(rset.getString(6));
				ville.setLibelle_acheminement(rset.getString(4));
				ville.setLigne_5(rset.getString(5));
				ville.setLongitude(rset.getString(7));
				liste.add(ville);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	public void post(VilleFranceDTO ville) {
		String sql = "INSERT INTO ville_france VALUES (?,?,?,?,?,?,?)";
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(sql); 

			preparedStatement.setString(1,ville.getCode_commune()); 
			preparedStatement.setString(2,ville.getNom()); 
			preparedStatement.setString(3,ville.getCode_postal()); 
			preparedStatement.setString(4,ville.getLibelle_acheminement()); 
			preparedStatement.setString(5,ville.getLigne_5()); 
			preparedStatement.setString(6,ville.getLatitude()); 
			preparedStatement.setString(7,ville.getLongitude()); 

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void put(String param, int indiceParametreAChanger,String code_commune) {
		
		List<String> requetes = new ArrayList<>();
		requetes.add("UPDATE ville_france SET `Nom_commune`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Code_postal`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Libelle_acheminement`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Ligne_5`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Latitude`=? WHERE Code_commune_INSEE = ? ");
		requetes.add("UPDATE ville_france SET `Longitude`=? WHERE Code_commune_INSEE = ? ");
		
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(requetes.get(indiceParametreAChanger-2)); 

			preparedStatement.setString(1,param); 
			preparedStatement.setString(2,code_commune); 


			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	public void delete(String code_commune) {
		String sql = "DELETE FROM ville_france WHERE Code_commune_INSEE = ?";
		try {
			Connection connect = this.creerConnexion();
			PreparedStatement preparedStatement = connect.prepareStatement(sql); 

			preparedStatement.setString(1,code_commune); 

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
