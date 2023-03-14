package es.jepm.centroEducativo;

import java.sql.Connection;
import java.sql.SQLException;

import es.jepm.centroEducativo.controllers.ConnectionManager;
import es.jepm.centroEducativo.view.Window;


public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		
		connection = ConnectionManager.getConnection(); //Creating the conection to data base

		Window.main(args, connection);

	}

}
