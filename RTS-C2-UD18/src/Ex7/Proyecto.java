package Ex7;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Proyecto {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();
	
	
	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		
		String id = JOptionPane.showInputDialog("Introduce el CODIGO del proyecto (Máximo 4 carácteres): ");
		id = "'" + id + "'";
		
		String nombre = JOptionPane.showInputDialog("Introduce un NOMBRE del proyecto: ");
		nombre = "'" + nombre + "'";
		
		String horas = JOptionPane.showInputDialog("Introduce el NUMERO de horas del proyecto: ");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Proyecto", "Codigo, Nombre, Horas", id +", " + nombre+", " +horas);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Proyecto");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Horas: " + resultSet.getString("Horas"));

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		
		String id = JOptionPane.showInputDialog("Introduce el NUMERO del proyecto que quieres eliminar:");

		conexion.deleteRecord("Proyecto", "Codigo", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CODIGO del proyecto que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del proyecto que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del proyecto que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Proyecto", campo2, campo, id, "Codigo");
	}
}
