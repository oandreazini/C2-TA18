package Ex8;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Cajeros {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un nombre y apellidos: ");
		String nomApels = sc.next();
		sc.close();

		conexion.insertData(db, "Cajeros", "NomApels", nomApels);
	}
}
