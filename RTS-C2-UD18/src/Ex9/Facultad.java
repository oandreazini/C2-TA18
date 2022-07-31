package Ex9;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Facultad {
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE de la facultad:");
		name = "'"+name+"'";



		conexion.MySQLConnection(db);
		conexion.insertData(db, "Facultad", "Nombre", name);
	}

	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Facultad");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el codigo de la facultad: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Facultad", "Codigo", id);
	}

	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CODIGO de la facultad que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO de la facultad que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR de la facultad que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Facultad", campo, campo2, id, "Codigo");
	}
}
