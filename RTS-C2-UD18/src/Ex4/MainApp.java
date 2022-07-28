package Ex4;

public class MainApp {

	public static void main(String[] args) {
		createInserts();
	}
	
	public static void createInserts () {

		Salas s = new Salas();
		Peliculas p = new Peliculas();

		for(int i=0; i<5; i++) {
			p.insert("Ex4");
		}
		for(int i=0; i<5; i++) {
			s.insert("Ex4");
		}
	}

}
