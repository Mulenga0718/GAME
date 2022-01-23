package java200.exam14;

public class Headphone implements Wearable {
	int volum=0;
	@Override
	public void putOn() {
		// TODO Auto-generated method stub
System.out.println("헤드폰을 착용했습니다.");
	}

	@Override
	public void putOff() {
		// TODO Auto-generated method stub
System.out.println("헤드폰을 벗었습니다.");
	}
	public void setVolume(int volum) {
		this.volum = volum;
		System.out.println("볼륨을"+volum+"로 변경했습니다.");
	}

}
