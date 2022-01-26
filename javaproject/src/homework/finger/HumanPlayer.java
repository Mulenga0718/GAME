package homework.finger;

import java.util.Scanner;

public class HumanPlayer extends Player {
	int money;
	
	 Scanner sc = new Scanner(System.in);
	
	public int nextHand() {
		do {
			System.out.println("가위바위보!!!(0).가위/(1).바위/(2).보");
			hand = sc.nextInt();
		}while(hand<0||hand>2);
		return hand;
	}

}
