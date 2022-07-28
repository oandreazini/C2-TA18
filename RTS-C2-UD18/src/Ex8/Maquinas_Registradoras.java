package Ex8;

import java.util.Scanner;

import metodosConexion.ConexionDB;

public class Maquinas_Registradoras {

	private ConexionDB conexion;

	public void insert(String db) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un piso de la máquina registradora: ");
		String flat = sc.next();
		sc.close();

		conexion.insertData(db, "Maquinas_Registradoras", "Piso", flat);
	}
}
