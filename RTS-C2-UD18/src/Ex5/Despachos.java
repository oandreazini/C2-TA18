package Ex5;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Despachos {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {

		String number = JOptionPane.showInputDialog("Introduce un NUMERO de despacho:");
		number = "'" + number + "'";
		
		String capacity = JOptionPane.showInputDialog("Introduce la CAPACIDAD del despacho:");
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Despachos", "Número, Capacidad", number +", " + capacity);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Despachos");

		try {
			while(resultSet.next()) {
				System.out.println("Numero: " + resultSet.getString("Numero"));
				System.out.println("Capacidad: " + resultSet.getString("Capacidad"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Metodo para eliminar registros
	public void delete() {
		
		String id = JOptionPane.showInputDialog("Introduce el NUMERO del despacho que quieres eliminar:");

		conexion.deleteRecord("Despachos", "Numero", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el NUMERO del despacho que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del despacho que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del despacho que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Despachos", campo2, campo, id, "Numero");
	}

}
