package diamantenmine;

import java.util.HashMap;
import java.util.Map;
/**
 * diese Klasse beschreibt die Attributten und set-//get-Methoden
 * @author 30869
 *
 */
public class Diamanten {

	private int x;
	private int y;
	private Map<Feld,String> randMap;
	private Map<Diamanten,String> diamantenMap;


	/**
	 * konstruktor
	 * @param x Koordinate in X-Achse
	 * @param y Koordinate in Y-Achse
	 */
	Diamanten(int x,int y){
		this.x = x;
		this.y = y;
		randMap = new HashMap<Feld,String>();
		diamantenMap = new HashMap<Diamanten,String>();
	}
	
	public void setDiamantenMap(Map<Diamanten, String> diamantenMap) {
		this.diamantenMap = diamantenMap;
	}

	public Map<Feld,String> getRandMap() {
		return randMap;
	}

	public Map<Diamanten,String> getDiamantenMap() {
		return diamantenMap;
	}
	/**
	 * die Distanz zwischen zwei Punkte berechnen
	 * @param xR x-Koordinate vom zweiten Punkt
	 * @param yR y-Koordinate vom zweiten Punkt
	 * @return die Distanz
	 */
	//计算距离
	public int abstandBerechnen(int xR,int yR) {
		return Math.abs(x-xR)+Math.abs(y-yR);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
