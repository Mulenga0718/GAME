package j_collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * Collection Framework 
		 * -List 배열과 비슷하다. index가 존재해서 index순서대로 저장 
		 * -Map index가 아닌 key에 값을 저장 
		 * -Set 중복된 값은 저장되지 않는다.
		 * 
		 * 
		 * ArrayList의 주요 메서드 
		 * - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.; 인덱스 순서대로 값을 입력 
		 * - void add(int index, object obj) : 지정된 위치에 객체를 추가한다.; 
		 * 							   	     	기존에 있던 객체들의 index가 변경 
		 * - object set(int index, object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다. 
		 * - object get(int index) :지정된 위치의 객체를 반환한다. 
		 * - int size() : 지정된 객체의 수를 반환한다. 
		 * - object remove(int index) : 지정된 위치의 객체를 제거한다. ArrayList안의 값들을 읽는 속도가 빠르다.
		 *  but 값을 삭제하거나 수정할때 속도는 느리다.
		 * 
		 */
		// 배열의 단점: 크기를 조절할 수가 없음, 같은 타입을 입력해야함
		// 클래스의 단점: 통일되어있지 않음
		// 다수의 데이터를 다루기 위한 것이 컬렉션 프레임 워크

		ArrayList sample = new ArrayList();

		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		// 저장하기에는 편리하지만, 값을 꺼낼때 타입을 알기가 쉽지 않다.
		// 그렇기에 컬렉션에서 제네릭이라는 것이 존재

		ArrayList<Integer> list = new ArrayList<Integer>(); // 제네렉을 이용해서 ArrayList 생성 ;
															// ArrayList type지정; 컬렉션을 호출할때 제네릭 사용 권장;
		list.add(10);
//		list.add("abc"); 저장 불가!
		list.add(new Integer(20));
		/*
		 * Wrapper클래스
		 * - byte : Byte
		 * - short : Short 
		 * - int : Integer 
		 * - long : Long 
		 * - float : Float 
		 * - double : Double 
		 * - char : Character 
		 * - boolean : Boolean
		 */
		// 기본형타입을 그대로 사용할수 없고 객체로 사용하려고 할 때 사용
		// 기본형 타입을 대신하는 클래스가 Wrapper 클래스
		// 자동으로 형변환이 된다.

		System.out.println(list.add(30)); // boolean type의 값을 리턴
		System.out.println(list);

		list.add(1, 40);
		System.out.println(list);

		// set
		int before = list.set(2, 50);
		System.out.println("before : " + before);
		System.out.println(list);

		// get
		int get = list.get(2);
		System.out.println(get);

		// size
//		for(int i =0; i<4; i++) {
//		//remove 
//			System.out.println(i+":"+ list.remove(0));
//			
//		}
		System.out.println(list);
		// 지웠을 때, 뒤에 있던 index가 앞으로 이동하면서 완전히 삭제되지 않음
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(i + ":" + list.remove(i));
		}

		// list에 1~100사이의 랜덤값 10개를 저장해주세요.
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(ran.nextInt(100) + 1);
		}
		System.out.println(list);
		
		// list에 저장된 값의 합계와 평균을 구해주세요. 
		int sum =0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		double avg = (double)sum/list.size();
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
		
		//list에서 최소값과 최대값을 구해주세요. 
		int min = list.get(0);
		int max = list.get(0);
		for(int i=0; i<list.size(); i++) {
			if(min>list.get(i)) {
				min = list.get(i);
				}
			if(max<list.get(i)) {
				max = list.get(i);
				}
		}
		System.out.println("최솟값 : "+min);
		System.out.println("최댓값 : "+max);
		
		//list를 오름차순으로 정렬해주세요. 
		
		for(int i=0; i<list.size(); i++) {
			for(int j=i; j<list.size(); j++) {
				if(list.get(i)>list.get(j)) {
					list.set(j, list.set(i,list.get(j)));
				}
			}
		}
		System.out.println(list);
//for(int i=0; i<list.size() -1; i++){
//		min =i;
//		for(int j = i+1; j<list.size(); j++) {
//			if(list.get(j) < list.get(min)) {
//				min =j;
//			}
//		}
//		int temp = list.get(i);
//		list.set(i, list.get(min));
//		list.set(min, temp);
		
		//2차원 
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		
		list = new ArrayList<Integer>();
		list.add(40);
		list.add(50);
		
		list2.add(list);
		
		System.out.println(list2);
		
		for(int i= 0; i<list2.size(); i++) {
			ArrayList<Integer> list3 = list2.get(i);
			for(int j =0; j<list3.size(); j++) {
				System.out.println(list3.get(j));
			}
		}
		
		Integer integer =list2.get(0).get(1);
		System.out.println(integer);
		
		//학생 3명의 5과목에 대한 0~100점의 랜덤한 점수를 2차원 ArrayList에 저장해주세요. 
		list2 = new ArrayList<ArrayList<Integer>>();
		
//		for(int i=0; i<3; i++) {
//			list = new ArrayList<Integer>();
//			for(int j =0; j<5; j++) {
//			list.add(ran.nextInt(101));
//			}
//			list2.add(list);
//		}
//		System.out.println(list2);
//		
		for(int i=0; i< 3; i++) {
			list2.add(new ArrayList<Integer>());
			for(int j=0; j<5; j++) {
				list2.get(i).add(ran.nextInt(101));
			}
		}
		System.out.println(list2);
	//	각 학생별 합계와 평균을 구해주세요.
	
		ArrayList<Integer> stusum = new ArrayList<Integer>();
		ArrayList<Double> stuavg = new ArrayList<Double>();

		for(int i=0; i<list2.size(); i++) {
			sum =0;
			for(int j=0; j<list2.get(1).size(); j++) {
				sum += list2.get(i).get(j);
			}stusum.add(sum);
			stuavg.add(Math.round(((double)stusum.get(i)/list2.get(i).size())*100)/100.0);
		}

		System.out.println(stusum);
		System.out.println(stuavg);
	}
}
