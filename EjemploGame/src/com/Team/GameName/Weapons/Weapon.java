package com.Team.GameName.Weapons;

public class Weapon {

	protected float attackInterval;
	protected float currentTime;
	public boolean canAttack() {
		return currentTime < attackInterval;
	}

}
