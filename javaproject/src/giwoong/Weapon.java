package giwoong;

import e_oop1.ScanUtil;

class Weapon { // 부모클래스

	int destroy; //무기별 파괴확률
	int sel; //무기 종류
	int tier; //무기 티어
	int rankNum = 0; //무기 등급을 가르키는 숫자
	static long money = 100000;
	String rankName; //무기등급을 저장할 String 타입
	String[] rank = { "일반", "고급", "희귀", "레어", "전설", "유물" }; // 무기 등급
	int upgradePercent; // 강화 성공확률
	int destroyPercent; // 터질확률 랜덤
	int percent; // 랜덤
	long weaponPrice;//무기가격
	int upgradePrice;//강화비용
	String weaponName;//무기 이름

	Weapon(int tier) {
		this.tier = tier;
	}

	void upgrade() {
		{
			Upgrade: while (true) {
				percent = (int) (Math.random() * 101); // 무기강화 확률 랜덤변수
				System.out.println("1. 강화하기 2. 팔기 3. 정보");
				sel = ScanUtil.nextInt(); //선택지 선택
				switch (sel) {
				case 1:
					if (rankNum == 5) { // 만약 최고등급이면
						System.out.println("강화대상인 장비가 이미 최고등급이라 더이상 강화 할 수 없어요.");
						break;
					}
					if (money < upgradePrice) { // 보유금액이 강화비용보다 적으면
						System.out.println("강화비용이 부족해서 강화할 수 없어요,,");
						break;
					}
					if (upgradePercent > percent) {//무기강화 성공의 변수가 무기강화 랜덤변수보다 크면
						System.out.println("강화성공!");
						System.out.print("[" + rankName + "]" + weaponName + "이 ");
						if (rankNum >= 5) { //만약 무기가 최고등급이면
							rankNum = 5;    //최고등급 유지
						} else { //아니면
							rankNum++; //등급 상승
						}
						rankName = rank[rankNum]; //등급 배열의 등급 숫자에 해당하는 값을 rankName으로 저장
						System.out.println("[" + rankName + "]" + weaponName + "으로 강화되었어요!");
						upgradePercent -= 10; //강화확률 10퍼 하락
						money -= upgradePrice; // 보유금에서 강화비용 차감
						upgradePrice *= 1.5; //강화비용은 1.5배상승
						weaponPrice *= 1.5; // 무기가격도 1.5배 상승
						destroy += 3; //파괴확률 3퍼증가
					} else if (upgradePercent < percent) {//강화실패시
						money -= upgradePrice; //돈에서 강화비용은 차감
						destroyPercent = (int) (Math.random() * 101); //파괴될 확률 랜덤변수
						if (destroyPercent < destroy) { // 만약 랜덤변수가 파괴확률보다 작으면
							System.out.println("강화실패,,, 강화실패로 인해 장비가 파괴되었어요. ^-^;;");
							break Upgrade;
						} else {//아니면 그냥 실패 변화없음.
							System.out.println("강화실패,,,");
						}
					}
					break;
				case 2:
					System.out.println(weaponName + "을(를)" + weaponPrice + "에 팔았어요!"); //무기팔기
					Weapon.money += weaponPrice; //보유금에서 무기가격 추가
					break Upgrade;
				case 3: //현재 무기정보
					System.out.println("==========================================");
					System.out.println("강화중인 무기 : " + "[" + rankName + "]" + weaponName);
					System.out.println("현재 강화확률 : " + upgradePercent + "%");
					System.out.println("현재 파괴확률 : " + destroy + "%");
					System.out.println("현재 강화비용 : " + upgradePrice);
					System.out.println("판매시 가격 : " + weaponPrice);
					System.out.println("현재 보유금액 : " + money);
					System.out.println("==========================================");
					break;
				}
			}
		}
	}

	void moneyInfo() { //돈 확인
		System.out.println("보유금 : " + money);
	}
}
