package es.jepm.centroEducativo.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	/**
	 * Shows the name of an expecified column
	 * @param conexion
	 */
	public static String  getColumnName(Connection conection, String table, int order) {	
		try {
			Statement s = (Statement) conection.createStatement(); 

			ResultSet rs = s.executeQuery ("describe " + table);
			
		   
			for (int i = 0; i < order; i++) {
				rs.next();
			}
			
			return rs.getString (1);
		}
		catch (SQLException ex) {
		}
		
		return null;
	}
	

	/**
	 * 
	 * @param conexion
	 * @return
	 */
	public static int getTableNumber(Connection conection) {
		List<String> tables = new ArrayList<>();

		try {
			Statement s = (Statement) conection.createStatement(); 

			ResultSet rs = s.executeQuery ("show tables");
		   
			while (rs.next()) { 
				tables.add(rs.getString(1));
			}
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
		}
		return tables.size();
	}
	
	/**
	 * The the number of columns that have the table
	 * @param tabla
	 * @param conexion
	 * @return
	 * @throws SQLException
	 */
	public static int getColumnsNumber(String table, Connection conection) throws SQLException {
		Statement s = (Statement) conection.createStatement(); 

		ResultSet rs = s.executeQuery ("select * from " + table);
		
	     int numColumn=rs.getMetaData().getColumnCount();
	     
	     return numColumn;
	}
	
}
