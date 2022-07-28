package Ex2;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Empleados {

	private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un DNI (M�ximo 8 car�cteres): ");
		String dni = sc.next();
		
		System.out.println("Introduce un nombre: ");
		String name = sc.next();
		
		System.out.println("Introduce un apellido: ");
		String surname = sc.next();
		
		System.out.println("Introduce un n�mero de departamento: ");
		String dep = sc.next();
		sc.close();
		
		conexion.insertData(db, "Empleados", "DNI, Nombre, Apellidos, Departamento", dni + ", " + name + ", " + surname + ", " + dep);
		
		
	}
}
