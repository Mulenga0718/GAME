package e_oop.score;

public class Score {
	public static void main(String[] args) {
		// 객체생성을 해야 클래스(설계도)를 쓸 수 있어
		String[] studentNames = { "김기웅", "박태정", "이정규", "오지현" };
		Student[] students = new Student[studentNames.length]; // 학생을 저장할 배열 // //클래스 이름은 Student
		
		Student sc = new Student();// 객체 생성
		for(int i =0; i<students.length; i++) {
			students[i] = new Student();
			students[i].name = studentNames[i];
			students[i].scoremake();
			students[i].stusum();
			students[i].stuavg();
		}
		
		for(int i=0; i<students.length; i++) {
			students[i].getRank(students);
		}
		for(int i=0; i<students.length-1; i++) {
			int min = i;
			for(int j=i+1; j<students.length; j++) {
				if(students[j].rank < students[min].rank) {
					min = j;
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
		int [] subsum = new int[3];
		for(int i=0; i<students.length; i++) {
			subsum[0] += students[i].kor;
			subsum[1] += students[i].eng;
			subsum[2] += students[i].math;
		}
		double[] subavg = new double[3];
		for(int i=0; i<subavg.length; i++) {
			subavg[i] = Math.round((double)subsum[i]/students.length*100)/100.0;
		}
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");

		for(int i=0; i<students.length; i++) {
			System.out.println(students[i].getInfo());
		}
		System.out.print("과목합계");
		for(int i=0; i<subsum.length; i++) {
			System.out.print("\t"+subsum[i]);
		}
		System.out.print("\n과목평균");
		for(int i=0; i<subavg.length; i++) {
			System.out.print("\t"+subavg[i]);
		}
	
	}
}