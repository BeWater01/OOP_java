package diamantenmine;

import java.util.Scanner;

/**
 * durch die Konsole die benoetige Informationen einzugeben
 */
public class Konsole {

	/**
	 * waehlen die Nummer fuer Prospektorenplan aus
	 * 
	 * @return PlanNummer int
	 */
	// 选择一个藏宝图，然后开始执行程序
	public int planWaehlen() {
		System.out.println("Bitte waehlen Sie einen Prospektorenplan(1-3) aus:");
		int plan = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				plan = sc.nextInt();
				if (plan >= 1 && plan <= 3)
					return plan;
				else
					throw new RuntimeException();
			} catch (Exception e) {
				System.out.println("Bitte Ganzzahl 1-3 eingeben!");
			}
		}
	}
}
