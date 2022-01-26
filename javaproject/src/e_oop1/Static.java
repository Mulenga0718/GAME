package e_oop1;

public class Static {
/*
 * -static을 붙이면 프로그램 실행시 메모리에 올라간다.
 * -객체생성을 하지 않아도 사용할 수 있다.
 * -static을 붙인 변수는 객체간에 변수의 값을 공유한다.
 * -static이 붙은 멤버의 명칭: 클래스 변수, 클래스 메서드
 * -static이 붙지 않은 멤버의 명칭: 인스턴트 변수, 인스턴트 메서드
 */
	//변수의 위치: 메서드 안에 있으면 지역변수, 밖에 있으면 전역변수 
	//static 여부: 전역변수 중에 static이 붙으면 클래스 변수, 붙지 않으면 인스턴스 변수 
	//스타크래프트: 테란 종족 - 마린 유닛, 여러마리 생산, 전투 중 체력이 달라짐
	//만일 병사를 업그레이드를 하면, 모든 병사들이 똑같이 공격력과 방어력이 올라감!!! 모두에게 적용되는게 static 
	
	//변수에 static을 붙이는 이유는 값을 공유하기 위함이다. 
	
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		
		System.out.println("m1 HP: "+m1.hp);
		System.out.println("m2 HP: "+m2.hp);
		
		m1.hp -= 10;
		m2.hp -= 20;
		
		System.out.println("m1 HP: "+m1.hp);
		System.out.println("m2 HP: "+m2.hp);
		
		
	

		System.out.println("m1 ATT: "+m1.attack);
		System.out.println("m1 DEF: "+m1.defence);
		System.out.println("m2 ATT: "+m2.attack);
		System.out.println("m2 DEF: "+m2.defence);
		
		
		m1.attack += 1;
		m2.defence += 1;
		
		
		System.out.println("m1 ATT: "+m1.attack);
		System.out.println("m1 DEF: "+m1.defence);
		System.out.println("m2 ATT: "+m2.attack);
		System.out.println("m2 DEF: "+m2.defence);
		
		System.out.println();
		

		System.out.print("문자열 입력>");
		String str = ScanUtil.nextLine();
		System.out.println("엽력받은 문자열: "+ str);
		
		System.out.print("숫자 입력>");
		int num = ScanUtil.nextInt();
		System.out.println("입력받은 숫자: "+ num);
		
	}
}

class Marine{
	int hp=40; //체력
	static int attack=5; //공격력
	static int defence=0; //방어력
	
}