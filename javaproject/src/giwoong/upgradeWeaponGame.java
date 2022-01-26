package giwoong;

import e_oop1.ScanUtil;

/*
 * 무기강화해서 대장간차리기 
 * 스토리 - 10만원 밖에 없는 플레이어가 10억짜리 대장간을 차리기위해 연습겸 무기강화해서 비용을 만든다
 * 강화 - 강화할 수 있는 무기는 검, 도끼, 창이 있으며 각 무기마다 1~3티어가 존재한다.
 *     - 무기의 비용은 검, 도끼, 창 순서로 비용이 비싸다.
 *     - 무기의 등급은 일반, 희귀, 고급, 레어, 전설, 유물까지 이고 유물등급이 최고등급이기에 더는 강화가 불가능하다.
 *     - 무기 강화비용은 무기의 등급이 오를수록 더욱 많이든다.
 *     - 무기의 강화확률은 등급이 오를수록 낮아지고 무기의 파괴확률은 등급이 오를수록 높아진다.
 *     
 * 대출 - 대출금은 한번에 최대  2천만원까지 빌릴수있다.  
 *     - 대출금은 매번 무기강화가 끝날때 마다 이자가 10%씩 붙는다.
 *     
 * 대장간 차리기 - 플레이어가 10억이상의 돈이 있을때 대장간을 차리고 게임이 종료된다.
 *            - 플레이어는 대출금을 전부 갚았을경우만 위의 조건이 해당된다.      
 */

public class upgradeWeaponGame {
	static long loanMoney;  //대출금액
	static int smithy = 1000000000; //대장간 비용

	public static void main(String[] args) {
		upgradeWeaponGame game = new upgradeWeaponGame(); //강화게임 객체 생성
		Weapon wp = new Weapon(1); // 주요 기능들이 들어있는 Weapon 객체 생성
		while (true) {
			System.out.println("==========================================================");
			System.out.println("\t1.강화하러가기 2.소유금 확인 3.대출받기");
			System.out.println("4.대출받은금액 확인 5.대출금 갚기 6.파산신청 7.대장간 차리기");
			int num = ScanUtil.nextInt(); // 선택지 입력
			switch (num) {
			case 1:
				game.start(); //강화
				break;
			case 2:
				wp.moneyInfo(); // 소유금 확인
				break;
			case 3:
				System.out.println("＃얼마만큼의 금액을 대출받으시겠어요?");
					int money = ScanUtil.nextInt(); //대출받을 금액 입력
					if(money>20000000) //만약 희망 대출금이 2천만원 이상일시 
					{
						System.out.println("＃그렇게 많이는 못 빌려주는데,,");
						break;
					}else {
					Weapon.money += money; // 보유하고있는 금액에 빌린금액을 추가함
					loanMoney += money;    //대출금에도 빌린금액을 추가
					System.out.println("＃" + money + "만큼의 돈을 빌리셨어요! 이자는 10%에요.");
					}
				break;
			case 4:
				System.out.println("＃현재 대출 받은 금액은 " + loanMoney + " 원 이에요."); //현재까지 받은 대출금액 합계 + 이자
				break;
			case 5:
				if (loanMoney == 0) { //대출금이없으면
					System.out.println("＃대출받은 돈이 없는데여,,");
					break;
				}
				System.out.println("＃얼마만큼의 금액을 갚으시겠어요?");
				System.out.println("＃현재 대출 받은 금액은 " + loanMoney + " 원 이에요.");
				System.out.println("＃보유금 : " + Weapon.money);
				int returnMoney = ScanUtil.nextInt(); //갚을금액 입력
				if (returnMoney > loanMoney) { //갚을금액이 대출받은 금액보다 많다면
					System.out.println("＃대출받은 금액보다 갚으려는 돈이 더 많은데여?");
					break;
				} else { //돈을 갚을시
					Weapon.money -= returnMoney; //보유하고있는 돈에서 입력한 갚을금액을 차감
					loanMoney -= returnMoney;  //입력한 갚을금액을 대출받은 합계에서 차감
					System.out.println("＃" + returnMoney + "만큼의 돈을 갚았어요!");
					System.out.println("＃이제 남은 대출금은 " + loanMoney + "원 이에요!");
				}
				break;
			case 6: //배드엔딩
				System.out.println("파산 했어요^^,,");
				System.exit(0);
				break;
			case 7: //해피엔딩
				if (loanMoney > 0) { //만약 대출금이 남아있다면
					System.out.println("대출금부터 갚고 차리셔야죠ㅎㅎ;");
					break;
				} else if (Weapon.money >= smithy) { //보유금액이 대장간을 차릴 비용보다 많다면
					System.out.println("대장간을 차려서 잘먹고 잘 살았답니다^^7");
					System.exit(0);
					break;
				} else if (Weapon.money < smithy) {// 보유금액이 대장간을 차릴 비용보다 적다면
					System.out.println("대장간을 차리려면" + (smithy - Weapon.money) + "만큼 돈이 부족한데여?");
					break;
				}

			}
		}
	}

