package Ex1;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Fabricantes {
	
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();
	
	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce el nombre");
		name = "'"+name+"'";
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Fabricantes", "Nombre", name);
	}
	
	//Metodo para imprimir los registros
	public void select(String db) {
		
		java.sql.ResultSet resultSet  = conexion.getValues(db, "Fabricantes");
		
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
		
		System.out.println("Introduce el codigo del articulo: ");
		String id = sc.next();
		
		sc.close();
		
		conexion.deleteRecord("Fabricantes", "Codigo", id);
	}
	
	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CODIGO del fabricante que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del fabricante que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del fabricante que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Fabricantes", campo, campo2, id, "Codigo");
	}
}
