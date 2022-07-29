package Ex3;

import javax.swing.JOptionPane;

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
	//Crear tablas
	public static void createTables(ConexionDB con) {
		con.createTable("Ex3", "Almacenes", "Codigo int auto_increment, Lugar VARCHAR(100), Capacidad int , primary key(Codigo)");
		con.createTable("Ex3", "Cajas", "NumReferencia CHAR(5), Contenido VARCHAR(100), Valor int, Almacen int, "
				+ "CONSTRAINT FK_CajAlma FOREIGN KEY (Almacen) REFERENCES Almacenes(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (NumReferencia)");
	}
	
	//Introduce 5 registros a las tablas
	public static void createInserts (Almacenes a, Cajas c) {

		for(int i=0; i<5; i++) {
			a.insert("Ex3");
		}
		for(int i=0; i<5; i++) {
			c.insert("Ex3");
		}
	}
	
	//Imprime los valores de toda las tablas de la DB
	public static void printValues(Almacenes a, Cajas c) {

		a.select("Ex3");
		c.select("Ex3");
	}

	//Borra valores de la DB
	public static void deleteData(Almacenes a, Cajas c) {

		boolean salir = false;

		while (!salir) {
			
			String id = JOptionPane.showInputDialog("Introduce el codigo que quieres eliminar: 1->Almacen 2->Caja 3->No Borrar");
			int i = Integer.parseInt(id);
		
			switch (i){
			case 1:
				a.delete();
				break;
			case 2:
				c.delete();
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
	public static void updateData(Almacenes a, Cajas c) {

		a.update();
		c.update();
	}

}
