package Ex4;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Salas {

	private ConexionDB conexion;

	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE de la sala:");
		name = "'" + name + "'";

		String movie_id = JOptionPane.showInputDialog("Introduce un código de película:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Salas", "Nombre, Pelicula", name +", " + movie_id);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Salas");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Pelicula: " + resultSet.getString("Pelicula"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Codigo de sala: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Salas", "Codigo", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CÓDIGO de la sala que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO de la sala que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR de la sala que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Salas", campo2, campo, id, "Codigo");
	}
}
