package service;

import util.ScanUtil;
import util.View;

public class Main {
	private Main() {
	}
private static Main instance; 
public static Main getInstance() { 
	if (instance == null) {
		instance = new Main();
	}
	return instance;
}
public int main() {
	System.out.println("๐ต==================== ๋๋ ๋ฎค์ง =======================๐ต");
	System.out.println();
	System.out.print("1.๋ธ๋๊ฒ์ 2.์ธ๊ธฐ์ฐจํธ 3.์ต์  ์์ 4.์ถ์ฒ๋ธ๋๋ชฉ๋ก "
			+ "5.๊ณต์ง์ฌํญ 6.๋ฌธ์์ฌํญ 7.๋ด ์์ 8.๋ง์ดํ์ด์ง 9.๋ก๊ทธ์์ 0.ํ๋ก๊ทธ๋จ์ข๋ฃ >");
	int result = ScanUtil.nextInt();
	switch(result) {
	case 5: return View.NOTICEBOARD; 
	case 6: return View.QBOARD; 
	case 8 :return View.ADMINMAIN;
	case 9: Login.loginMember = null; return View.HOME; 
	case 0: System.out.println("ํ๋ก๊ทธ๋จ์ด ์ข๋ฃ๋์์ต๋๋ค.");
	System.exit(0);
	}

return View.MAIN;
}
}

