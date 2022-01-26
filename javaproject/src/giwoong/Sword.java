package giwoong;

class Sword extends Weapon {
	Sword(int tier) {
		super(tier);
		if (tier == 1) {
			weaponName = "평범한 검";
			upgradePercent = 95;
			destroy = 1;
			weaponPrice = 50000;
			upgradePrice = 5000;
			rankName = rank[rankNum];
		} else if (tier == 2) {
			weaponName = "장인의 검";
			upgradePercent = 85;
			destroy = 2;
			weaponPrice = 75000;
			upgradePrice = 7500;
			rankName = rank[rankNum];
		} else if (tier == 3) {
			weaponName = "명장의 검";
			upgradePercent = 75;
			destroy = 3;
			weaponPrice = 100000;
			upgradePrice = 10000;
			rankName = rank[rankNum];
		}
	}

}