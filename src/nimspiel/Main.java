package nimspiel;

/**
 * fuehrt das Programm durch
 * @author 30869
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Spiel Object erzeugen und seine Method aufrufen
		Nimspiel spiel = new Nimspiel();
		spiel.initialisieren();
		spiel.getGewinner();
		spiel.neuesSpiel();	
//		for (int i=0;i<10;i++) {
//			
//			System.out.println((-1 + (int)(Math.random()*3)));
//		}
	}

}
