package Ex7;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Cientificos {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();
	
	public void insert(String db) {

		String dni = JOptionPane.showInputDialog("Introduce un DNI del cientifico (Máximo 8 carácteres):");
		dni = "'" + dni + "'";
		
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE y apellido del cientifico:");
		name = "'" + name + "'";

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Cientificos", "DNI, NomApels", dni +", " + name);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Cientificos");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI"));
				System.out.println("NomApels: " + resultSet.getString("NomApels"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Metodo para eliminar registros
	public void delete() {
		
		String id = JOptionPane.showInputDialog("Introduce el DNI del cientifico que quieres eliminar:");

		conexion.deleteRecord("Cientificos", "DNI", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del cientifico que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del cientifico que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del cientifico que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Cientificos", campo2, campo, id, "DNI");
	}
	
	
}
