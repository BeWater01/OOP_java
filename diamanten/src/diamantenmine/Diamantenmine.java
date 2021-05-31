package diamantenmine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.swing.JPanel;

/**
 * diese Klasse sucht die minimale Graubungsaufwand vom Prospektorenplan
 * 
 * @author 30869
 *
 */
public class Diamantenmine extends JPanel {

	private Prospektorenplan plan;
	private ArrayList<Diamanten> diamantenList;// 星星列表
	private ArrayList<Feld> feldList;// 区块列表
	private ArrayList<Feld> optialeWege = new ArrayList<Feld>();// 存储最佳路径

	private final int RECT_WIDTH = 40;
	private final int RECT_HEIGHT = 40;

	/**
	 * Konstruktor von Diamantenmine
	 */
	Diamantenmine() {
		plan = new Prospektorenplan();
		diamantenList = plan.getDiamantenList();
		feldList = plan.getFeldList();
	}

	/**
	 * mittel der rekusiven Method, um die kleinste Wege des Diamantes zum Rand zu
	 * berechnen
	 * 
	 * @param randMap
	 * @return kleinste Wege zum Rand
	 */
	// 找出每个钻石的到边上最短路径
	public Map<Feld, String> kleinsteWegeZumRand(Map<Feld, String> randMap) {
		Iterator<Feld> it = randMap.keySet().iterator();
		if (randMap.size() == 1) {
			return randMap;
		} else {
			Feld f1 = it.next();
			Feld f2 = it.next();
			String str1 = randMap.get(f1);
			String str2 = randMap.get(f2);
			int rand1 = Integer.parseInt(str1);
			int rand2 = Integer.parseInt(str2);
			if (rand1 > rand2)
				randMap.remove(f1);
			else
				randMap.remove(f2);
			return kleinsteWegeZumRand(randMap);
		}
	}

	/**
	 * mittel der rekusiven Method, um die kleinste Wege des Diamantes zu den andren
	 * Diamanten und seine Koordinate zu berechnen und in Map speichen
	 * 
	 * @param diamantenMap
	 * @return den kleinsten Abstand und die Koordinate
	 */
	// 计算钻石到其他钻石的最短路径
	public Map<Diamanten, String> kleinsteWegeZuDiamanten(Map<Diamanten, String> diamantenMap) {
		Iterator<Diamanten> it = diamantenMap.keySet().iterator();
		if (diamantenMap.size() == 1) {
			return diamantenMap;
		} else {
			Diamanten f1 = it.next();
			Diamanten f2 = it.next();
			String str1 = diamantenMap.get(f1);
			String str2 = diamantenMap.get(f2);
			int rand1 = Integer.parseInt(str1);
			int rand2 = Integer.parseInt(str2);
			if (rand1 > rand2)
				diamantenMap.remove(f1);
			else
				diamantenMap.remove(f2);
			return kleinsteWegeZuDiamanten(diamantenMap);
		}
	}

	/**
	 * die bewegete Wege vom Diamant nach Destination
	 * 
	 * @param d
	 *            Start Position vom Diamant
	 * @param f
	 *            End Position
	 */
	// 计算每个钻石的到目标地点行走最短路径的路线
	public void getWeg(Diamanten d, Feld f) {
		int dx = d.getX();
		int dy = d.getY();
		int fx = f.getX();
		int fy = f.getY();
		System.out.print("von:(" + dx + "," + dy + ")--->");
		addWeg(dx, dy);
		System.out.println("nach:(" + fx + "," + fy + ")");
		int distanz = diatanzberechnen(dx, dy, fx, fy);
		System.out.print("(" + dx + "," + dy + ")->");
		while ((dx != fx) || (dy != fy)) {
			if (dx != fx) {
				// 向上移动
				if (diatanzberechnen(dx - 1, dy, fx, fy) < distanz) {
					dx = dx - 1;
					distanz = diatanzberechnen(dx, dy, fx, fy);
					addWeg(dx, dy);
					System.out.print("(" + dx + "," + dy + ")->");
					continue;
				} else if (diatanzberechnen(dx + 1, dy, fx, fy) < distanz) {
					// 向下移动
					dx = dx + 1;
					distanz = diatanzberechnen(dx, dy, fx, fy);
					addWeg(dx, dy);
					System.out.print("(" + dx + "," + dy + ")->");
					continue;
				}
			} else if (dy != fy) {
				if (diatanzberechnen(dx, dy - 1, fx, fy) < distanz) {
					// 向左移动
					dy = dy - 1;
					distanz = diatanzberechnen(dx, dy, fx, fy);
					addWeg(dx, dy);
					System.out.print("(" + dx + "," + dy + ")->");
					continue;
				} else if (diatanzberechnen(dx, dy + 1, fx, fy) < distanz) {
					// 向右移动
					dy = dy + 1;
					distanz = diatanzberechnen(dx, dy, fx, fy);
					addWeg(dx, dy);
					System.out.print("(" + dx + "," + dy + ")->");
					continue;
				}
			}
		}
		System.out.println();
	}

