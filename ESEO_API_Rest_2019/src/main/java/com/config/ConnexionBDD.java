package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnexionBDD {
	 
	public Connection connexion() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/maven?user=root");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
