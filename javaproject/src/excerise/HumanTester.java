package excerise;

public class HumanTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human gildong = new Human("홍길동", 170, 60);
		Human chulsu = new Human("김철수", 166, 72);
		
		gildong.putDate();
		System.out.println("번호:"+gildong.getId());
		
		System.out.println();
		
		chulsu.putDate();
		System.out.println("번호:"+chulsu.getId());
	}

}
