package Ex8;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Venta {

	private ConexionDB conexion;

	public void insert(String db) {
		String id_caj = JOptionPane.showInputDialog("Introduce un CÓDIGO de cajero:");

		String id_maq = JOptionPane.showInputDialog("Introduce un CÓDIGO de maquina registradora:");
		
		String id_prod = JOptionPane.showInputDialog("Introduce un CÓDIGO de producto:");
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Venta", "Cajero, Maquina, Producto", id_caj + ", " + id_maq + ", " + id_prod);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Venta");

		try {
			while(resultSet.next()) {
				System.out.println("Cajero: " + resultSet.getString("Cajero"));
				System.out.println("Maquina: " + resultSet.getString("Maquina"));
				System.out.println("Producto: " + resultSet.getString("Producto"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Código del cajero: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Venta", "Cajero", id);
	}
}
