package e_oop1;

public class AirCon {
	// 전원, 온도 조절, 풍향, 기능
	String on;
	String off;
	int temp;
	int shiftwind;
	int mod;
	int temper = 21;
	String onoff(String a) {
		if (a.equals("on")) {
			return "on";
		} else {
			return "off";
		}
	}

	int temp(int a) {
		if (a == 1) {
			this.temper++;
		}
		if (this.temper > 18) {
			if (a == 2) {
				this.temper--;
			}
		}
		return this.temper;
	}

	String shiftwind(int a) {
		String shiftwind = null;
		if (a == 1) {
			shiftwind = "왼쪽";
		} else if (a == 2) {
			shiftwind = "오른쪽";
		} else if (a == 3) {
			shiftwind = "위쪽";
		} else if (a == 4) {
			shiftwind = "아래쪽";
		}

		return shiftwind;
	}

	String mod(int a) {
		String mod = null;
		if (a == 1) {
			mod = "냉방";
		} else if (a == 2) {
			mod = "파워";
		} else if (a == 3) {
			mod = "제습";
		} else if (a == 4) {
			mod = "온풍";
		}
		return mod;
	}
	
	boolean power = false;
	int temperature = 24;
	int wind = 2;
	
	final int MIN_TEMPERATURE = 18;
	final int MAX_TEMPERATURE = 30;
	final int MIN_WIND = 1;
	final int MAX_WIND = 3;
	
	void power() {
		power = !power;
		System.out.println(power? "켜짐": "꺼짐");
	}
	
	void temperatureUP() {
		if(power) {
			if(temperature <MAX_TEMPERATURE) {
				temperature++;
			}
			System.out.println("현재온도:"+ temperature);
		}
	}
	void changeWind() {
		wind++;
		if(MAX_WIND<wind) {
			wind = MIN_WIND;
		}
		System.out.println("현재풍량: "+wind + "단계");
	}

}
//오늘의 과제: 클래스를 만들어라!