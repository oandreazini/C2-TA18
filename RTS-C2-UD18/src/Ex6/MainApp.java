package Ex6;

import metodosConexion.ConexionDB;

public class MainApp {
	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex6");
		Piezas piece = new Piezas();
		Proveedores provider = new Proveedores();
		Suministra s = new Suministra();

		createTables(conexionDB);

		createInserts(piece, provider, s);
		printValues(piece, provider, s);
		deleteData(piece, provider, s);
		printValues(piece, provider, s);
		updateData(piece, provider, s);
	}
	
	public static void createTables(ConexionDB con) {
		con.createTable("Ex6", "Piezas", "Codigo int auto_increment, Nombre VARCHAR(100), primary key(Codigo)");
		con.createTable("Ex6", "Proveedores", "id CHAR(4), Nombre VARCHAR(100), primary key(id)");
		con.createTable("Ex6", "Suministra", "CodigoPieza int, IdProveedor CHAR(4), Precio int, "
				+ "CONSTRAINT FK_SumPiezas FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_SumProveedor FOREIGN KEY (IdProveedor) REFERENCES Proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (CodigoPieza, IdProveedor)");
	}

	public static void createInserts (Piezas piece, Proveedores provider, Suministra s) {


		for(int i=0; i<5; i++) {
			piece.insert("Ex6");
		}
		for(int i=0; i<5; i++) {
			provider.insert("Ex6");
		}
		for(int i=0; i<5; i++) {
			s.insert("Ex6");
		}
	}
	
	public static void printValues(Piezas piece, Proveedores provider, Suministra s) {
		piece.select("Ex6");
		provider.select("Ex6");
		s.select("Ex6");
	}

	public static void deleteData(Piezas piece, Proveedores provider, Suministra s) {
		s.delete();
		piece.delete();
		provider.delete();
	}
	
	public static void updateData(Piezas piece, Proveedores provider, Suministra s) {

		s.update();
		piece.update();
		provider.update();
	}
}
