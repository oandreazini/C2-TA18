package Ex3;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Cajas {
	
private ConexionDB conexion;
	
	public void insert(String db) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un número de referencia (Máximo 5 carácteres): ");
		String reference = sc.next();
		
		System.out.println("Introduce el contenido: ");
		String contents = sc.next();
		
		System.out.println("Introduce el valor: ");
		String value = sc.next();
		
		System.out.println("Introduce un número de departamento: ");
		String store = sc.next();
		sc.close();
		
		conexion.insertData(db, "Cajas", "NumReferencia, Nombre, Apellidos, Departamento", reference + ", " + contents + ", " + value+ ", " +store);
		
		
	}

}
