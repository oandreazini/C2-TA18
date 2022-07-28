package Ex8;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Venta {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un código de cajero: ");
		String id_caj = sc.next();

		System.out.println("Introduce un código de máquina registradora: ");
		String id_maq = sc.next();
		
		System.out.println("Introduce un código de producto: ");
		String id_prod = sc.next();
		sc.close();

		conexion.insertData(db, "Venta", "Cajero, Maquina, Producto", id_caj + ", " + id_maq + ", " + id_prod);
	}
}
