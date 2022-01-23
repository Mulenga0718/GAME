package game;

import java.util.Scanner;

public class FingerFlashing {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HumanPlayer hp = new HumanPlayer();
	ComputerPlayer cp = new ComputerPlayer();
	String[] hands = {"가위","바위","보"};
	
	int retry;
	do {
		int comp = cp.nextHand();
		int user = hp.nextHand();
		System.out.println("나는" +hands[comp]+"이고, 당신은"+hands[user]+"입니다.");
		
		int judge = (user - comp+3)%3;
		switch(judge) {
		case 0: System.out.println("비겼습니다"); break;
		case 1: System.out.println("당신이 졌습니다."); break;
		case 2: System.out.println("당신이 이겼습니다."); break;
		}
		
		do {
			System.out.print("다시 한번? (1)아니오 (2)네");
			retry = sc.nextInt();
		}while(retry !=1 && retry !=2);
		}while(retry ==2);
	
}
}
