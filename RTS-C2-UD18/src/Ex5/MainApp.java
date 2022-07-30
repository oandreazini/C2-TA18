package Ex5;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {

		ConexionDB conexionDB = new ConexionDB("Ex5");
		
		Despachos des = new Despachos();
		Directores dir = new Directores();

		createTables(conexionDB);

		createInserts(des, dir);
		printValues(des, dir);
		deleteData(des, dir);
		printValues(des, dir);
		//updateData(des, dir);
	}

	//Crear tablas
	public static void createTables(ConexionDB con) {
		con.createTable("Ex5", "Despachos", "Numero int, Capacidad int , primary key(Numero)");
		con.createTable("Ex5", "Directores", "DNI VARCHAR(8), NomApels VARCHAR(255), DNIJefe VARCHAR(8), Despacho int, "
					+ "CONSTRAINT FK_Despa FOREIGN KEY (Despacho) REFERENCES Despachos(Numero) ON DELETE CASCADE ON UPDATE CASCADE, "
					+ "CONSTRAINT FK_DNIBoss FOREIGN KEY (DNIJefe) REFERENCES Directores(DNI) ON DELETE CASCADE ON UPDATE CASCADE, "
					+ "PRIMARY KEY (DNI)");
		}
	
	//Introduce 5 registros a las tablas
	public static void createInserts (Despachos des, Directores dir) {

		for(int i=0; i<5; i++) {
			des.insert("Ex5");
		}
		for(int i=0; i<5; i++) {
			dir.insert("Ex5");
		}
	}
	
	//Imprime los valores de toda las tablas de la DB
	public static void printValues(Despachos des, Directores dir) {

		des.select("Ex5");
		dir.select("Ex5");
	}

	//Borra valores de la DB
	public static void deleteData(Despachos des, Directores dir) {

		boolean salir = false;

		while (!salir) {
			
			String id = JOptionPane.showInputDialog("Introduce el codigo que quieres eliminar: 1->Despacho 2->Director 3->No Borrar");
			int i = Integer.parseInt(id);
		
			switch (i){
			case 1:
				des.delete();
				break;
			case 2:
				dir.delete();
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
	public static void updateData(Despachos des, Directores dir) {

		des.update();
		dir.update();
	}
}


