package Ex9;


import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex8");
		Facultad f = new Facultad();
		Investigadores i = new Investigadores();
		Equipos e = new Equipos();
		Reserva r = new Reserva();
		createTables(conexionDB);

		createInserts(f, i, e, r);
		printValues(f, i, e, r);
		deleteData(f, i, e, r);
		printValues(f, i, e, r);
		updateData(f, i, e, r);
	}

	public static void createTables(ConexionDB con) {
		con.createTable("Ex9", "Facultad", "Codigo int auto_increment, Nombre VARCHAR(100), primary key(Codigo)");
		con.createTable("Ex9", "Investigadores", "DNI varchar(8), Nombre_Apellidos varchar(100), Facultad int, "
				+ "CONSTRAINT FK_FacultadInv FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo) ON DELETE CASCADE ON UPDATE CASCADE,  primary key(DNI)");
		con.createTable("Ex9", "Equipos", "NumSerie varchar(8), Nombre varchar(100), Facultad int, "
				+ "CONSTRAINT FK_FacultadEq FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo) ON DELETE CASCADE ON UPDATE CASCADE,  primary key(NumSerie)");
		con.createTable("Ex9", "Reserva", "DNI varchar(8), NumSerie varchar(8), Comienzo datetime, Fin datetime, "
				+ "CONSTRAINT FK_IDInvestigadores FOREIGN KEY (DNI) REFERENCES Investigadores(DNI) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_IDIEquipos FOREIGN KEY (NumSerie) REFERENCES Equipos(NumSerie) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (Cajero, Maquina, Producto)");
	}
	
	public static void createInserts (Facultad f, Investigadores in, Equipos e, Reserva r) {

		for(int i=0; i<5; i++) {
			f.insert("Ex9");
		}
		for(int i=0; i<5; i++) {
			in.insert("Ex9");
		}
		for(int i=0; i<5; i++) {
			e.insert("Ex9");
		}
		for(int i=0; i<5; i++) {
			r.insert("Ex9");
		}
	}
	
	public static void printValues(Facultad f, Investigadores i, Equipos e, Reserva r) {
		f.select("Ex9");
		i.select("Ex9");
		e.select("Ex9");
		r.select("Ex9");
	}

	public static void deleteData(Facultad f, Investigadores i, Equipos e, Reserva r) {
		r.delete();
		e.delete();
		i.delete();
		f.delete();
	}
	
	public static void updateData(Facultad f, Investigadores i, Equipos e, Reserva r) {

		f.update();
		i.update();
		e.update();
		r.update();
	}
}
