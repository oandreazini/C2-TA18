package Ex5;


public class MainApp {

	public static void main(String[] args) {

		createInserts();
	}

	public static void createInserts () {

		Despachos des = new Despachos();

		Directores dir = new Directores();


		for(int i=0; i<5; i++) {
			des.insert("Ex5");
		}
		for(int i=0; i<5; i++) {
			dir.insert("Ex5");
		}
	}
}


