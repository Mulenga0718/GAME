package java200;

import java.util.Random;
import java.util.Scanner;

public class Method {

	static int min(int a, int b) {
		int min= a;
		if(min >b) {min =b;}
		return min;
	}
	static int min(int a, int b, int c) {
	int min= a;
	if(min >b) {min =b;}
	if(min >c) {min =c;}
	return min;}
	
	static int min(int []a) {
		int min = a[0];
		for(int i =0; i<a.length;i++) {
			if(min>a[i]) {min = a[i];}
		}
		return min;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("x값: ");
		int x = sc.nextInt();
		System.out.print("y값: ");
		int y = sc.nextInt();
		System.out.print("z값: ");
		int z = sc.nextInt();
		System.out.println("배열 a의 요소수");
		int num =  sc.nextInt();
		int a[] = new int[num];
		for(int i=0; i<a.length; i++) {
			a[i]= sc.nextInt();
		}
		System.out.println("x,y의 최솟값은"+min(x,y));
		System.out.println("x,y,z의 최솟값은"+min(x,y,z));
		System.out.println("배열 a의 최솟값은"+min(a));
}
}