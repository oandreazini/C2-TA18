package Ex4;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Peliculas {

	private ConexionDB conexion;

	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce el NOMBRE de la pel�cula");
		name = "'" + name + "'";

		String age = JOptionPane.showInputDialog("Introduce la CALIFICACI�N EDAD de la pel�cula:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Peliculas", "Nombre, CalificacionEdad", name +", " + age);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Peliculas");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("CalificacionEdad: " + resultSet.getString("CalificacionEdad"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el Codigo de la pel�cula: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Peliculas", "Codigo", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el C�DIGO de la pel�cula que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO de la pel�cula que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR de la pel�cula que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Peliculas", campo2, campo, id, "Codigo");
	}
}
