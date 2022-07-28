package Ex5;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Despachos {

	private ConexionDB conexion;

	public void insert(String db) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número de despacho: ");
		String number = sc.next();

		System.out.println("Introduce la capacidad del despacho: ");
		String capacity = sc.next();

		sc.close();

		conexion.insertData(db, "Despachos", "Número, Capacidad", number +", " + capacity);
	}

}
