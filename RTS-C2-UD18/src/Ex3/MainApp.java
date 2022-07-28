package Ex3;

import Ex2.Departamentos;
import Ex2.Empleados;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createInserts();

	}
	
	public static void createInserts () {

		Almacenes a = new Almacenes();
		Cajas c = new Cajas();

		for(int i=0; i<5; i++) {
			a.insert("Ex3");
		}
		for(int i=0; i<5; i++) {
			c.insert("Ex3");
		}
	}

}