	/**
	 * die minimale Weg auf die Konsole zeigen
	 * 
	 * @return
	 */
	// 获取最佳路径的集合，以便在图形上对其进行填充
	public void optimaleKombi() {
		int anzahl = optialeWege.size();
		System.out.println("minimale " + anzahl + " Graubungen noetig");
		Iterator<Feld> it = optialeWege.iterator();
		while (it.hasNext()) {
			Feld f = it.next();
			System.out.print("(" + f.getX() + "," + f.getY() + ") ");
		}
	}

	/**
	 * addiert den Feld in den optimalen Wege
	 * 
	 * @param x
	 *            x-Koordinate vom Feld
	 * @param y
	 *            y-Koordinate vom Feld
	 */
	// 将每个行走的路径添加到最佳路径的集合中
	public void addWeg(int x, int y) {
		for (Feld feld : feldList) {
			if ((feld.getX() == x) && (feld.getY() == y)) {
				if (!optialeWege.contains(feld))
					optialeWege.add(feld);
			}
		}
	}

	/**
	 * die Distanz von zwei Punkte berechnen
	 * 
	 * @param x
	 *            x-Koodinate vom 1.Punkt
	 * @param y
	 *            y-Koodinate vom 1.Punkt
	 * @param a
	 *            x-Koodinate vom 2.Punkt
	 * @param b
	 *            y-Koodinate vom 2.Punkt
	 * @return die Distanz
	 */
	// 计算两点之间的距离
	public int diatanzberechnen(int x, int y, int a, int b) {

		return Math.abs(x - a) + Math.abs(y - b);
	}

