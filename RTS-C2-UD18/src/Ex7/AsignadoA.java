package Ex7;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class AsignadoA {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	public void insert(String db) {
	
		String dni = JOptionPane.showInputDialog("Introduce un DNI del cientifico asignado (Máximo 8 carácteres):");
		dni = "'" + dni + "'";
		
		String id = JOptionPane.showInputDialog("Introduce el CODIGO del proyecto asignado (Máximo 4 carácteres): ");
		id = "'" + id + "'";
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "AsignadoA", "Cientifico, Proyecto", dni +", " + id);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "AsignadoA");

		try {
			while(resultSet.next()) {
				System.out.println("Cientifico: " + resultSet.getString("Cientifico"));
				System.out.println("Proyecto: " + resultSet.getString("Proyecto"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Metodo para eliminar registros
	public void delete() {
		
		String id = JOptionPane.showInputDialog("Introduce el DNI de cientifico asignado que quieres eliminar:");

		conexion.deleteRecord("AsignadoA", "Cientifico", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI de cientifico asignado que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del cientifico asignado que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del cientifico asignado que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("AsignadoA", campo2, campo, id, "Cientifico");
	}
	
	

}
