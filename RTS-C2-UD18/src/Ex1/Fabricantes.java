package Ex1;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Fabricantes {
	
	private ConexionDB conexion = new ConexionDB();
	
	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce el nombre");
		name = "'"+name+"'";
		
		conexion.MySQLConnection(db);
		conexion.insertData(db, "Fabricantes", "Nombre", name);
	}

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
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el codigo del articulo: ");
		String id = sc.next();
		
		sc.close();
		
		conexion.deleteRecord("Fabricantes", "Codigo", id);
	}
}
