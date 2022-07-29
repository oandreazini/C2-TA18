package Ex7;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		
		ConexionDB conexionDB = new ConexionDB("Ex7");
		
		Cientificos c = new Cientificos();
		Proyecto p = new Proyecto();
		AsignadoA a = new AsignadoA();
		
		createTables(conexionDB);
		
		createInserts();
	}
	
	public static void createInserts () {

		

		for(int i=0; i<5; i++) {
			c.insert("Ex7");
		}
		for(int i=0; i<5; i++) {
			p.insert("Ex7");
		}
		for(int i=0; i<5; i++) {
			a.insert("Ex7");
		}
		
	}

}
