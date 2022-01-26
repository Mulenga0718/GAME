package excerise;

public class Id {
	static int counter = 0;
	private int id;
	private static int step = 1;
	
	public Id() {
		id = counter+=step;
	}

	public int getId() {
		return id;
	}
	public static int getStep() {
		return step;
	}
	public static int setStep(int s) {
		step =(s>=1)? s:1;
		return step;
	}
	public static int getMaxId() {
		return counter;
	}
}

