package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;

//get : 읽어오기 위한 메서드  set: 저장하기 위한 메서드 
//메서드를 사용하면 메서드 안에 로직을 만들 수 있음. 잘못된 값이 들어왔을때 막을 수 있다. 

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0) {
			this.hour = 0;
		} else if (23 < hour) {
			this.hour = 23;
		} else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0) {
			this.minute = 0;
		} else if (59 < minute) {
			this.minute = 59;
		} else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second < 0) {
			this.second = 0;
		} else if (second > 59) {
			this.second = 59;
		} else {
			this.second = second;
		}
	}
	void clock() {
		while(true) {
			System.out.println(toString());
			stop();
			setSecond(second+1);
		}
	}

	private void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}

