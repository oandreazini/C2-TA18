package Ex7;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Cientificos {
	
	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un DNI (M�ximo 8 car�cteres) ");
		String dni = sc.next();
		
		System.out.println("Introduce el nombre y los apellidos ");
		String name = sc.next();
		sc.close();
		
		conexion.insertData(db, "Cientificos", "DNI, Nombre y Apellido", dni +", " + name);
	}
}
