package metodosConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
	
	private String pass = ".";
	private String user = "root";
	private Connection c;
	
	
	public ConexionDB() {
	}
	
	public ConexionDB(String db) {
		openConnection();
		
		createDB(db);
	}

	public void openConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://192.168.1.58:3306",user,pass);
			
			System.out.println("Server Connected");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}

	public void MySQLConnection(String db) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://192.168.1.58:3306/" + db , user, pass);
			
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
			String DeleteDb= "DROP DATABASE IF EXISTS " + name;
			String Query = "CREATE DATABASE " + name;
			Statement st = c.createStatement();
			st.executeUpdate(DeleteDb);
			st.executeUpdate(Query);
			closeConnection();
			MySQLConnection(name);
			System.out.println("Se ha creado la base de datos " + name + " de forma exitosa.");
		} catch (SQLException e) {
			Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
	public void createTable(String db, String name, String fields) {
		try{
			String DeleteDb= "DROP TABLE IF EXISTS " + name;
			String Querydb = "USE " + db + ";";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(DeleteDb);
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + "(" + fields + ");";
			Statement st = c.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("Error creando tabla.");
		}
	}
	
	public void insertData(String db, String table_name, String fields, String values) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(" + fields + ") values(" + values +");";
			Statement st = c.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el almacenamiento");
		}
	}

	public ResultSet getValues(String db, String table_name) {
		try {
			String Querydb = "USE "+db+",";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name + ";";
			
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			return resultSet;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()); System.out.println("Error en la adquisicion de datos");
		}
		return null;
	}
	
	public void deleteRecord(String table_name, String field, String ID) {
		
		try {
			String Query = "DELETE FROM " + table_name + " WHERE " + field + " = \"" + ID + "\"";
			Statement st = c.createStatement();
			st.executeUpdate(Query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}