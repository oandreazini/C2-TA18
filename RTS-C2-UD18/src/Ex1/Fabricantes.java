package Ex1;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Fabricantes {
	
	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un nombre: ");
		String name = sc.next();
		sc.close();
		
		conexion.insertData(db, "Fabricantes", "Nombre", name);
	}

}
