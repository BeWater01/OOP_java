package stillepost;

/**
 * Die Anton Klasse Erbt von der Personen Klasse
 */
public class Anton extends Spieler {
    public Anton(Feld feld) {
        super(feld);
        super.setMeinung(Meinung.Anton);
    }

    /**
     * Die Methode ändert die Meinung nicht mehr.
     */
    @Override
    public void setMeinung(Meinung meinung) {
    }
}
