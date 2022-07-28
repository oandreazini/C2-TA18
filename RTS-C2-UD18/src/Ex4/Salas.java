package Ex4;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Salas {

	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un nombre de la sala: ");
		String name = sc.next();
		
		System.out.println("Introduce un código de la película: ");
		String movie_id = sc.next();
		sc.close();
		
		conexion.insertData(db, "Salas", "Nombre, Pelicula", name +", " + movie_id);
	}
}
