package Ex3;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Almacenes {
	
	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un lugar: ");
		String place = sc.next();
		
		System.out.println("Introduce la capacidad: ");
		String capacity = sc.next();
		sc.close();
		
		conexion.insertData(db, "Almacenes", "Lugar, Capacidad", place +", " + capacity);
	}
}
