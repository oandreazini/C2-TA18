package Ex6;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Suministra {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un código de pieza: ");
		String id_piece = sc.next();

		System.out.println("Introduce un código de proveedor: ");
		String id_provider = sc.next();
		
		System.out.println("Introduce un precio: ");
		String price = sc.next();
		sc.close();

		conexion.insertData(db, "Suministra", "CodigoPieza, idProveedor, Precio", id_piece + ", " + id_provider + ", " + price);
	}
}
