package Ex9;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metodosConexion.ConexionDB;

public class Reserva {
	//Creamos la conexion a la DB
	private ConexionDB conexion = new ConexionDB();

	//Metodo para insertar registros a la tabla
	public void insert(String db) {
		String dni = JOptionPane.showInputDialog("Introduce el DNI dela reserva:");
		dni = "'"+dni+"'";
		String numSerie = JOptionPane.showInputDialog("Introduce el NUMERO DE SERIE dela reserva:");
		numSerie = "'"+numSerie+"'";
		String comienzo = JOptionPane.showInputDialog("Introduce un COMIENZO de la reserva:");
		comienzo = "'"+comienzo+"'";
		String fin = JOptionPane.showInputDialog("Introduce un FIN de la reserva:");
		fin = "'"+fin+"'";


		conexion.MySQLConnection(db);
		conexion.insertData(db, "Reserva", "DNI, NumSerie, Comiezo, Fin", dni +", " + numSerie + ", " + comienzo+ ", " + fin);
	}

	//Metodo para imprimir los registros
	public void select(String db) {

		java.sql.ResultSet resultSet  = conexion.getValues(db, "Reserva");

		try {
			while(resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI"));
				System.out.println("NumSerie: " + resultSet.getString("NumSerie"));
				System.out.println("Comienzo: " + resultSet.getString("Comienzo"));
				System.out.println("Fin: " + resultSet.getString("Fin"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	//Metodo para eliminar registros
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNI del investigador: ");
		String id = sc.next();

		sc.close();

		conexion.deleteRecord("Reserva", "DNI", id);
	}

	//Metodo para actualizar los valores de los registros
	public void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el DNIinvestigador de la reserva que quieres modificar: ");
		String id = sc.next();
		System.out.println("Introduce el CAMPO de reserva que quieres modificar: ");
		String campo = sc.next();
		System.out.println("Introduce el NUEVO VALOR de reserva que quieres modificar: ");
		String campo2 = sc.next();

		sc.close();

		conexion.updateData("Reserva", campo, campo2, id, "DNI");
	}
}
