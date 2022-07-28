package Ex7;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createInserts();
	}
	
	public static void createInserts () {

		Cientificos c = new Cientificos();
		Proyecto p = new Proyecto();
		AsignadoA a = new AsignadoA();

		for(int i=0; i<5; i++) {
			c.insert("Ex7");
		}
		for(int i=0; i<5; i++) {
			p.insert("Ex7");
		}
		for(int i=0; i<5; i++) {
			a.insert("Ex7");
		}
		
	}

}
