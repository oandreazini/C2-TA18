package Ex5;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Directores {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un DNI (M�ximo 8 car�cteres): ");
		String dni = sc.next();

		System.out.println("Introduce nombre y apellidos: ");
		String name = sc.next();

		System.out.println("Introduce el DNI del jefe: ");
		String dniBoss = sc.next();

		System.out.println("Introduce un n�mero de despacho: ");
		String office = sc.next();
		sc.close();

		conexion.insertData(db, "Directores", "DNI, Nombre y Apellidos, DNI Jefe, Despacho", dni + ", " + name + ", " + dniBoss + ", " + office);


	}

}
