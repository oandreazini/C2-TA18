package Ex4;

import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex2");
		Peliculas p = new Peliculas();
		Salas s = new Salas();

		createTables(conexionDB);

		createInserts(p, s);
		printValues(p, s);
		deleteData(p, s);
		printValues(p, s);
	}
	
	public static void createTables(ConexionDB con) {
		con.createTable("Ex3", "Peliculas", "Codigo int auto_increment, Nombre VARCHAR(100), CalificacionEdad int , primary key(Codigo)");
		con.createTable("Ex3", "Salas", "Codigo int auto_increment, Nombre VARCHAR(100), Pelicula int, "
				+ "CONSTRAINT FK_SalaPeli FOREIGN KEY (Pelicula) REFERENCES Peliculas(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (Codigo)");
	}

	public static void createInserts (Peliculas p, Salas s) {

		for(int i=0; i<5; i++) {
			p.insert("Ex2");
		}
		for(int i=0; i<5; i++) {
			s.insert("Ex2");
		}
	}

	public static void printValues(Peliculas p, Salas s) {

		p.select("Ex1");
		s.select("Ex1");
	}

	public static void deleteData(Peliculas p, Salas s) {

		s.delete();
		p.delete();
	}

}
