package es.jepm.centroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.jepm.centroEducativo.controllers.Controller;
import es.jepm.centroEducativo.controllers.List;
import es.jepm.centroEducativo.model.MatGestionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Connection connection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window(connection);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Window(Connection connection) throws SQLException {
		
        JTextField[] allField = new JTextField [Controller.getColumnsNumber("materia", connection) + 1];
        allField[0] = null;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 171, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestión de Materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		//Gestion Panel
		
		JPanel matGestionPanel = new JPanel();
		GridBagConstraints gbc_matGestionPanel = new GridBagConstraints();
		gbc_matGestionPanel.insets = new Insets(0, 0, 5, 0);
		gbc_matGestionPanel.fill = GridBagConstraints.BOTH;
		gbc_matGestionPanel.gridx = 0;
		gbc_matGestionPanel.gridy = 1;
		contentPane.add(matGestionPanel, gbc_matGestionPanel);
		GridBagLayout gbl_matGestionPanel = new GridBagLayout();
		gbl_matGestionPanel.columnWidths = new int[]{115, 171, 128, 0};
		gbl_matGestionPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_matGestionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_matGestionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		matGestionPanel.setLayout(gbl_matGestionPanel);
		
		JComboBox comboBox_center = createJCombo(matGestionPanel, connection, "Centro", 0);
		JComboBox comboBox_Nivel = createJCombo(matGestionPanel, connection, "Nivel", 1);
		JComboBox comboBox_Materia = createJCombo(matGestionPanel, connection, "Materia", 2);
		
		//Action Buttons
		JButton btnNewButton = new JButton("Cargar niveles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewValuesToComboBox(comboBox_Nivel, connection, "idCentro", MatGestionModel.getTableId(connection, "centroeducativo", comboBox_center.getSelectedItem().toString(), "descripcion"), "Nivel");
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		matGestionPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cargar materias");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewValuesToComboBox(comboBox_Materia, connection, "idNivel", MatGestionModel.getTableId(connection, "Nivel", comboBox_Nivel.getSelectedItem().toString(), "descripcion"), "Materia");
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		matGestionPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver materia");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 2;
		matGestionPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		
		//Data panel
		JPanel matDataPanel = new JPanel();
		GridBagConstraints gbc_matDataPanel = new GridBagConstraints();
		gbc_matDataPanel.fill = GridBagConstraints.BOTH;
		gbc_matDataPanel.gridx = 0;
		gbc_matDataPanel.gridy = 2;
		contentPane.add(matDataPanel, gbc_matDataPanel);
		GridBagLayout gbl_matDataPanel = new GridBagLayout();
		gbl_matDataPanel.columnWidths = new int[]{158, 213, 0};
		gbl_matDataPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_matDataPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_matDataPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		matDataPanel.setLayout(gbl_matDataPanel);
		
		for (int i = 1; i <= Controller.getColumnsNumber("materia", connection); i++) {
			createLabel(Controller.getColumnName(connection, "materia", i), i);
			createDataField(Controller.getColumnsNumber("materia", connection), i, connection, "materia", allField, Controller.getColumnName(connection, "materia", i));
		}
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.EAST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 7;
		matDataPanel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblNewLabel_7 = new JLabel("Admite matricula");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 7;
		matDataPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Guardar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 8;
		matDataPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		

	}
	
	/**
	 * 
	 * @param comboBox
	 * @param connection
	 * @param columnName
	 */
	public void addValuesToComboBox(JComboBox<String> comboBox, Connection connection, String name) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		ArrayList<String> registerList;		
		String table = "centroeducativo";
		
		if(name.contains("Centro") == true) table = "centroeducativo";
		else if(name.contains("Nivel") == true) table = "nivel";
		else if(name.contains("Materia") == true) table = "materia";
		
		if(table == "centroeducativo") {
			registerList = MatGestionModel.getFirstRegisterList(connection, table);
	        for (String register : registerList) {
	            model.addElement(register);
	        }
	        comboBox.setModel(model);
	    }
	}
		
		/**
		 * 
		 * @param comboBox
		 * @param connection
		 * @param columnName
		 */
		public void addNewValuesToComboBox(JComboBox<String> comboBox, Connection connection, String columnName, String id, String name) {
	        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
			ArrayList<String> registerList;		
			String table = null;
			
			if(name.contains("Centro") == true) table = "centroeducativo";
			else if(name.contains("Nivel") == true) table = "nivel";
			else if(name.contains("Materia") == true) table = "materia";
			
				registerList = MatGestionModel.getRegisterList(connection, table, id, columnName);
		        for (String register : registerList) {
		            model.addElement(register);
		        }

        comboBox.setModel(model);
		
	}
	
	/**
	 * 
	 * @param matGestionPanel
	 * @param connection
	 * @param name
	 * @param order
	 * @return
	 */
	public JComboBox<String> createJCombo(JPanel matGestionPanel, Connection connection, String name, int order) {
		JLabel lblNewLabel_1 = new JLabel(name + ": ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = order;
		matGestionPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = order;
		matGestionPanel.add(comboBox, gbc_comboBox);
		addValuesToComboBox(comboBox, connection, name);
		
		return comboBox;
	}
	
	private void createDataField(int nColumn, int order, Connection connection, String table, JComponent[] allField, String columnName) {
			allField[order] = new JTextField();
			GridBagConstraints gbc_allField = new GridBagConstraints();
			JTextField textField = (JTextField) allField[order];
			
			gbc_allField.insets = new Insets(10, 0, 10, 20);
			gbc_allField.gridwidth = 3;
			gbc_allField.fill = GridBagConstraints.HORIZONTAL;
			gbc_allField.gridx = 1;
			gbc_allField.gridy = order + 1;
			gbc_allField.weighty = 0.9;
			textField.setEditable(false);
			textField.setText(List.showTables(connection, table, order, 1));
			getContentPane().add(allField[order], gbc_allField);
			textField.setColumns(nColumn + 3);
			getContentPane().add(allField[order], gbc_allField);
	}
	
	/**
	 * It creates the differents labbels.
	 * @param rowName
	 * @param order
	 */
	private void createLabel(String rowName, int order) {
		JLabel lblNewLabel_1 = new JLabel(rowName);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(10, 20, 10, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = order + 1;
		gbc_lblNewLabel_1.weightx = 0.1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
	
}
