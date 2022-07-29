package Ex1;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Articulos {
	
		
		private ConexionDB conexion = new ConexionDB();
		
		public void insert(String db) {
			String name = JOptionPane.showInputDialog("Introduce un NOMBRE del articulo:");
			name = "'"+name+"'";
			
			String price = JOptionPane.showInputDialog("Introduce un PRECIO del articulo:");
			
			String maker = JOptionPane.showInputDialog("Introduce un FABRICANTE del articulo:");
			
			
			conexion.MySQLConnection(db);
			conexion.insertData(db, "Articulos", "Nombre, Precio, Fabricante", name +", " + price + ", " + maker);
		}
		
		public void select(String db) {
			
			java.sql.ResultSet resultSet  = conexion.getValues(db, "Articulos");
			
			try {
				while(resultSet.next()) {
					System.out.println("Codigo: " + resultSet.getString("Codigo"));
					System.out.println("Nombre: " + resultSet.getString("Nombre"));
					System.out.println("Precio: " + resultSet.getString("Precio"));
					System.out.println("Fabricante: " + resultSet.getString("Fabricante"));
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
			
			conexion.deleteRecord("Articulos", "Codigo", id);
		}

}
