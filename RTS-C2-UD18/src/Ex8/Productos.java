package Ex8;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Productos {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un nombre de producto: ");
		String name = sc.next();

		System.out.println("Introduce un precio de producto: ");
		String price = sc.next();
		sc.close();

		conexion.insertData(db, "Productos", "Nombre, Precio", name + ", " + price);
	}
}
