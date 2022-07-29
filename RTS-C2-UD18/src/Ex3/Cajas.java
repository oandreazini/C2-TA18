package Ex3;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Cajas {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();
	
	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		
		String NumReferencia = JOptionPane.showInputDialog("Introduce el NUMERO de referencia de la caja (5 carácteres)");
		NumReferencia = "'" + NumReferencia + "'";

		String contenido = JOptionPane.showInputDialog("Introduce un CONTENIDO de la caja:");
		contenido = "'" + contenido + "'";
		
		String valor = JOptionPane.showInputDialog("Introduce un VALOR de la caja:");
		
		String alm = JOptionPane.showInputDialog("Introduce un NÚMERO de almacen:");
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Cajas", "NumReferencia, Contenido, Valor, Almacen", NumReferencia + ", "
				+ "" + contenido + ", " + valor+ ", " +alm);
		
		
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Cajas");

		try {
			while(resultSet.next()) {
				System.out.println("NumReferencia: " + resultSet.getString("NumReferencia"));
				System.out.println("Contenido: " + resultSet.getString("Contenido"));
				System.out.println("Valor: " + resultSet.getString("Valor"));
				System.out.println("Almacen: " + resultSet.getString("Almacen"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Metodo para eliminar registros de la tabla fabricantes
	public void delete() {
		String id = JOptionPane.showInputDialog("Introduce el codigo de la caja que quieres eliminar:");

		conexion.deleteRecord("Cajas", "NumReferencia", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el NUMERO de referencia de la caja que quieres modificar: ");
		String id = sc.next();
		
		System.out.println("Introduce el CAMPO de la caja que quieres modificar: ");
		String campo = sc.next();
		
		System.out.println("Introduce el NUEVO VALOR de la caja que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Cajas", campo2, campo, id, "NumReferencia");
	}

}
