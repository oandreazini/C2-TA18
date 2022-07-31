package Ex9;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Equipos {
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		String numSerie = JOptionPane.showInputDialog("Introduce el NUMERO DE SERIE del equipo:");
		numSerie = "'"+numSerie+"'";
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE del equipo:");
		name = "'"+name+"'";
		String facultad = JOptionPane.showInputDialog("Introduce la id_FACULTAD del equipo:");


		conexion.MySQLConnection(db);
		conexion.insertData(db, "Equipos", "NumSerie, NomApels, Facultad", numSerie +", " + name + ", " + facultad);
	}

	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Equipos");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("NumSerie"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Facultad: " + resultSet.getString("Facultad"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el NUMERO DE SERIE del equipo: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Equipos", "NumSerie", id);
	}

	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el NUMERO DE SERIE del equipo que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del equipo que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del equipo que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Equipos", campo, campo2, id, "NumSerie");
	}
}
