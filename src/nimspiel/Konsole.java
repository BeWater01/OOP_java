package nimspiel;

import java.util.Scanner;

/**
 * durch Konsole die benoetige Informationen eingeben
 * @author 30869
 *
 */
public class Konsole {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * durch die Konsole, die Namen der Spieler einzugeben
	 * @return der Name,der eingegeben wird
	 */
	public String nameEingeben() {
		System.out.println("Bitte geben Sie Name ein!");
		String name = sc.nextLine();
		return name;
	}
	
	/**
	 * durch die Konsole,die genommmene Anzahl einzugeben
	 * @return die Anzahl der genommenen Steine
	 */
	public int steinAnzahlEingeben() {
		int anzahl = 0;
		try {
			do {
				System.out.println("Bitte nehmen Sie 1-3 Steine .");
				if (sc.hasNextInt())
					anzahl = sc.nextInt();
			}while(anzahl<=0 ||anzahl>=4 );
		} catch (Exception e) {
			steinAnzahlEingeben();
		}
		return anzahl;	
	}
	
	/**
	 * durch die Konsole, ob das Programm abbricht,zu entscheiden
	 * @return yes or no
	 */
	public String abbrechen() {
		String str = sc.next();
		return str;
	}
	
	public int keinerAlsZwei() {
		int anzahl = 0;
		try {
			do {
				System.out.println("Bitte nehmen Sie nur 1-2 Steine .");
				if (sc.hasNextInt())
					anzahl = sc.nextInt();
			}while(anzahl<=0 ||anzahl>=3 );
		} catch (Exception e) {
			keinerAlsZwei();
		}
		return anzahl;	
	}
	
	public int kleinerAlsEin() {
		int anzahl = 0;
		try {
			do {
				System.out.println("Bitte nehmen Sie nur 1 Steine .");
				if (sc.hasNextInt())
					anzahl = sc.nextInt();
			}while(anzahl<=0 ||anzahl>=2 );
		} catch (Exception e) {
			kleinerAlsEin();
		}
		return anzahl;
	}
}
