package java200.exam14;

public class Robotpet extends Pet{
	
	
	public Robotpet(String name, String masterName) {
		// TODO Auto-generated constructor stub
		super(name,masterName);
	}


	public void introduce() {
		System.out.println("나는 로봇! 이름은"+getName()+"입니다");
		System.out.println("주인님의 이름은 "+getmasterName()+"입니다");
	}
	public void work(int sw) {
		switch(sw) {
		case 0: System.out.println("청소를 합니다."); break;
		case 1: System.out.println("세탁을 합니다."); break;
		case 2: System.out.println("밥을 합니다."); break;
		}
	}
}


	