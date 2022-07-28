package Ex6;


public class MainApp {
	public static void main(String[] args) {
		createInserts();
	}

	public static void createInserts () {

		Piezas piece = new Piezas();
		Proveedores provider = new Proveedores();
		Suministra s = new Suministra();

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
}
