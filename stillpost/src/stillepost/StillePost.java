package stillepost;

import java.util.HashSet;
import java.util.Random;

/**
 * Diese Klasse Repeasentiert den Koerper der Simulation,  sie initialisiert die Bevoelkerung und die Spielfeld objekte.
 * Ausserdem steuert sie den Ablauf
 */
public class StillePost {
    private int runde = 0;
    private HashSet<Spieler> population = new HashSet<Spieler>();
    private int rundenAnzahl;
    private Feld[][] spielFeld;

    private Berta berta;
    private Anton anton;
    private boolean bertaIstAhnungslos = true;

    /**
     * @param breite
     * @param hoehe
     * @param populationsGroesse
     * @param runden
     */
    public StillePost(int breite, int hoehe, int populationsGroesse, int runden) {

        this.spielFeld = new Feld[breite][hoehe];
        for (int x = 0; x < breite; x++) {
            for (int y = 0; y < hoehe; y++) {
                Koordinate koordinate = new Koordinate(x, y);
                this.spielFeld[x][y] = new Feld(koordinate);
            }
        }

        for (int x = 0; x < breite; x++) {
            for (int y = 0; y < hoehe; y++) {
                if (x > 0) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x - 1][y]);
                }
                if (x < spielFeld.length - 1) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x + 1][y]);
                }
                if (y > 0) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x][y - 1]);
                }
                if (y < spielFeld[0].length - 1) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x][y + 1]);
                }
            }
        }

        this.rundenAnzahl = runden;

        for (Integer n = 1; n <= populationsGroesse - 2; n++) {
            Random randomizer = new Random();
            int randomX = randomizer.nextInt(spielFeld.length);
            int randomY = randomizer.nextInt(spielFeld[0].length);
            Spieler spieler = new Spieler(spielFeld[randomX][randomY]);
            population.add(spieler);
            spielFeld[randomX][randomY].addPerson(spieler);
        }

        anton = new Anton(spielFeld[0][0]);
        berta = new Berta(spielFeld[spielFeld.length - 1][spielFeld[0].length - 1]);
        population.add(anton);
        population.add(berta);
        spielFeld[0][0].addPerson(anton);
        spielFeld[spielFeld.length - 1][spielFeld[0].length - 1].addPerson(berta);

        runde();
    }

    /**
     * diese Methode raepresentiert einen Zyklus, des Spiels, Meinung allerfelder Setzen, Personen bewegen, Ausgabe, Rekursion..
     */
    public void runde() {
        runde += 1;

        if (bertaIstAhnungslos) {
            if (berta.erfaehrtVomGeruecht()) {
                berta.setMeinung(Meinung.Berta);
                bertaIstAhnungslos = false;
            }

        }

        for (int x = 0; x < spielFeld.length; x++) {
            for (int y = 0; y < spielFeld[0].length; y++) {
                spielFeld[x][y].meinungBilden();
            }
        }

        for (Spieler n : population) {
        	n.begeben();
        }

        double antonProzent = 100.0 / population.size() * 1.0 * Spieler.antonAnhaenger;
        double bertaProzent = 100.0 / population.size() * Spieler.bertaAnhaenger;
        double neutralProzent = 100.0 / population.size() * Spieler.neutralAnhaenger;
        // System.out.println("Runde " + runde + ": Anton: " + antonProzent + "%, Berta: " + bertaProzent + "%, Neutral: " + neutralProzent +"%");

        System.out.print("Runde: " + runde);
        System.out.printf(" Anton: %2.2f", antonProzent);
        System.out.print("%");
        System.out.printf(" Berta: %2.2f", bertaProzent);
        System.out.print("%");
        System.out.printf(" Neutral: %2.2f", neutralProzent);
        System.out.println("%");


        // System.out.println("Runde " + runde + ": Anton: " + Spieler.antonAnhaenger + ", Berta: " + Spieler.bertaAnhaenger + ", Neutral: " + Spieler.neutralAnhaenger);

        if (runde < rundenAnzahl) {
            runde();
        }
    }

}
