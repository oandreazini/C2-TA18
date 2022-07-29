package Ex6;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Suministra {

	private ConexionDB conexion;

	public void insert(String db) {
		String id_piece = JOptionPane.showInputDialog("Introduce un CÓDIGO de pieza:");

		String id_provider = JOptionPane.showInputDialog("Introduce un CÓDIGO de proveedor:");
		id_provider = "'" + id_provider + "'";

		String price = JOptionPane.showInputDialog("Introduce un PRECIO:");
	
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Suministra", "CodigoPieza, IdProveedor, Precio", id_piece + ", " + id_provider + ", " + price);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Suministra");

		try {
			while(resultSet.next()) {
				System.out.println("CodigoPieza: " + resultSet.getString("CodigoPieza"));
				System.out.println("IdProveedor: " + resultSet.getString("IdProveedor"));
				System.out.println("Precio: " + resultSet.getString("Precio"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el código del proveedor: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Suministra", "IdProveedor", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CÓDIGO del proveedor que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del proveedor que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del proveedor que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Suministra", campo2, campo, id, "IdProveedor");
	}
}
