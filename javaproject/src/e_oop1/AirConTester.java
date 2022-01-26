package e_oop1;

public class AirConTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirCon aircon = new AirCon();
		
		System.out.print("전원을 켜시겠습니까? on/off ");
	 	String result = aircon.onoff(ScanUtil.nextLine());
		System.out.println("전원을" + result +"하겠습니다.");
		
		
		int request;
		do {	
		request=0;
		System.out.print("온도를 조절하시겠습니까? 1.up 2.down");
		int result1 = aircon.temp(ScanUtil.nextInt());
		System.out.println("온도를 조절하였습니다. 현재 온도는" +aircon.temper+"입니다." );
		System.out.print("온도를 더 조절하시겠습니까? 1.yes 2.no");
		request = ScanUtil.nextInt();
	}while(request == 1); 
		System.out.print("풍향을 조절하시겠습니까? 1.좌 2.우 3.상 4.하");
		result = aircon.shiftwind(ScanUtil.nextInt());
		System.out.println("풍향을" +result+"으로 이동하였습니다.");
		
		System.out.print("모드를 변경하시겠습니까? 1.냉방 2.파워 3.제습 4.온풍");
		result = aircon.mod(ScanUtil.nextInt());
		System.out.println(result + "모드로 변경하였습니다.");
	}

}
