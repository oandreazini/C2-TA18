package Ex7;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {

		ConexionDB conexionDB = new ConexionDB("Ex7");

		Cientificos c = new Cientificos();
		Proyecto p = new Proyecto();
		AsignadoA a = new AsignadoA();

		createTables(conexionDB);

		createInserts(c, p, a);
		printValues(c, p, a);
		deleteData(c, p, a);
		printValues(c, p, a);
		//updateData(c, p, a);
	}

	//Crear tablas
	public static void createTables(ConexionDB con) {
		con.createTable("Ex7", "Cientificos", "DNI VARCHAR(8), NomApels VARCHAR(255), PRIMARY KEY (DNI)");
		con.createTable("Ex7", "Proyecto", "Codigo VARCHAR(8), Nombre VARCHAR(255), Horas int, PRIMARY KEY (Codigo)");
		con.createTable("Ex7", "AsignadoA", "Cientifico VARCHAR(8), Proyecto CHAR(4), "
				+ "CONSTRAINT FK_DNIAsignadoA FOREIGN KEY (Cientifico) REFERENCES Cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_IDAsignadoA FOREIGN KEY (Proyecto) REFERENCES Proyecto (Codigo) ON DELETE CASCADE ON UPDATE CASCADE ");			
	}

	//Introduce 5 registros a las tablas
	public static void createInserts (Cientificos c, Proyecto p,  AsignadoA a) {

		for(int i=0; i<2; i++) {
			c.insert("Ex7");
		}
		for(int i=0; i<2; i++) {
			p.insert("Ex7");
		}
		for(int i=0; i<2; i++) {
			a.insert("Ex7");
		}	
	}

	//Imprime los valores de toda las tablas de la DB
	public static void printValues (Cientificos c, Proyecto p,  AsignadoA a) {

		c.select("Ex7");
		p.select("Ex7");
		a.select("Ex7");
	}

	//Borra valores de la DB
	public static void deleteData (Cientificos c, Proyecto p,  AsignadoA a) {

		boolean salir = false;

		while (!salir) {
			
			String id = JOptionPane.showInputDialog("Introduce el codigo que quieres eliminar: 0->Cientifico 1->Proyecto 2->Asignado 3->No Borrar");
			int i = Integer.parseInt(id);
		
			switch (i){
			case 0:
				c.delete();
				break;
			case 1:
				p.delete();
				break;
			case 2:
				a.delete();
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
	public static void updateData (Cientificos c, Proyecto p,  AsignadoA a) {

		c.update();
		p.update();
		a.update();
	}
}



