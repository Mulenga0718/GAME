package e_oop.score;

public class Student {

	String name;
	int kor;
	int eng;
	int math;
	int rank;
	double avg;
	int sum;

	void scoremake() {
		kor = (int) (Math.random() * 101);
		eng = (int) (Math.random() * 101);
		math = (int) (Math.random() * 101);
	}

	int stusum() {
		return sum = kor + eng + math;
	}

	double stuavg() {
		return avg = Math.round(stusum() / 3.0 * 100) / 100.0;
	}

	int getRank(Student[] students) {
		rank = 1;

		for (int i = 0; i < students.length; i++) {
			if (stusum() < students[i].stusum()) {
				rank++;
			}
		}
		return rank;
	}
	String getInfo() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+avg+"\t"+rank;
	}
}
