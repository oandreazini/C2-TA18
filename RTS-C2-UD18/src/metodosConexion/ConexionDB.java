package metodosConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
	
	private Connection c;
	
	public void openConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://192.168.1.55:3309","root","PASSWORD");
			
			System.out.println("Server Connected");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}

	public void MySQLConnection(String user, String pass, String db) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://192.168.1.55:3309/" + db , user, pass);
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}
	
	public void closeConnection() {
		
			try {
				c.close();
				System.out.println("Se ha finalizado la conexión con el servidor");
				
			} catch (SQLException e) {
				//Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("No se ha podido cerrar la conexión con mi base de datos");
				System.out.println(e);
			}
	}
	
	
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE " + name;
			Statement st = c.createStatement();
			st.executeUpdate(Query);
			closeConnection();
			MySQLConnection("root", "", name);
			System.out.println("Se ha creado la base de datos " + name + " de forma exitosa.");
		} catch (SQLException ex) {
			Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	public void createTable(String db, String name, String campos) {
		try{
			String Querydb = "USE " + db + ";";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + "(" + campos + ");";
			Statement st = c.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("Error creando tabla.");
		}
	}
	
}
