package Ex2;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Departamentos {

	private ConexionDB conexion = new ConexionDB();

	public void insert(String db) {
		String name = JOptionPane.showInputDialog("Introduce el NOMBRE de departamento");
		name = "'" + name + "'";

		String budget = JOptionPane.showInputDialog("Introduce un PRESUPUESTO del departamento:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Departamentos", "Nombre, Presupuesto", name + ", " + budget);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Departamentos");

		try {
			while(resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Presupuesto: " + resultSet.getString("Presupuesto"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el codigo del departamento: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Departamentos", "Codigo", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el CÓDIGO del departamento que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del departamento que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del departamento que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Departamentos", campo2, campo, id, "Codigo");
	}
}
