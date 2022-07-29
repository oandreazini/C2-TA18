package Ex8;

import Ex2.Departamentos;
import Ex2.Empleados;
import metodosConexion.ConexionDB;

public class MainApp {

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB("Ex8");
		Cajeros c = new Cajeros();
		Maquinas_Registradoras mr = new Maquinas_Registradoras();
		Productos p = new Productos();
		Venta v = new Venta();
		createTables(conexionDB);

		createInserts(c, mr, p, v);
		printValues(c, mr, p, v);
		deleteData(c, mr, p, v);
		printValues(c, mr, p, v);
		updateData(c, mr, p, v);
	}

	public static void createTables(ConexionDB con) {
		con.createTable("Ex8", "Cajeros", "Codigo int auto_increment, NomApels VARCHAR(255), primary key(Codigo)");
		con.createTable("Ex8", "Maquinas_Registradoras", "Codigo int auto_increment, Piso int, primary key(Codigo)");
		con.createTable("Ex8", "Productos", "Codigo int auto_increment, Nombre VARCHAR(100), Precio int, primary key(Codigo)");
		con.createTable("Ex8", "Venta", "Cajero int, Maquina int, Producto int, "
				+ "CONSTRAINT FK_VenCaja FOREIGN KEY (Cajero) REFERENCES Cajeros(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_VenMaqui FOREIGN KEY (Maquina) REFERENCES Maquinas_Registradoras(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_VenProductos FOREIGN KEY (Producto) REFERENCES Productos(Codigo) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "PRIMARY KEY (Cajero, Maquina, Producto)");
	}
	
	public static void createInserts (Cajeros c, Maquinas_Registradoras mr, Productos p, Venta v) {

		for(int i=0; i<5; i++) {
			c.insert("Ex8");
		}
		for(int i=0; i<5; i++) {
			mr.insert("Ex8");
		}
		for(int i=0; i<5; i++) {
			p.insert("Ex8");
		}
		for(int i=0; i<5; i++) {
			v.insert("Ex8");
		}
	}
	
	public static void printValues(Cajeros c, Maquinas_Registradoras mr, Productos p, Venta v) {
		c.select("Ex8");
		mr.select("Ex8");
		p.select("Ex8");
		v.select("Ex8");
	}

	public static void deleteData(Cajeros c, Maquinas_Registradoras mr, Productos p, Venta v) {
		v.delete();
		p.delete();
		mr.delete();
		c.delete();
	}
	
	public static void updateData(Cajeros c, Maquinas_Registradoras mr, Productos p, Venta v) {

		c.update();
		mr.update();
		p.update();
		v.update();
	}
}
