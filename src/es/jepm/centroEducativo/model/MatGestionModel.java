package es.jepm.centroEducativo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import es.jepm.centroEducativo.controllers.Controller;

public class MatGestionModel {
	

	
	/**
	 * 
	 * @param conection
	 * @param table
	 * @return
	 */
	public static ArrayList<String> getRegisterList(Connection conection, String table, String id, String rowName) {	
		ArrayList<String> registerList = new ArrayList<String>();

		try {
			Statement s = (Statement) conection.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from " + table + " where " + rowName + " like '" + id + "'");
		   
			while (rs.next()) { 
				 registerList.add(rs.getString(2));
			}
			
			return registerList;
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			return null;
		}
		
	}
		
		/**
		 * 
		 * @param conection
		 * @param table
		 * @return
		 */
		public static ArrayList<String> getFirstRegisterList(Connection conection, String table) {	
			ArrayList<String> registerList = new ArrayList<String>();

			try {
				Statement s = (Statement) conection.createStatement(); 

				ResultSet rs = s.executeQuery ("select * from " + table);
			   
				while (rs.next()) { 
					 registerList.add(rs.getString(2));
				}
				
				return registerList;
			}
			catch (SQLException ex) {
				System.out.println("Error en la ejecución SQL: " + ex.getMessage());
				return null;
			}
}
		
		/**
		 * 
		 * @param conection
		 * @param table
		 * @return
		 */
		public static String getTableId(Connection conection, String table, String resultName, String name) {	
			ArrayList<String> registerList = new ArrayList<String>();

			try {
				Statement s = (Statement) conection.createStatement(); 

				ResultSet rs = s.executeQuery ("select * from " + table + " where " + name + " = '" + resultName + "'");
			   
				rs.next();
				
				return rs.getString(1);
				
			}
			catch (SQLException ex) {
				System.out.println("Error en la ejecución SQL: " + ex.getMessage());
				return null;
			}
}
		
		
	
}
