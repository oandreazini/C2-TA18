package Ex5;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Directores {

	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		
		String dni = JOptionPane.showInputDialog("Introduce un DNI del director (Máximo 8 carácteres):");
		dni = "'" + dni + "'";
		
		String name = JOptionPane.showInputDialog("Introduce un NOMBRE y apellido del director:");
		name = "'" + name + "'";
		
		String dniJefe = JOptionPane.showInputDialog("Introduce un DNI del director JEFE (Máximo 8 carácteres):");
		dniJefe = "'" + dniJefe + "'";
		
		String office = JOptionPane.showInputDialog("Introduce un NÚMERO de despacho:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Directores", "DNI, NomApels, DNIJefe, Despacho", dni + ", " + name + ", " + dniJefe + ", " + office);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Directores");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI"));
				System.out.println("NomApels: " + resultSet.getString("NomApels"));
				System.out.println("DNIJefe: " + resultSet.getString("DNIJefe"));
				System.out.println("Despacho: " + resultSet.getString("Despacho"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Metodo para eliminar registros
	public void delete() {
			
		String id = JOptionPane.showInputDialog("Introduce el DNI del director que quieres eliminar:");

		conexion.deleteRecord("Directores", "DNI", id);
		}
		
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del director que quieres modificar: ");
		String id = sc.next();
		
		System.out.println("Introduce el CAMPO del director que quieres modificar: ");
		String campo = sc.next();
		
		System.out.println("Introduce el NUEVO VALOR del director que quieres modificar: ");
		String campo2 = sc.next();
		sc.close();

		conexion.updateData("Directores", campo2, campo, id, "DNI");
		}
	
}