	void start() { //강화게임 메서드
		int tier = 0;
		Upgrade: while (true) {
			System.out.println("강화할 무기를 선택해주세요> 1.검 2.도끼 3.창"); 
			System.out.println("\t1티어 평범한 검 = 50,000원");
			System.out.println("\t2티어 장인의 검 = 75,000원");
			System.out.println("\t3티어 명장의 검 = 100,000원");
			System.out.println("\t1티어 평범한 도끼 = 150,000원");
			System.out.println("\t2티어 장인의 도끼 = 400,000원");
			System.out.println("\t3티어 명장의 도끼 = 800,000원");
			System.out.println("\t1티어 평범한 창 = 1,000,000원");
			System.out.println("\t2티어 장인의 창 = 3,500,000원");
			System.out.println("\t3티어 명장의 창 = 10,000,000원");
			int sel = ScanUtil.nextInt(); //무기 종류 선택
			if (sel == 1 || sel == 2 || sel == 3) {
				System.out.println("강화할 무기의 티어를 선택해주세요! (1~3)티어");
				tier = ScanUtil.nextInt(); //무기의 티어 선택
			}
			switch (sel) {
			case 1:
				Sword sw = new Sword(tier);
				if (Weapon.money < sw.weaponPrice) { // 보유하고있는 돈보다 무기의 가격이 비싸다면
					System.out.println("보유하고있는 금액보다 강화하려는 무기의 금액이 비싸요!");
					break Upgrade;
				}
				System.out.println("[" + sw.rankName + "]" + sw.weaponName + "을(를) 구해왔어요");
				Weapon.money -= sw.weaponPrice; //보유하고있는 돈에서 무기의 가격을 뺌
				sw.upgrade(); //업그레이드 메서드 실행
				interest();   //무기강화가 끝나면 이자붙는 메서드 실행
				break Upgrade;
			case 2:
				Axe ax = new Axe(tier);
				if (Weapon.money < ax.weaponPrice) {
					System.out.println("보유하고있는 금액보다 강화하려는 무기의 금액이 비싸요!");
					break Upgrade;
				}
				System.out.println("[" + ax.rankName + "]" + ax.weaponName + "을(를) 구해왔어요");
				Weapon.money -= ax.weaponPrice;
				ax.upgrade();
				interest();
				break Upgrade;
			case 3:
				Spear sp = new Spear(tier);
				if (Weapon.money < sp.weaponPrice) {
					System.out.println("보유하고있는 금액보다 강화하려는 무기의 금액이 비싸요!");
					break Upgrade;
				}
				System.out.println("[" + sp.rankName + "]" + sp.weaponName + "을(를) 구해왔어요");
				Weapon.money -= sp.weaponPrice;
				sp.upgrade();
				interest();
				break Upgrade;
			}
		}
	}

	void interest() { // 이자
		if (loanMoney > 0) { //대출금이 있다면
			double interest = loanMoney * 0.1; 
			System.out.println("대출금에" + interest + "만큼의 이자가 붙었어요.");
			loanMoney += interest; // 대출금에 10%의 이자를 붙힘.
		}
	}
}
