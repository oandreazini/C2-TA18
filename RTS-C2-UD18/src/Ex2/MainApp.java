package Ex2;

public class MainApp {

	public static void main(String[] args) {
		createInserts();

	}

	public static void createInserts () {

		Empleados e = new Empleados();
		Departamentos d = new Departamentos();

		for(int i=0; i<5; i++) {
			d.insert("Ex2");
		}
		for(int i=0; i<5; i++) {
			e.insert("Ex2");
		}
	}

}
