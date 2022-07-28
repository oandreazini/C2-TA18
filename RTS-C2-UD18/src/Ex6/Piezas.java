package Ex6;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Piezas {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un nombre de la pieza: ");
		String name = sc.next();
		sc.close();

		conexion.insertData(db, "Piezas", "Nombre", name);
	}
}
