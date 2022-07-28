package Ex8;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Productos {

	private ConexionDB conexion;

	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE de producto:");
		name = "'" + name + "'";

		String price = JOptionPane.showInputDialog("Introduce un PRECIO de producto:");
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Productos", "Nombre, Precio", name + ", " + price);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Productos");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Precio: " + resultSet.getString("Precio"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Código del producto: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Productos", "Codigo", id);
	}
}
