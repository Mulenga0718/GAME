package e_oop1;

class Homework {
// 헬창
// 근육량, 체력, 체중 
// 단백질 섭취, 런닝머신, 데드리프트, 푸쉬업, 	
	 int health = 100;
	 int muscle = 3;
	 int weight = 80;

	 void drinkprotein() {
		System.out.print("몇 리터 섭취하겠습니까?>");
		int a = ScanUtil.nextInt();
		health -= (3 * a);
		muscle += (2 * a);
		weight += (1 * a);
	}

	 void running() {
		System.out.print("몇 시간 뛰시겠습니까>");
		int a = ScanUtil.nextInt();
		health -= (10 * a);
		muscle += (2 * a);
		weight -= (3 * a);
	}

	void deadlift() {
		System.out.print("몇 세트 하시겠습니까>");
		int a = ScanUtil.nextInt();
		health -= (10 * a);
		muscle += (4 * a);
		weight -= (1 * a);
	}

	 void pushup() {
		System.out.print("몇 십개 하시겠습니까>");
		int a = ScanUtil.nextInt();
		health -= (1 * a);
		muscle += (1 * a);
	}
}

class Homeworktester {
	public static void main(String[] args) {
		int answer;
		Homework homework = new Homework();
		System.out.println("운동을 시작하겠습니다.");
		System.out.println("현재 체력:" + homework.health + "근육량:" + homework.muscle + "몸무게:" + homework.weight);
		do {
			answer = 0;
			System.out.println("어떤 운동을 하시겠습니까?");
			System.out.print("1.프로틴 마시기 2.러닝머신 3.데드리프트 4.푸쉬업> ");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				homework.drinkprotein();
				break;
			case 2:
				homework.running();
				break;
			case 3:
				homework.deadlift();
				break;
			case 4:
				homework.pushup();
				break;
			}
			System.out.println("현재 체력:" + homework.health + "근육량:" + homework.muscle + "몸무게:" + homework.weight);
			System.out.print("운동을 계속하시겠습니까> 1.yes 2.no");
			answer = ScanUtil.nextInt();
		} while (homework.health > 1 && answer == 1);
		if (homework.health <= 1) {
			System.out.println("체력이 부족합니다.");
		} else {
	 		System.out.println("현재 체력:" + homework.health + "근육량:" + homework.muscle + "몸무게:" + homework.weight);
		}
	}
}
