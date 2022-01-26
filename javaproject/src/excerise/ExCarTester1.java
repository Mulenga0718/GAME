package excerise;

public class ExCarTester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExCar myCar = new ExCar("W221", 1845,1490,5205,90.0);
		System.out.printf("현재위치: (%.2f,%.2f)\n", myCar.getX(), myCar.getY());
		System.out.printf("남은 연료:%.2f리터\n", myCar.getFuel());
	}

}