	/**
	 * finden die optimale GrubungenWege
	 */
	//// 找出最短路径的另外一种方法
	public void findPath() {
		try {
			while (!(diamantenList.size() == 1)) {
				Diamanten start = anfangDiamant();
				Diamanten folger = nachFolger(start);
				diamantenList.remove(start);
				while (!(folger == null) && diamantenList.contains(folger)) {
					diamantenList.remove(folger);
					folger = nachFolger(folger);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("minimale Wege gefunden！");
		}
	}

	/**
	 * findet NachfolgerDiamanten
	 * 
	 * @param dia
	 *            VorgangerDiamanten
	 * @return Nachfolger
	 */
	//// 找出距离（离边最近的星星）最近的星星，判断其到边的距离是否小于其到初始星星的距离
	public Diamanten nachFolger(Diamanten dia) {
		resetMap(dia);
		Map<Diamanten, String> diaMap = dia.getDiamantenMap();
		Map<Diamanten, String> kleinstDia = kleinsteWegeZuDiamanten(diaMap);
		Diamanten diamanten = kleinstDia.keySet().iterator().next();
		int abstand = Integer.parseInt(kleinstDia.get(diamanten));
		if (abstand <= getAbstandZumRand(diamanten)) {
			// 获取初始星星到这个追随星星的路径
			Feld feld = new Feld(diamanten.getX(), diamanten.getY());
			getWeg(dia, feld);
			return diamanten;// 如果该星星距离上一个星星的距离小于其到边上的距离，那么就与上一个星星相连接
		} else
			return null;// 否则就返回空值，说明其应该与边相连接，不能与上一个星星相连接
	}

	/**
	 * finden den StartDiamanten
	 * 
	 * @return startDiamanten
	 */
	//// 找出距离边最近的那颗星星，相当于他就是一个起点，其他最短路径的星星要与之相连
	public Diamanten anfangDiamant() {
		int min = 0;
		for (int i = 1; i < diamantenList.size(); i++) {
			if (getAbstandZumRand(diamantenList.get(i)) < getAbstandZumRand(diamantenList.get(0)))
				min = i;
			else
				continue;
		}
		// 获取初始星星到边的路线
		Diamanten diamant = diamantenList.get(min);
		Map<Feld, String> randMap = diamant.getRandMap();
		Map<Feld, String> kleinstRand = kleinsteWegeZumRand(randMap);
		Feld feld = kleinstRand.keySet().iterator().next();
		getWeg(diamant, feld);
		return diamant;
	}
/**
 * der kleisete Abstand vom Diamant zum Rand
 * @param dia Diamant
 * @return den Abstand
 */
	//// 计算星星到边的最小距离
	public int getAbstandZumRand(Diamanten dia) {
		Map<Feld, String> randMap = dia.getRandMap();
		Map<Feld, String> kleinstRand = kleinsteWegeZumRand(randMap);
		Feld feld = kleinstRand.keySet().iterator().next();
		int abstand = Integer.parseInt(kleinstRand.get(feld));
		return abstand;
	}
/**
 * reset DiamantenMap ausser die Diamanten,die schon Wege gefunden haben
 * @param dia
 */
	//// 重新计算删除星星后的每个星星的map
	public void resetMap(Diamanten dia) {
		int diamantenAnzahl = diamantenList.size();
		Map<Diamanten, String> newMap = new HashMap<Diamanten, String>();
		for (int i = 0; i < diamantenAnzahl; i++) {
			if ((diamantenList.get(i).getX() == dia.getX()) && (diamantenList.get(i).getY() == dia.getY()))
				continue;
			else {
				int diamantenAbstand = dia.abstandBerechnen(diamantenList.get(i).getX(), diamantenList.get(i).getY());
				newMap.put(diamantenList.get(i), diamantenAbstand + "");
			}
		}
		dia.setDiamantenMap(newMap);
	}

	/**
	 * Graubungplan malen
	 */

	public void paint(Graphics g) {
		super.paint(g);
		try {
			ArrayList<Diamanten> diaList = new ArrayList<Diamanten>();
			diaList.addAll(diamantenList);
			findPath();
			optimaleKombi();
			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < feldList.size(); i++) {
				drawRect2(g2, feldList.get(i).getX(), feldList.get(i).getY());
			}
			for (int i = 0; i < diaList.size(); i++) {
				drawCircle(g2, diaList.get(i).getY(), diaList.get(i).getX());
			}
			for (int i = 0; i < optialeWege.size(); i++) {
				fillRect(g2, optialeWege.get(i).getX(), optialeWege.get(i).getY());
			}
			for (int i = 0; i < feldList.size(); i++) {
				drawRect(g2, feldList.get(i).getX(), feldList.get(i).getY());
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * Recteck malen
	 * 
	 * @param g2
	 * @param i
	 * @param j
	 */
	public void drawRect(Graphics2D g2, int i, int j) {// 画结果图
		g2.draw(new Rectangle2D.Double(40 * j + 800, 40 * i, RECT_WIDTH, RECT_HEIGHT));
	}

	/**
	 * Recteck fuellen
	 * 
	 * @param g2
	 * @param i
	 * @param j
	 */
	public void fillRect(Graphics2D g2, int i, int j) {// 画结果图
		g2.fill(new Rectangle2D.Double(40 * j + 800, 40 * i, RECT_WIDTH, RECT_HEIGHT));
	}

	/**
	 * einen Kreis malen
	 * 
	 * @param g2
	 * @param i
	 * @param j
	 */
	public void drawCircle(Graphics2D g2, int i, int j) {// 画初始图
		g2.draw(new Ellipse2D.Double(40 * i, 40 * j, RECT_WIDTH, RECT_HEIGHT));
	}

	/**
	 * Recteck malen
	 * 
	 * @param g2
	 * @param i
	 * @param j
	 */
	public void drawRect2(Graphics2D g2, int i, int j) {// 话初始图
		g2.draw(new Rectangle2D.Double(40 * j, 40 * i, RECT_WIDTH, RECT_HEIGHT));
	}

}
