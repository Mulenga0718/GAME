package excerise;

public class IdTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Id a = new Id();
		Id b = new Id();
		Id c = new Id();
		Id.setStep(4);
		Id d = new Id();
		Id e = new Id();
		Id f = new Id();
		
		
		System.out.println("a의 식별 번호:" + a.getId());
		System.out.println("b의 식별 번호:" + b.getId());
		System.out.println("c의 식별 번호:" + c.getId());
		System.out.println("d의 식별 번호:" + d.getId());
		System.out.println("e의 식별 번호:" + e.getId());
		System.out.println("f의 식별 번호:" + f.getId());
		
		int max=Id.getMaxId();
		System.out.println(max);
		System.out.println(max+Id.getStep());
		
		
	}

}
