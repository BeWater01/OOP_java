package nimspiel;

import java.util.ArrayList;
/**
 * diese Klasse simuliert einen Nim-Spiel
 * @author 30869
 *
 */
public class Nimspiel {

	private ArrayList<Spieler> spielerList;
	private int spielrund;
	private Steinhaufen steinhaufen;
	private String regeln = "Regeln:1.Jeder Spieler nimmmt im Wechsel 1 bis 3 Steine+\r\n"
							+ "       2.Verloren hat der Spieler,der den letzten Stein nehmen muss";
	
	Konsole konsole = new Konsole();
	
	/**
	 * Initialisierung vom Spiel,naemlich die Namen der 2 Spieler eingeben und ein Steinhaufen erzeugen
	 */
	public void initialisieren() {
		String name1 = konsole.nameEingeben();
		Spieler spieler1 = new Spieler(name1);
		String name2 = konsole.nameEingeben();
		Spieler spieler2 = new Spieler(name2);
		
		spielerList = new ArrayList<Spieler>();
		spielerList.add(spieler1);
		spielerList.add(spieler2);	
		
		steinhaufen = new Steinhaufen();
	}
	
	/**
	 * der Spiel beginnt und laeuft bis der Gewinner geschieht
	 */
	public void getGewinner() {
		//die Regeln anzeigen
		System.out.println(regeln);
		//ein zufaelliger Index von 2 Spieler bekommen
		int dran = (int)(Math.random()*2);
		spielrund = 0;
		int vorhandenStein = steinhaufen.getAnzahl();
		//notieren den Name des StartSpieleres, um die SpielRund abzuzaehlen
		String startSpielerName = spielerList.get((dran + 1)%2).getName();
		System.out.println("Insgesamt "+vorhandenStein+" Steine im Steinhaufen.");
		System.out.println();
		int genommen;
		do {
			Spieler dranSpieler = spielerList.get((dran + 1)%2);
			
			//falls der Name des dranSpieleres und der Name des StartSpieleres, addiert die SpielRund sich
			//notieren die Anzahl,die der Spieler genommen hat		
			//notieren die Anzahl der vorhandenen Steine
			if (vorhandenStein>=3) {
				if (dranSpieler.getName().equals(startSpielerName)) {
					System.out.println("die.."+(++spielrund)+"..Rund");
					System.out.println();
				}
				System.out.println(dranSpieler.getName()+" : ");
				genommen = konsole.steinAnzahlEingeben();
				System.out.println(dranSpieler.getName()+".hat.."+genommen+"..Steine genommen.");
				vorhandenStein = vorhandenStein - genommen;
				System.out.println("noch.."+vorhandenStein+"..vorhandenen Steine im Steinhaufen.");
			}
			else if (vorhandenStein == 2) {
				if (dranSpieler.getName().equals(startSpielerName)) {
					System.out.println("die.."+(++spielrund)+"..Rund");
					System.out.println();
				}
				System.out.println(dranSpieler.getName()+" : ");
				genommen = konsole.keinerAlsZwei();
				System.out.println(dranSpieler.getName()+".hat.."+genommen+"..Steine genommen.");
				vorhandenStein = vorhandenStein - genommen;
				System.out.println("noch.."+vorhandenStein+"..vorhandenen Steine im Steinhaufen.");
			}
			else if(vorhandenStein==1){
				if (dranSpieler.getName().equals(startSpielerName)) {
					System.out.println("die.."+(++spielrund)+"..Rund");
					System.out.println();
				}
				System.out.println(dranSpieler.getName()+" : ");
				genommen = konsole.kleinerAlsEin();
				vorhandenStein = vorhandenStein - genommen;
				System.out.println(dranSpieler.getName()+" nimmt den letzten Stein ");
			}
			System.out.println();
			dran++;
			if (vorhandenStein ==0) {
				System.out.println(dranSpieler.getName()+" hat verloren");
				System.out.println(spielerList.get((dran+1)%2).getName()+" ist Gewinner");
			}
		}while(vorhandenStein>0);
	}
	
	/**
	 * enscheiden,ob neues Spiel wuenschen
	 */
	public void neuesSpiel() {
		try {
				String quit = "";
			do {
				System.out.println("neues Spiel? yes or no");
				quit = konsole.abbrechen();
				if (quit.equalsIgnoreCase("yes")) {
					Nimspiel spiel = new Nimspiel();
					spiel.initialisieren();
					spiel.getGewinner();
					spiel.neuesSpiel();
				}
				else if (quit.equalsIgnoreCase("no")) 
					System.exit(0);
			} while(!quit.equalsIgnoreCase("no") ||!quit.equalsIgnoreCase("yes"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
