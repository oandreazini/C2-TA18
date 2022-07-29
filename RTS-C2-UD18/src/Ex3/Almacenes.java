package Ex3;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Almacenes {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();
	
	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		
		String place = JOptionPane.showInputDialog("Introduce el LUGAR del almacen");
		place = "'" + place + "'";
		
		String capacity = JOptionPane.showInputDialog("Introduce una CAPACIDAD del almacen:");
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Almacenes", "Lugar, Capacidad", place +", " + capacity);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Almacenes");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Lugar: " + resultSet.getString("Lugar"));
				System.out.println("Capacidad: " + resultSet.getString("Capacidad"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		
		String id = JOptionPane.showInputDialog("Introduce el codigo del almacen que quieres eliminar:");

		conexion.deleteRecord("Almacenes", "Codigo", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CÓDIGO del almacen que quieres modificar: ");
		String id = sc.next();
		
		System.out.println("Introduce el CAMPO del almacen que quieres modificar: ");
		String campo = sc.next();
		
		System.out.println("Introduce el NUEVO VALOR del almacen que quieres modificar: ");
		String campo2 = sc.next();
		sc.close();

		conexion.updateData("Almacenes", campo2, campo, id, "Codigo");
	}

}
