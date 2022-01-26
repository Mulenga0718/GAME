package giwoong;

class Spear extends Weapon {
	Spear(int tier) {
		super(tier);
		if (tier == 1) {
			weaponName = "평범한 창";
			upgradePercent = 65;
			destroy = 7;
			weaponPrice = 1000000;
			upgradePrice = 100000;
			rankName = rank[rankNum];
		} else if (tier == 2) {
			weaponName = "장인의 창";
			upgradePercent = 55;
			destroy = 8;
			weaponPrice = 3500000;
			upgradePrice = 350000;
			rankName = rank[rankNum];
		} else if (tier == 3) {
			weaponName = "명장의 창";
			upgradePercent = 45;
			destroy = 9;
			weaponPrice = 10000000;
			upgradePrice = 1000000;
			rankName = rank[rankNum];
		}
	}
}