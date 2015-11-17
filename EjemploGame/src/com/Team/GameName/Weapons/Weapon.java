package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;

public abstract class Weapon extends Rigid {
	
	protected int damage;
	protected float attackInterval;
	protected float currentTime = 0;
	
	/*
	protected float attackInterval = 0.2f;
	protected float currentTime = 0;
	
	public Weapon() throws SlickException {
		super();
	}
	
	public boolean canAttack() {
		return currentTime <= 0;
	}
	*/
	
	//Constructor
	public Weapon(int damage, float attackInterval) throws SlickException{
		super();
		this.damage = damage;
		this.attackInterval = attackInterval;
	}
	
	//DealDamage method reduces the life of the character according to the damage
	//of the weapon
	public void dealDamage(Controller controller) throws SlickException{
		Character ch = (Character)controller.checkCollision(this, 0, 0,Character.class);
		if(ch != null){
			ch.takeAwayLife(this.damage);
		}
	}
	
	//Takes the attack interval and reduces it to zero, to not allow the player to 
	//attack for a period of time
	public boolean canAttack(){
		return currentTime <= 0;
	}
	
	@Override
	public void init() throws SlickException {
	}

	@Override
	public void Render(Graphics g, Controller controller) throws SlickException {
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		if(currentTime >= 0){
			currentTime -= delta / 1000f;
		}
	}

}