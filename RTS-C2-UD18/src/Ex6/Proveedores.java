package Ex6;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Proveedores {

	private ConexionDB conexion;

	public void insert(String db) {
		String id = JOptionPane.showInputDialog("Introduce un código de proveedor (Máximo 4 carácteres):");
		id = "'" + id + "'";

		String name = JOptionPane.showInputDialog("Introduce un NOMBRE del empleado:");
		name = "'" + name + "'";

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Proveedores", "id, Nombre", id +", " + name);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Proveedores");

		try {
			while(resultSet.next()) {
				System.out.println("id: " + resultSet.getString("id"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Código del proveedor: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Proveedores", "Codigo", id);
	}
}
