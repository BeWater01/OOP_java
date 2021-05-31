package diamantenmine;

/**
 * diese Klasse beschribt die Attribute und Methoden von den Felden in den
 * Prospektorenplanen
 * 
 * @author 30869
 *
 */
public class Feld {

	private int x;
	private int y;

	/**
	 * Feld Konstruktor
	 * 
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 */
	public Feld(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
