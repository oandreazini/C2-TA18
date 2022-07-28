package Ex1;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Articulos {
	
		
		private ConexionDB conexion;
		
		public void insert(String db) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduce un nombre del articulo: ");
			String name = sc.next();
			
			System.out.println("Introduce un precio del articulo: ");
			String price = sc.next();
			
			System.out.println("Introduce un fabricante del articulo: ");
			String maker = sc.next();
			sc.close();
			
			conexion.insertData(db, "Articulos", "Nombre, Precio, Fabricante", name +", " + price + ", " + maker);
		}

}
