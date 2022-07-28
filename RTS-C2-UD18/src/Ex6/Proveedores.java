package Ex6;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Proveedores {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un código de proveedor (Máximo 4 carácteres): ");
		String id = sc.next();

		System.out.println("Introduce un nombre de proveedor: ");
		String name = sc.next();
		sc.close();

		conexion.insertData(db, "Proveedores", "id, Nombre", id +", " + name);
	}
}
