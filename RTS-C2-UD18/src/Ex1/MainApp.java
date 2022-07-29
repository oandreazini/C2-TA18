package Ex1;

import metodosConexion.ConexionDB;

public class MainApp {
	
	
	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex1");
		Fabricantes fab = new Fabricantes();
		Articulos art = new Articulos();
		
		createTables(conexionDB);
		createInserts(fab, art);
		printValues(fab, art);
		deleteData(fab, art);
		printValues(fab, art);
		updateData(fab,art);
	}
	
	//Crear tablas
	public static void createTables(ConexionDB con) {
		con.createTable("Ex1", "Fabricantes", "Codigo int auto_increment, Nombre VARCHAR(100), primary key(Codigo)");
		con.createTable("Ex1", "Articulos", "Codigo int auto_increment, Nombre VARCHAR(100), Precio int, Fabricante int, "
				+ "CONSTRAINT FK_ArtiFabri FOREIGN KEY (Fabricante) REFERENCES Fabricantes(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (Codigo)");
	}
	
	//Introduce 5 registros a las tablas
	public static void createInserts (Fabricantes f, Articulos a) {
		//TODO
		for(int i=0; i<1; i++) {
			f.insert("Ex1");
		}
		for(int i=0; i<1; i++) {
			a.insert("Ex1");
		}
	}
	
	public static void printValues(Fabricantes f, Articulos a) {
		
		f.select("Ex1");
		a.select("Ex1");
	}
	
	public static void deleteData(Fabricantes f, Articulos a) {
		
		a.delete();
		f.delete();
	}
	public static void updateData(Fabricantes f, Articulos a) {

		a.update();
		f.update();
	}
}
