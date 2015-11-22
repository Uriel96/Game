package com.Team.GameName.Weapons;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Rigid;

public abstract class Weapon extends Rigid {
	//FIELDS
	protected int damage;
	protected float attackInterval;
	protected float currentTime = 0;

	//CONSTRUCTORS
	public Weapon(float positionX, float positionY, int width, int height) throws SlickException{
		super(positionX, positionY, width, height);
	}
	
	public Weapon(float positionX, float positionY, int width, int height, int damage, float attackInterval) throws SlickException{
		super(positionX, positionY, width, height);
		this.damage = damage;
		this.attackInterval = attackInterval;
	}
	
	/**
	DealDamage method reduces the life of the character according to the damage
	of the weapon
	*/
	public abstract void dealDamage() throws SlickException;
	
	/**
	Takes the attack interval and reduces it to zero, to not allow the player to 
	attack for a period of time
	*/
	public boolean canAttack(){
		return currentTime <= 0;
	}
	
	@Override
	public void Update(int delta) throws SlickException {
		if(currentTime >= 0){
			currentTime -= delta / 1000f;
		}
	}

}