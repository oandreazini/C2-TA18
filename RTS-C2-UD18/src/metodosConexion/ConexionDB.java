package metodosConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	Connection c;
	
	public void abrirConexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3309","USER","PASSWORD");
			
			System.out.println("Server Connected");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}

	
	
	public void cerrarConexion() {
		
			try {
				c.close();
				System.out.println("Se ha finalizado la conexión con el servidor");
				
			} catch (SQLException e) {
				//Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("No se ha podido cerrar la conexión con mi base de datos");
				System.out.println(e);
			}
	}
	
	
}
