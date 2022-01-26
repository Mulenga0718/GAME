package homework.finger;

import java.util.Random;

import homework.sudoku.ScanUtil;

public class GamblePlay {

	public static void main(String[] args) {
		HumanPlayer hp = new HumanPlayer();
		ComputerPlayer cp = new ComputerPlayer();
		Gamble[] gam = {new Level1(), new Level2(),new Level3(),new Level4()};
		Random ran = new Random();
		String[] hands = { "가위", "바위", "보자기" };
		hp.money = 1000;
		int randomchoice[] = new int[100];
		
		System.out.println("판돈을 선택해주세요.\n(1)100원 (2)200원 (3)400원 (4)800원");
		int input= ScanUtil.nextInt();
		gam[input-1].gamlevel(randomchoice);
		int retry;
		do {
			int comp = cp.nextHand();
			int user = hp.nextHand();
			System.out.println("나는" + hands[comp] + "이고, 당신은" + hands[user] + "입니다.");

			int judge = (user - comp + 3) % 3;
			switch (judge) {
			case 0:
				System.out.println("비겼다. 휴먼");
				break;
			case 1:
				System.out.println("당신이 졌다. 휴먼");
		
				hp.money -= randomchoice[99];
				break;
			case 2:
				System.out.println("당신이 이겼다. 휴먼");
				for(int i=0; i<15; i++) {
					System.out.println(randomchoice[ran.nextInt(100)]);
					try {Thread.sleep(400);} catch(InterruptedException e) {}
				}
				int result = randomchoice[ran.nextInt(100)];
				System.out.println("야삐~:"+result);
				hp.money += result;
				break;
			}
			do {
				System.out.println("가진 돈 :"+hp.money);
				System.out.print("다시 한번? (1)네 (2)아니오");
				retry = ScanUtil.nextInt();
				if (hp.money < 100)
					break;
			} while (retry != 1 && retry != 2);
			if (hp.money < 100)
				break;
		} while (retry == 1);
	}
}
