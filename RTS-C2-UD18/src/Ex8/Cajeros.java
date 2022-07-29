package Ex8;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Cajeros {

	private ConexionDB conexion;

	public void insert(String db) {
		String NomApels = JOptionPane.showInputDialog("Introduce un NOMBRE y APELLIDOS:");
		NomApels = "'" + NomApels + "'";

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Cajeros", "NomApels", NomApels);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Cajeros");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("NomApels: " + resultSet.getString("NomApels"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el C�digo del cajero: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Cajeros", "Codigo", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el C�DIGO del cajero que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del departamento que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del departamento que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Cajeros", campo2, campo, id, "Codigo");
	}
}
