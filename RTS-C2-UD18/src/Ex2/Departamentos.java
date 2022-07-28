package Ex2;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Departamentos {

private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un nombre de departamento: ");
		String name = sc.next();
		
		System.out.println("Introduce un presupuesto de departamento: ");
		String budget = sc.next();
		sc.close();
		
		conexion.insertData(db, "Departamentos", "Nombre, Presupuesto", name + ", " + budget);
	}
}
