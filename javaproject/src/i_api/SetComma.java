package i_api;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 부여 출력해주세요.
		// 1,234,567
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String num1 = "";

		for (int i = 0; i < num.length(); i++) {
			if(i==0) {num1 += num.charAt(i);}
			else if ((num.length() - i) % 3 == 0) {
				num1 += "," + num.charAt(i);
			} else {
				num1 += num.charAt(i);
			}
		}
		System.out.println(num1);
	}
}
//		System.out.println(num1);
//		int count =0;
//		String res = "";
//		for(int i = num.length()-1; i>=0 ; i--) {
//			res = num.charAt(i) + res;
//			count++;
//			if(count%3==0 && count !=num.length()) {
//			res = ","+res;
//		}
//	}
//	System.out.println(res);
//}
//}