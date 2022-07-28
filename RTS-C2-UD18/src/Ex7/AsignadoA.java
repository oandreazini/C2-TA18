package Ex7;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class AsignadoA {
	
	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un código del científico: ");
		String id_scientist = sc.next();

		System.out.println("Introduce un código del proyecto: ");
		String id_project = sc.next();
		sc.close();
		
		conexion.insertData(db, "AsignadoA", "Científico, Proyecto", id_scientist +", " + id_project);
		}

}
