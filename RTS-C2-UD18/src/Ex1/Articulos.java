package Ex1;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Articulos {
	
		//Creamos la conexion a la DB
		private ConexionDB conexion = new ConexionDB();
		
		//Metodo para insertar registros a la tabla
		public void insert(String db) {
			
			String name = JOptionPane.showInputDialog("Introduce un NOMBRE del articulo:");
			name = "'"+name+"'";
			
			String price = JOptionPane.showInputDialog("Introduce un PRECIO del articulo:");
			
			String maker = JOptionPane.showInputDialog("Introduce un FABRICANTE del articulo:");
			
			
			conexion.MySQLConnection(db);
			conexion.insertData(db, "Articulos", "Nombre, Precio, Fabricante", name +", " + price + ", " + maker);
		}
		
		//Metodo para imprimir los registros
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
		
		//Metodo para eliminar registros de la tabla articulos
		public void delete() {
			
			String id = JOptionPane.showInputDialog("Introduce el codigo del articulo que quieres eliminar:");
		
			conexion.deleteRecord("Articulos", "Codigo", id);
			
			
		}
		
		//Metodo para actualizar los valores de los registros
		public void update() {
			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el CODIGO del articulo que quieres modificar: ");
			String id = sc.next();
			System.out.println("Introduce el CAMPO del articulo que quieres modificar: ");
			String campo = sc.next();
			System.out.println("Introduce el NUEVO VALOR del articulo que quieres modificar: ");
			String campo2 = sc.next();

			sc.close();

			conexion.updateData("Articulos", campo, campo2, id, "Codigo");
		}

}
