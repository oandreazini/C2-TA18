package Ex8;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Maquinas_Registradoras {

	private ConexionDB conexion;

	public void insert(String db) {
		String flat = JOptionPane.showInputDialog("Introduce un PISO:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Maquinas_Registradoras", "Piso", flat);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Maquinas_Registradoras");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Piso: " + resultSet.getString("Piso"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el C�digo del piso: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Maquinas_Registradoras", "Codigo", id);
	}
}
