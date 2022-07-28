package Ex2;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex2");
		Empleados e = new Empleados();
		Departamentos d = new Departamentos();

		createTables(conexionDB);

		createInserts(e, d);
		printValues(e, d);
		deleteData(e, d);
		printValues(e, d);

	}

	public static void createTables(ConexionDB con) {
		con.createTable("Ex2", "Departamentos", "Codigo int auto_increment, Nombre VARCHAR(100), Presupuesto int , primary key(Codigo)");
		con.createTable("Ex2", "Empleados", "DNI VARCHAR(8), Nombre VARCHAR(100), Apellidos VARCHAR(255), Departamento int, "
				+ "CONSTRAINT FK_DepaEmple FOREIGN KEY (Departamento) REFERENCES Departamentos(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (DNI)");
	}

	public static void createInserts (Empleados e, Departamentos d) {

		for(int i=0; i<5; i++) {
			d.insert("Ex2");
		}
		for(int i=0; i<5; i++) {
			e.insert("Ex2");
		}
	}

	public static void printValues(Empleados e, Departamentos d) {

		e.select("Ex1");
		d.select("Ex1");
	}

	public static void deleteData(Empleados e, Departamentos d) {

		e.delete();
		d.delete();
	}

}
