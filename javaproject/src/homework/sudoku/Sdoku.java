package homework.sudoku;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Sdoku {
	static int[][] makeclone(int orgin[][], int clone[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				clone[i][j] = orgin[i][j];
			}
		}
		return clone; // 복제 행렬 만들기
	}

	static void arrayprint(int clone[][]) {
		System.out.println(Arrays.deepToString(clone).replace(",", " ").replace("]", "\n").replace("[[", "  ")
				.replace("[", "").replace("0", "□"));// 문자열로 출력

	}

	static void play(int origin[][], int clone[][]) {
		long start = System.currentTimeMillis(); // 시작하는 시점 계산

		do {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (clone[i][j] == 0) {
						System.out.print((i + 1) + "행" + (j + 1) + "열>");
						int temp = ScanUtil.nextInt();
						if (origin[i][j] == temp) {
							clone[i][j] = temp;
							arrayprint(clone);
						} else if (temp == 0) {
							continue;
						} else if (origin[i][j] != temp) {
							System.out.println("틀렸습니다. 다시 입력해주십시오.");
							j--;
						}
					}
				}

			}
		} while (!Objects.deepEquals(origin, clone));
		System.out.println("축하드립니다! 모두 맞추셨습니다.");

		long end = System.currentTimeMillis();
		System.out.println("경과시간 : " + (end - start) / 1000.0 + "초");
	}// 실행될 게임

	public static void main(String[] args) {

		Random ran = new Random();
		MakeSudoku ms = new MakeSudoku();
		Scanner sc = new Scanner(System.in);
		int clone[][] = new int[9][9];

		System.out.println("스도쿠 월드에 오신 걸 환영합니다!");
		System.out.print("게임을 시작하시겠습니까> (1)yes (2)no");
		int answer = ScanUtil.nextInt();
		if (answer == 1) {
			do {
				System.out.print("(1)게임 플레이 (2)게임 설명 (3)종료");
				answer = ScanUtil.nextInt();
				if (answer == 1) {
					int a[][] = ms.makesudoku();
					makeclone(a, clone);
					System.out.print("1~4사이의 난이도를 설정하십시오.>");
					int level = ScanUtil.nextInt();
					switch (level) {
					case 1:
						ms.level1(clone);
						break;
					case 2:
						ms.level2(clone);
						break;
					case 3:
						ms.level3(clone);
						break;
					case 4:
						ms.level4(clone);
						break;
					}
					arrayprint(clone);

					System.out.println("빈칸(□)에 1~9까지 숫자를 입력하십시오. \'0\'을 입력하면 다음 빈칸으로 이동합니다.");
					play(a, clone);
				} else if (answer == 2) {
					System.out.print(
							" 게임 규칙은 단 두 가지입니다:" + "\n첫째, 가로줄 9칸, 세로줄 9칸에 각각 1~9의 숫자가 겹치지 않게 들어가야 합니다.단, 대각선은 상관없습니다."
									+ " \n둘째, 가로. 세로 각 3칸으로 이뤄진 작은 정사각형 속의 9개 칸에도 1~9의 숫자가 겹치지 않게 들어가야 합니다.");
					System.out.println("\n\n" + "메인으로 돌아가려면 \'1\'을 입력하십시오.");
					answer = ScanUtil.nextInt();
				} else if (answer == 3)
					break;
			} while (answer != 3);
		}
		System.out.println("스도쿠 게임을 종료합니다.");
	}
}
