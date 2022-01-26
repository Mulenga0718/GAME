package homework.finger;

public class Gamble {
	int gamble[] = new int[100];

	int[] gamlevel(int gamble[]) {
		this.gamble = gamble;
		return gamble;
	}
}

class Level1 extends Gamble {

	int[] gamlevel(int gamble[]) {
		this.gamble = gamble;
		for (int i = 0; i < 4; i++) {
			gamble[i] = 1000;
		}
		for (int i = 4; i < 12; i++) {
			gamble[i] = 500;
		}
		for (int i = 12; i < 50; i++) {
			gamble[i] = 200;
		}
		for (int i = 50; i < 100; i++) {
			gamble[i] = 100;
		}

		return gamble;
	}

}

class Level2 extends Gamble {

	int[] gamlevel(int gamble[]) {
		this.gamble = gamble;
		for (int i = 0; i < 4; i++) {
			gamble[i] = 2000;
		}
		for (int i = 4; i < 12; i++) {
			gamble[i] = 1000;
		}
		for (int i = 12; i < 50; i++) {
			gamble[i] = 400;
		}
		for (int i = 50; i < 100; i++) {
			gamble[i] = 200;
		}

		return gamble;
	}

}

class Level3 extends Gamble {

	int[] gamlevel(int gamble[]) {
		this.gamble = gamble;
		for (int i = 0; i < 4; i++) {
			gamble[i] = 4000;
		}
		for (int i = 4; i < 12; i++) {
			gamble[i] = 2000;
		}
		for (int i = 12; i < 50; i++) {
			gamble[i] = 800;
		}
		for (int i = 50; i < 100; i++) {
			gamble[i] = 400;
		}

		return gamble;
	}

}

class Level4 extends Gamble {

	int[] gamlevel(int gamble[]) {
		this.gamble = gamble;
		for (int i = 0; i < 4; i++) {
			gamble[i] = 8000;
		}
		for (int i = 4; i < 12; i++) {
			gamble[i] = 4000;
		}
		for (int i = 12; i < 50; i++) {
			gamble[i] = 1600;
		}
		for (int i = 50; i < 100; i++) {
			gamble[i] = 800;
		}

		return gamble;
	}

}
