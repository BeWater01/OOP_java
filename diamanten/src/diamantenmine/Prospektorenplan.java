package diamantenmine;

import java.util.ArrayList;

/**
 * diese Klasse ist fuer die Initialisierung von den Prospektorenplanen und
 * beschribt ihre Attributen und Methoden
 * 
 * @author 30869
 *
 */
public class Prospektorenplan {

	private ArrayList<Feld> feldList;
	private ArrayList<Diamanten> diamantenList;
	private Konsole k = new Konsole();

	/**
	 * Konstruktor Method um den Prospektorenplan zu malen und alle benoetige
	 * Informationen initialisieren
	 */
	Prospektorenplan() {
		feldList = new ArrayList<Feld>();
		diamantenList = new ArrayList<Diamanten>();
		planInit();
	}

	/**
	 * die Initialisierug des Prospektorenplanes
	 */
	public void planInit() {
		switch (k.planWaehlen()) {
		case 1: 
			feldInit_1();
			diamantenInit_1();
			abstandZumRand();
			abstandZumDiamanten();
			break;
		case 2:
			feldInit_2();
			diamantenInit_2();
			abstandZumRand();
			abstandZumDiamanten();
			break;
		case 3:
			feldInit_3();
			diamantenInit_3();
			abstandZumRand();
			abstandZumDiamanten();
			break;
		}
	}

