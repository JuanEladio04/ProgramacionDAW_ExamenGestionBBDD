package es.jepm.centroEducativo.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class List {
	
	/**
	 * 
	 * @param connection
	 * @param table
	 * @param order
	 * @param row
	 * @return
	 */
	public static String showTables(Connection connection, String table, int order, int row) {	
		try {
			Statement s = (Statement) connection.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from " + table + " order by 'id'");
					     
		     for (int i = 0; i < row; i++) {
		    	 rs.next();
			}
		     
		     return rs.getString(order);
		     
		}
		catch (SQLException ex) {
		}
		return null;
		
	}
	

}
