package homework;

import java.util.Scanner;

import homework.finger.GamblePlay;
import homework.sudoku.Sdoku;
import homework.whois.Whois;

public class PlayGame {
	static Whois whois = new Whois();
	static GamblePlay fingerFlash = new GamblePlay();
	static Sdoku sdoku = new Sdoku();

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("🎮미니게임 천국에 오신 걸 환영합니다.");
		int choice;
		do {
			System.out.println("게임을 선택해주세요. 1.WHAT IS ❓  2.학교앞 가위바위보🎰 3.스도쿠🧩 ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				whois.main(args);
				break;
			case 2:
				fingerFlash.main(args);
				break;
			case 3:
				sdoku.main(args);
			}
		} while (choice != 0);
	}
}