package Ex8;

public class MainApp {

	public static void main(String[] args) {
		createInserts();
	}

	public static void createInserts () {

		Cajeros c = new Cajeros();
		Maquinas_Registradoras mr = new Maquinas_Registradoras();
		Productos p = new Productos();
		Venta v = new Venta();

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
}
