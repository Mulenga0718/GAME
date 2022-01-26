package g_oop2;

public class SampleChild extends SampleParent {

	void childMethod() {
		// 상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);// 상속받은 변수
		System.out.println(method(7, 13));
	}

	// 오버라이딩: 상속받은 메서드 내용을 바꾸는 것
	// super, super(): 부모클래스의 멤버와 자식클래스의 멤버의 이름이 똑같을 때 super 사용,
	// 자식클래스에서 부모클래스를 사용할때 super() 사용
	// 다형성: 부모타입의 변수로 자식타입의 객체를 사용

	// 오버라이딩: 상속받은 메서드의 내용을 재정의 하는 것
	@Override //어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것 ; 이 메서드가 오버라이딩있 됐는지 않됐는지 체크 
	int method(int a, int b) { //리턴타입 메서드명 파라미터 모두 같아야 한다. 
		return a * b;
	}
	
	// super, super()
	int var;
	
	void test(double var) {
		System.out.println(var); //지역변수
		System.out.println(this.var);// 인스턴스 변수 
		System.out.println(super.var);//부모 클래스의 인스턴스 변수 
		//super : 부모 클래스의 멤버와 자식클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다. 
	}
	
	SampleChild(){
//		this(); // 같은 클래스에 있는 다른 생성자 호출; 반드시 첫번째 라인에 위치해야한다.
		super(); // 부모 클래스의 생성자 호출 ; 반드시 첫번째 라인에 위치해야한다. ; this()와 super()를 동시에 사용할 수 없다. 
		//this()가 없는 생성자에서만 super()를 호출한다. 
	}
	//다형성: 부모타입의 변수로 자식타입의 객체를 사용하는 것 
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();// 다형성 
		//변수(부모)의 타입에 있는 멤버만 사용할 수 있다. 
		System.out.println(sp.var);
		sp.method(10, 20);
		
		//객체(자식)의 타입에 있는 멤버는 사용할 수 없다. 
//		sp.childMethod(); x
//		sp.test(); x
		
		
	}
}
