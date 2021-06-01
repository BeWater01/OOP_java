package nimspiel;

/**
 * diese Klasse beschreibt die Attribute und Methoden,die ein Steinhaufen haben soll
 * @author 30869
 *
 */
public class Steinhaufen {

	private int anzahl;
	private int vorhanden;
	
	/**
	 * Konstruktor von Steinhaufen,dass mit einer Anzahl der Steine zur Erzeugung
	 */
	Steinhaufen(){
		this.anzahl = 20+(int)(Math.random()*11);
	}
	
	/**
	 * mit dieser Methdon, die Anzal der vorhandenen Steine zu bekommen
	 * @return die Anzahl der vorhandenen Steine
	 */
	public int getVorhanden() {
		return vorhanden;
	}
	
	/**
	 * mit dieser Methdon, die insgesamt Anzal der Steine im SteinHaufen zu bekommen
	 * @return die gesamte SteinAnzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}
}
