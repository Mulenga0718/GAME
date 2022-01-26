package homework.sudoku;

import java.util.Random;

public class MakeSudoku {
	Random ran = new Random();

	int[][] makesudoku() {
		int numbermake[][] = new int[9][9];
		int firstnumber[] = new int[9];
		for (int i = 0; i < 9; i++) {
			firstnumber[i] = ran.nextInt(9) + 1;
			for (int j = 0; j < i; j++) {
				if (firstnumber[i] == firstnumber[j]) {
					i--;
				}
			}
		} // 중복되지 않는 1~9까지 랜덤 배열 생성
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				numbermake[i][j] = firstnumber[count];
				count++;
			}
		} // numbermake[0][0]에서 numbermake[3][3]까지 1~9까지 수 입력.

		// 기준 3*3배열 랜덤 만들기
		int x1[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
		int x2[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i][j + 3] += x2[i][k] * numbermake[k][j];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i][j + 6] += x1[i][k] * numbermake[k][j];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 3][j] += numbermake[i][k] * x1[k][j];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 3][j + 3] += numbermake[i][k + 3] * x1[k][j];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 3][j + 6] += numbermake[i][k + 6] * x1[k][j];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 6][j] += numbermake[i][k] * x2[k][j];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 6][j + 3] += numbermake[i][k + 3] * x2[k][j];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					numbermake[i + 6][j + 6] += numbermake[i][k + 6] * x2[k][j];
				}
			}
		}
		return numbermake;

	}

	int[][] level1(int clone[][]) {
		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < 2; j++) {
				clone[i][ran.nextInt(8) + 1] = 0;
			}
		}
		return clone;
	}

	int[][] level2(int clone[][]) {

		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < 4; j++) {
				clone[i][ran.nextInt(8) + 1] = 0;
			}
		}
		return clone;
	}

	int[][] level3(int clone[][]) {
		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < 6; j++) {
				clone[i][ran.nextInt(8) + 1] = 0;
			}
		}
		return clone;
	}

	int[][] level4(int clone[][]) {

		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < 8; j++) {
				clone[i][ran.nextInt(8) + 1] = 0;
			}
		}
		return clone;
	}

}
