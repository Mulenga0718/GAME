package j_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Score {

	public static void main(String[] args) {
		Random ran = new Random();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> stusum = new ArrayList<Integer>();
		ArrayList<Double> stuavg = new ArrayList<Double>();
		ArrayList<Integer> count =  new ArrayList<Integer>();
		ArrayList<Integer> subsum = new ArrayList<Integer>();
		ArrayList<Double> subavg = new ArrayList<Double>();
		ArrayList<String> name = new ArrayList<String>();
		name.add("강동주"); name.add("강정인"); name.add("강현수"); name.add("곽성상");name.add("김기웅");name.add("김민지");
		name.add("김형돈");name.add("노혜지");name.add("박태정");name.add("서난희");name.add("예현의");name.add("오지현");
		name.add("오혜지");name.add("유정민");name.add("이병진");name.add("이수민");name.add("이슬기");name.add("이유정");
		name.add("이의찬");name.add("이정규");name.add("이정민");name.add("장문석");name.add("정다영");name.add("최민규");
		name.add("최혁진");
		
		//학생별 과목 점수 입력 
		for(int i=0; i<25; i++) {
			list.add(new ArrayList<Integer>());
			for(int j=0; j<7; j++ ) {
				list.get(i).add(ran.nextInt(101));
			}
		}
		//학생별 합계 및 평균 
		for(int i=0; i<list.size(); i++) {
			int sum =0;
			for(int j=0; j<list.get(i).size(); j++) {
				sum += list.get(i).get(j);
			}
			stusum.add(sum);
			stuavg.add(Math.round((double)sum/list.get(i).size()*100)/100.0);
		}
		//학생별 석차 
		for(int i=0; i<list.size(); i++) {
			int count1 = 1;
			for(int j=0; j<list.size(); j++) {
				if(stusum.get(i)<stusum.get(j)) {
					count1++; 
				}
			}count.add(count1);
		}
		//정렬 
		for(int i=0; i<list.size(); i++) {
			for(int j=i; j<list.size(); j++) {
				if(count.get(i)>count.get(j)) {
					count.set(j,count.set(i, count.get(j)));
					
					stusum.set(j, stusum.set(i, stusum.get(j)));
					stuavg.set(j, stuavg.set(i, stuavg.get(j)));
					list.set(j, list.set(i, list.get(j)));
					name.set(j, name.set(i, name.get(j)));
				}
			}
		}
		//과목합계 및 과목 평균 
		for(int i=0; i<list.get(i).size(); i++) {
			int sum =0;
			for(int j=0; j<list.size(); j++) {
				sum += list.get(j).get(i);
			}
			subsum.add(sum);
			subavg.add(Math.round((double)sum/list.size()*100)/100.0);
		}
		//출력
		System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
		
		for(int i =0; i<list.size(); i++) {
			System.out.print(name.get(i)+"\t");
			for(int j=0; j<list.get(i).size(); j++) {
			System.out.print(list.get(i).get(j)+"\t");
			}
			System.out.print(stusum.get(i)+"\t");
			System.out.print(stuavg.get(i)+"\t");
			System.out.print(count.get(i));
			System.out.println();
		}
		System.out.print("과목합계\t");
		for(int i=0; i<list.get(i).size(); i++) {
			System.out.print(subsum.get(i)+"\t");
		}
		System.out.println();
		System.out.print("과목평균\t");
		for(int i=0; i<list.get(i).size(); i++) {
			System.out.print(subavg.get(i)+"\t");
		}
	}
}
