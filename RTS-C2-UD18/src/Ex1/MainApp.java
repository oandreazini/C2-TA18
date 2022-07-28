package Ex1;

public class MainApp {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void createInserts () {
		
		Fabricantes Fabr = new Fabricantes();
		
		Articulos Arti = new Articulos();
		
		for(int i=0; i<5; i++) {
			
			Fabr.insert("Ex1");
			
		}
		
		for(int i=0; i<5; i++) {
			Arti.insert("Ex1");
		}
		
		
	}

}
