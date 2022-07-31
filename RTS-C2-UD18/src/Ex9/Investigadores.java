package Ex9;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Investigadores {
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		String dni = JOptionPane.showInputDialog("Introduce el DNI del investigador:");
		dni = "'"+dni+"'";
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE del investigador:");
		name = "'"+name+"'";
		String facultad = JOptionPane.showInputDialog("Introduce la id_FACULTAD del investigador:");


		conexion.MySQLConnection(db);
		conexion.insertData(db, "Investigadores", "DNI, NomApels, Facultad", dni +", " + name + ", " + facultad);
	}

	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Investigadores");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI"));
				System.out.println("Nombre: " + resultSet.getString("NomApels"));
				System.out.println("Facultad: " + resultSet.getString("Facultad"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del investigador: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Investigadores", "DNI", id);
	}

	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del investigador que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del investigador que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del investigador que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Investigadores", campo, campo2, id, "DNI");
	}
}
