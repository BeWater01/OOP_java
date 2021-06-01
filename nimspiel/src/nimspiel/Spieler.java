package nimspiel;

/**
 * diese Klasse beschreibt die Attribute und Methoden,die ein Spieler haben soll
 * @author 30869
 *
 */
public class Spieler {

	private String name;
	/**
	 * Konstruktor von Spieler ,dass mit Name zur Erzeugung
	 * @param name
	 */
	Spieler(String name){
		this.name = name;
	}
	
	/**
	 * der Name des Spieleres bekommen
	 * @return der Name des Spieleres
	 */
	public String getName() {
		return name;
	}

}
