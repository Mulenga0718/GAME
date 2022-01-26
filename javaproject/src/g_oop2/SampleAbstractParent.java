package g_oop2;

//추상 클래스 
public abstract class SampleAbstractParent {
	
	void method() {
	}
	
	// 추상 메서드 
	abstract void abstractMethod();
	
	// 메서드를 호출 할 수 없음, 클래스도 객체 생성을 하지 못함. 
	// 상속하는 용도로 사용 
	// 추상메서드를 사용하는 이유는 상속을 받는 클래스들에 똑같은 메서드들이 있지만 내용이 다를때 사용
	// 추상 메서드는 자식 클래스에게 메서드를 만들도록 강제하도록 한다.(추상 메서드 사용이유!)
	
}

class SampleAbstractChild extends SampleAbstractParent{
	
	void abstractMethod() {	
	}
}













