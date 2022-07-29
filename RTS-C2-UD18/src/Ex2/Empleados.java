package Ex2;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodosConexion.ConexionDB;

public class Empleados {

	private ConexionDB conexion = new ConexionDB();

	public void insert(String db) {
		String dni = JOptionPane.showInputDialog("Introduce el DNI del empleado (8 car�cteres)");
		dni = "'" + dni + "'";

		String name = JOptionPane.showInputDialog("Introduce un NOMBRE del empleado:");
		name = "'" + name + "'";

		String surname = JOptionPane.showInputDialog("Introduce un APELLIDO del empleado:");
		surname = "'" + surname + "'";

		String dep = JOptionPane.showInputDialog("Introduce un N�MERO de departamento:");

		conexion.MySQLConnection(db);
		conexion.insertData(db, "Empleados", "DNI, Nombre, Apellidos, Departamento", dni + ", " + name + ", " + surname + ", " + dep);
	}

	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Empleados");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI"));
				System.out.println("Nombre: " + resultSet.getString("Nombre"));
				System.out.println("Apellidos: " + resultSet.getString("Apellidos"));
				System.out.println("Departamento: " + resultSet.getString("Departamento"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del empleado: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Empleados", "DNI", id);
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del empleado que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO del empleado que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR del empleado que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Departamentos", campo2, campo, id, "DNI");
	}
}