	/**
	 * die FeldInitialisierung des 1.Planes
	 */
	// 第一张藏宝图—————— 初始化化区块位置
	public void feldInit_1() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == 1 && j == 2) {
					Feld feld = new Feld(1, 2);
					feldList.add(feld);
				} else if (i == 2 && j <= 4)
					feldList.add(new Feld(i, j));
				else if (i == 3 && j <= 6)
					feldList.add(new Feld(i, j));
				else if (i == 4 && j <= 7)
					feldList.add(new Feld(i, j));
				else if (i == 5 && j >= 2)
					feldList.add(new Feld(i, j));
				else if (i == 6 && j >= 3)
					feldList.add(new Feld(i, j));
				else if (i == 7 && j >= 3)
					feldList.add(new Feld(i, j));
				else if (i == 8 && (j >= 3 && j <= 8))
					feldList.add(new Feld(i, j));
				else if (i == 9 && (j >= 4 && j <= 6))
					feldList.add(new Feld(i, j));
			}
		}
	}

	/**
	 * die DiamantenInitialisierung des 1.planes
	 */
	// 第一张藏宝图 ——————初始化钻石位置
	public void diamantenInit_1() {
		diamantenList.add(new Diamanten(3, 2));
		diamantenList.add(new Diamanten(4, 3));
		diamantenList.add(new Diamanten(5, 6));
		diamantenList.add(new Diamanten(6, 7));
		diamantenList.add(new Diamanten(6, 8));
		diamantenList.add(new Diamanten(8, 5));
		// diamantenList.add(new Diamanten(8, 4));
	}

	/**
	 * die FeldInitialisierung des 2.planes
	 */
	// 第二张藏宝图——————区域初始化
	public void feldInit_2() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 14; j++) {
				if (i == 1 && (j >= 7 && j <= 11))
					feldList.add(new Feld(i, j));
				else if (i == 2 && (j >= 5 && j <= 13))
					feldList.add(new Feld(i, j));
				else if (i == 3 && (j >= 4))
					feldList.add(new Feld(i, j));
				else if (i == 4 && (j >= 3 && j <= 13))
					feldList.add(new Feld(i, j));
				else if (i == 5 && (j >= 2))
					feldList.add(new Feld(i, j));
				else if (i == 6 && (j <= 13))
					feldList.add(new Feld(i, j));
				else if (i == 7 && (j <= 11))
					feldList.add(new Feld(i, j));
				else if (i == 8 && (j >= 2 && j <= 11))
					feldList.add(new Feld(i, j));
				else if (i == 9 && (j >= 3 && j <= 10))
					feldList.add(new Feld(i, j));
			}
		}
	}

	/**
	 * die DiamantenInitialisierung des 2,planes
	 */
	// 第二张藏宝图——————钻石初始化
	public void diamantenInit_2() {
		diamantenList.add(new Diamanten(4, 8));
		diamantenList.add(new Diamanten(4, 11));
		diamantenList.add(new Diamanten(6, 8));
		diamantenList.add(new Diamanten(7, 4));
		diamantenList.add(new Diamanten(7, 5));
	}

	/**
	 * die FeldInitialisierung des 3.Planes
	 */
	// 第三张藏宝图——————区域初始化
	public void feldInit_3() {

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (i==1&&j==8)
					feldList.add(new Feld(1,8));
				else if (i==2&&(j>=6&&j<=8))
					feldList.add(new Feld(i,j));
				else if (i==3&&(j>=4&&j<=8))
					feldList.add(new Feld(i,j));
				else if (i==4&&(j>=2&&j<=8))
					feldList.add(new Feld(i,j));
				else if (i==5||i==6)
					feldList.add(new Feld(i,j));
				else if (i==7&&(j>=3&&j<=7))
					feldList.add(new Feld(i,j));
				else if (i==8&&(j<=6&&j>=4))
					feldList.add(new Feld(i,j));
			}
		}
	}

	/**
	 * die DiamantenInitialisierung des 3.Planes
	 */
	// 第三张藏宝图——————钻石初始化
	public void diamantenInit_3() {

		diamantenList.add(new Diamanten(3,7));
		diamantenList.add(new Diamanten(4,6));
		diamantenList.add(new Diamanten(5,2));
		diamantenList.add(new Diamanten(5,4));
		diamantenList.add(new Diamanten(7,5));
		diamantenList.add(new Diamanten(7,6));
	}

	/**
	 * Abstand zu den 4 Randen berechen und in seinem Map speichern
	 */
	// 计算钻石到边的距离，并存储在其Map集合中
	public void abstandZumRand() {
		// 获取钻石的数量
		int diamantenAnzahl = diamantenList.size();
		// 获取钻石到每边的距离，并存储到其map中
		for (int i = 0; i < diamantenAnzahl; i++) {
			Diamanten d = diamantenList.get(i);
			ArrayList<Feld> randList = new ArrayList<Feld>();
			// 获取距离上边和下边的距离
			for (int j = 0; j < feldList.size(); j++) {
				Feld feld = feldList.get(j);
				if (d.getY() == feld.getY()) {
					randList.add(feld);
				} else
					continue;
			}
			abstandZumRand_u1(d, randList, 0);
			int verkSize = randList.size() - 1;
			abstandZumRand_u1(d, randList, verkSize);
			randList.clear();
			// 计算距离左右两边的距离
			for (int j = 0; j < feldList.size(); j++) {
				Feld feld = feldList.get(j);
				if (d.getX() == feld.getX())
					randList.add(feld);
				else
					continue;
			}
			abstandZumRand_u1(d, randList, 0);
			int horSize = randList.size() - 1;
			abstandZumRand_u1(d, randList, horSize);
			randList.clear();
		}

	}

	/**
	 * dient fuer abstandZumRand-Method
	 * 
	 * @param d
	 * @param randList
	 * @param position
	 */
	// 为了提高代码复用性，对上面的计算钻石到四边的代码进行优化
	public void abstandZumRand_u1(Diamanten d, ArrayList<Feld> randList, int position) {
		// 计算距离
		int abstand = d.abstandBerechnen(randList.get(position).getX(), randList.get(position).getY());
		// 将其距离以及相应的区块存储到Map集合中
		d.getRandMap().put(randList.get(position), abstand + "");
	}

	/**
	 * Abstand zu den anderen Diamanten berechnen und in seimen Map speichern
	 */
	// 计算钻石到钻石之间的距离，并存储在其Map集合中
	public void abstandZumDiamanten() {
		int diamantenAnzahl = diamantenList.size();

		for (int i = 0; i < diamantenAnzahl; i++) {
			Diamanten d = diamantenList.get(i);
			for (int j = 0; j < diamantenAnzahl; j++) {
				if (i == j)
					continue;
				int diamantenAbstand = d.abstandBerechnen(diamantenList.get(j).getX(), diamantenList.get(j).getY());
				d.getDiamantenMap().put(diamantenList.get(j), diamantenAbstand + "");

			}
		}
	}

	/**
	 * die Quadrat im Prospektorenplan als ArrayList zurueckgeben
	 * 
	 * @return feldList ArrayList<Feld>
	 */
	public ArrayList<Feld> getFeldList() {
		return feldList;
	}

	/**
	 * die Diamanten im Prospektorenplan als ArrayList zurueckgeben
	 * 
	 * @return diamantenList ArrayList<Diamanten>
	 */
	public ArrayList<Diamanten> getDiamantenList() {
		return diamantenList;
	}
}
