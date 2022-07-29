package Ex3;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		
		ConexionDB conexionDB = new ConexionDB("Ex3");
		Cajas c = new Cajas();
		Almacenes a = new Almacenes();

		createTables(conexionDB);

		createInserts(a, c);
		printValues(a, c);
		deleteData(a, c);
		printValues(a, c);
		//updateData(a,c);

	}
	
	public static void createTables(ConexionDB con) {
		con.createTable("Ex3", "Almacenes", "Codigo int auto_increment, Lugar VARCHAR(100), Capacidad int , primary key(Codigo)");
		con.createTable("Ex3", "Cajas", "NumReferencia CHAR(5), Contenido VARCHAR(100), Valor int, Almacen int, "
				+ "CONSTRAINT FK_CajAlma FOREIGN KEY (Almacen) REFERENCES Almacenes(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (DNI)");
	}
	
	public static void createInserts (Almacenes a, Cajas c) {

		for(int i=0; i<5; i++) {
			a.insert("Ex3");
		}
		for(int i=0; i<5; i++) {
			c.insert("Ex3");
		}
	}
	
	public static void printValues(Almacenes a, Cajas c) {

		a.select("Ex3");
		c.select("Ex3");
	}

	public static void deleteData(Almacenes a, Cajas c) {

		a.delete();
		c.delete();
	}
	
	public static void updateData(Almacenes a, Cajas c) {

		a.update();
		c.update();
	}

}
