package stillepost;

import java.util.Scanner;

public class Konsole {

	/**
	 * die Information fuer dieser Spiel eingeben,dann startet er
	 */
    public void starten() {

        int breite = frageNachZahl("Gib eine Breite (2 <= breite <= 1000) fuer das Spielfeld an: ", 2, 1000);
        int hoehe = frageNachZahl("Gib eine Hoehe (2 <= hoehe <= 1000) fuer das Spielfeld an: ", 2, 1000);
        int population = frageNachZahl("Gib die Groesse der Population an (2 <= population <= 10000): ", 2, 10000);
        int runden = frageNachZahl("Gib die Anzahl der Runden an (1 <= runden <= 2000): ", 1, 2000);

        StillePost stillePost = new StillePost(breite, hoehe, population, runden);
        Spieler.reset();

        if (!beenden()) {
            starten();
        }
    }

    /**
     * ob berecht das Programm ab
     * @return
     */
    public boolean beenden() {
        System.out.print("Gib 'nochmal' ein, um das Spiel erneut zu spielen oder irgendwas fuer Abbruch.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String str = sc.next();
            if (str.contains("nochmal")) {
                return false;
            }
        }
        return true;
    }

    /**
     * die beboetigen Indormationen eingeben
     * @param beschreibung
     * @param kleinsteZahl
     * @param groessteZahl
     * @return
     */
    public int frageNachZahl(String beschreibung, int kleinsteZahl, int groessteZahl) {
        boolean valid = false;
        int wert = 0;
        while (!valid) {
            System.out.print(beschreibung);
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int read = sc.nextInt();
                if (read >= kleinsteZahl && read <= groessteZahl) {
                    valid = true;
                    wert = read;
                }
            }
            if (!valid) {
                System.out.print("Deine Eingabe ist ungueltig!\n");
            }
        }
        return wert;
    }
}
