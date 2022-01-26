package e_oop1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class VariableInit {
	//명시적 초기화
	int var = 10;
	static int classVar = 20;

	//초기화 블럭
	{
		var = 20;
	}
	
	static {
		classVar = 40;
	}
	
	//생성자
	/* 
	 * new Scanner();
	 * - 클래스와 같은 이름의 메서드 
	 * - 인스턴스 변수를 초기화하기 위해 사용한다.
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다.
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다.
	 * - 생성자는 리턴타입이 없다. 
	 */
 VariableInit() {
	 	var = 50;
	 	//생성자를 사용하는 이유는 파라미터를 사용할 수 있기 때문이다. 
	 	
 }
 
 public static void main(String[] args) {

	
	 LocalDateTime endDateTime = LocalDateTime.of(2022,  8, 22, 18, 0, 0);
	 double remainDay = ChronoUnit.DAYS.between(LocalDate.now(), endDateTime);
	 System.out.println(Math.round((remainDay*100.0/232.0))/10.0+"%");
	
	 Init i1 = new Init();
	i1.a = 10;
	i1.b = 20;
	i1.c = 30;
	
	Init i2 = new Init();
	i1.a = 40;
	i1.b = 50;
	i1.c = 60;
	
	Init i3 = new Init(70,80,90);
 	}
}
	
class Init{
	int a;
	int b;
	int c;

public Init(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
		//this : 인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용한다; 객체의 주소가 저장되어 있는 변수 
		
	}

	//오버로딩 : 같은 이름의 메서드를 여러개 정의하는 것
	//조건 : 파라미터의 개수나 타입이 달라야 한다. 

	Init(){
		this(10, 20, 30);
	
		//this() : 생성자에서 다른 생성자를 호출할 때 사용한다. 
	}
}
	
	

