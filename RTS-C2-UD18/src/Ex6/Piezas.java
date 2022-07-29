package Ex6;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Piezas {

	private ConexionDB conexion;

	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE de pieza:");
		name = "'" + name + "'";
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Piezas", "Nombre", name);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Piezas");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Codigo de pieza: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Piezas", "Codigo", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el C�DIGO del piezas que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del piezas que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del piezas que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Piezas", campo2, campo, id, "Codigo");
	}
}
