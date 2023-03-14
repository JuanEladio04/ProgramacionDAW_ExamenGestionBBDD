package es.jepm.centroEducativo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import es.jepm.centroEducativo.properties.bbddProperties;

public class ConnectionManager {

	/**
	 * Get a connection with the data base
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = bbddProperties.getProperty("JDBC_DRIVER_CLASS");
		String user = bbddProperties.getProperty("JDBC_USER");
		String password = bbddProperties.getProperty("JDBC_PASSWORD");
		String host = bbddProperties.getProperty("JDBC_HOST");
		String schema = bbddProperties.getProperty("JDBC_SCHEMA_NAME");
		String properties = bbddProperties.getProperty("JDBC_PROPERTIES");
		
		Class.forName(driver);
		
		return (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);
	}
	
	
}
