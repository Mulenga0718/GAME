package homework.whois;

import java.util.Random;
import java.util.Scanner;

import homework.sudoku.ScanUtil;

public class Whois {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int answer;

		People[] people = new People[2];
		people[0] = new Ujeaseok();
		people[1] = new Iu();
		Animal[] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Cat();

		do {
			System.out.println("WHAT IS 월드에 오신 걸 환영합니다!");
			System.out.print("(1)게임 플레이 (2)게임 설명 (3)종료");
			answer = ScanUtil.nextInt();
			if (answer == 1)
				do {
					System.out.print("분야를 선택해주십시오. (1)인물 (2)동물");
					answer = Integer.parseInt(sc.nextLine());
					int num = ran.nextInt(2);
					if (answer == 1) {
						people[num].play(people);
					} else if (answer == 2) {
						animal[num].play(animal);
					}

					System.out.println("계속하시겠습니까? (1)yes  (2)no");
					answer = Integer.parseInt(sc.nextLine());

				} while (answer == 1);
			if (answer == 2) {
				System.out.println("\n"+"WHAT IS는 특정 분야의 인물, 동물, 사물의 이름을 맞추는 게임입니다.\n"
						+ "총 10번의 기회가 주어지며, 힌트를 보거나 오답을 적을 시에 기회가 하나씩 줄어듭니다.\n" + "그리고 기회가 줄어들 때마다 얻는 점수도 줄어듭니다.\n"
						+ "그럼 이제 게임을 시작하고 내가 누군지 맞춰보세요~");
				System.out.println("\n\n" + "메인으로 돌아가려면 \'1\'을 입력하십시오.");
				answer = ScanUtil.nextInt();
			}
		} while (answer != 3);
	}

}
