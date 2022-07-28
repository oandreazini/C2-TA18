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

		String movie_id = JOptionPane.showInputDialog("Introduce un c�digo de pel�cula:");

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
}
