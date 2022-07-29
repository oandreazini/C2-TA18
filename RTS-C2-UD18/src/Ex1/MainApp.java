package Ex1;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class MainApp {
	
	
	public static void main(String[] args) {
		
		ConexionDB conexionDB = new ConexionDB("Ex1");
		Fabricantes f = new Fabricantes();
		Articulos a = new Articulos();
		
		createTables(conexionDB);
		createInserts(f, a);
		printValues(f, a);
		deleteData(f, a);
		printValues(f, a);
		//updateData(f,a);
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
		for(int i=0; i<5
				; i++) {
			f.insert("Ex1");
		}
		for(int i=0; i<5; i++) {
			a.insert("Ex1");
		}
	}
	
	//Imprime los valores de toda las tablas de la DB
	public static void printValues(Fabricantes f, Articulos a) {
		
		f.select("Ex1");
		a.select("Ex1");
	}
	
	//Borra valores de la DB
	public static void deleteData(Fabricantes f, Articulos a) {
		
		boolean salir = false;

		while (!salir) {
			
			String id = JOptionPane.showInputDialog("Introduce el codigo que quieres eliminar: 1->Articulo 2->Fabricante 3->No Borrar");
			int i = Integer.parseInt(id);
		
			switch (i){
			case 1:
				a.delete();
				break;
			case 2:
				f.delete();
				break;
			case 3:
				salir = true;
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "El numero introducido es incorrecto");
			}
		}
	}
	
	//Actualiza los valores 
	public static void updateData(Fabricantes f, Articulos a) {

		a.update();
		f.update();
	}
}
