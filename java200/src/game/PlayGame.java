package game;

import java.util.Scanner;

public class PlayGame {
	static Whois whois = new Whois();
	static FingerFlashing fingerFlashing = new FingerFlashing();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("미니게임 천국에 오신 걸 환영합니다.");
		int choice;
		do {
			System.out.println("게임을 선택해주세요. 1.열고개 2.가위바위보 3.스도쿠");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				whois.main(args);
				break;
			case 2:
				fingerFlashing.main(args);
				break;

			}

		} while (choice != 0);
	}
}
