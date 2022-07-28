package Ex4;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Peliculas {
	
	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un nombre de la película: ");
		String name = sc.next();
		
		System.out.println("Introduce la calificación de edad: ");
		String age = sc.next();
		sc.close();
		
		conexion.insertData(db, "Peliculas", "Nombre, CalificacionEdad", name +", " + age);
	}
}
