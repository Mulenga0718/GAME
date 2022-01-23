package java200.exam14;

public class WearableComputer implements Wearable {

	@Override
	public void putOn() {
		// TODO Auto-generated method stub
		System.out.println("검퓨터를 실행했습니다.");
	}

	@Override
	public void putOff() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 껏습니다.");
	}
	public void reset() {
		System.out.println("컴퓨터를 재시작했습니다.");
	}
}
