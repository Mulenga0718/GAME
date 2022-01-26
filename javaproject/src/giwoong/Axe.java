package giwoong;

class Axe extends Weapon {
	Axe(int tier) {
		super(tier);
		if (tier == 1) {
			weaponName = "평범한 도끼";
			upgradePercent = 80;
			destroy = 4;
			weaponPrice = 150000;
			upgradePrice = 15000;
			rankName = rank[rankNum];
		} else if (tier == 2) {
			weaponName = "장인의 도끼";
			upgradePercent = 70;
			destroy = 5;
			weaponPrice = 400000;
			upgradePrice = 40000;
			rankName = rank[rankNum];
		} else if (tier == 3) {
			weaponName = "명장의 도끼";
			upgradePercent = 60;
			destroy = 6;
			weaponPrice = 800000;
			upgradePrice = 80000;
			rankName = rank[rankNum];
		}
	}
}