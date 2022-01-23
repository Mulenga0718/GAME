package game;

import java.util.Random;
import java.util.Scanner;

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
	
		do{
		System.out.print("분야를 선택해주십시오. 1.인물 2.동물");
		answer = Integer.parseInt(sc.nextLine());
		int num = ran.nextInt(2);
		 if(answer == 1) {people[num].play(people);}
		 else if(answer== 2) {animal[num].play(animal);}
		
		 System.out.println("계속하시겠습니까? 1.yes  2.no");
		 answer = Integer.parseInt(sc.nextLine());
		
		 }while (answer == 1);
		
}
}