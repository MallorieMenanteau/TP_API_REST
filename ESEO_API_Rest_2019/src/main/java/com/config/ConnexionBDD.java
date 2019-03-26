package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnexionBDD {
	 
	public Connection connexion() {
		try {
			DriverManager.registerDriver(new Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/maven?user=root");
			return connect;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
