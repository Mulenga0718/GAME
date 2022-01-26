package homework.whois;

import java.util.Random;
import java.util.Scanner;

import e_oop1.ScanUtil;

public class Animal extends Question {
	String name;
	int answer;
	int num;
	int count;
	static int total; 
	Question question = new Question();
	Random ran = new Random();
		public void a(int a) {
		
		}
		String name() {
			return name;
		}
			void play(Animal[] animal) {
				count=0; 
				num = ran.nextInt(2); 
				for (int i = 0; i < 11; i++) {
					System.out.println("\n"+"남은 기회:"+(10-count));
					System.out.print("1.힌트... 2.정답 >");
					answer = ScanUtil.nextInt();
					if (answer == 1) {
						animal[num].a(i);
						count++;
					} else if (answer == 2) {
						System.out.print("정답:");
						String answer1 = ScanUtil.nextLine();
						if (animal[num].name().equals(answer1)) {
							System.out.println("정답입니다.");
							break;
						} else {
							System.out.println("틀렸습니다."); count++; 
						}
					}
				}
				System.out.println((11 - count) + "점을 획득하셨습니다.");
				total += 11-count;
				System.out.println("총 포인트:"+question.total(total) +"입니다.");
			}
}