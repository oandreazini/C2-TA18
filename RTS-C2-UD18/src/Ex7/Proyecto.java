package Ex7;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Proyecto {
	
	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un c�digo del proyecto (M�ximo 4 car�cteres): ");
		String id = sc.next();

		System.out.println("Introduce un nombre del proyecto: ");
		String name = sc.next();
		
		System.out.println("Introduce el tiempo: ");
		String time = sc.next();
		sc.close();

		conexion.insertData(db, "Proyecto", "id, Nombre, Horas", id +", " + name+", " +time);
	}

}
