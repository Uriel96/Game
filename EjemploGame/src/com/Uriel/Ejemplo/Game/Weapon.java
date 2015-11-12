package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class Weapon extends Rigid {
	
	protected int damage;
	protected int attackInterval;
	
	//Constructor
	public Weapon(int damage, int attackInterval) throws SlickException{
		this.damage = damage;
		this.attackInterval = attackInterval;
	}
	
	//DealDamage method reduces the life of the character according to the damage
	//of the weapon
	public int dealDamage(int damage, int life){
		
		life = life - damage;
		return life;
	}
	
	//Takes the attack interval and reduces it to zero, to not allow the player to 
	//attack for a period of time
	public boolean canAttack(int attackInterval){
		
		int time;
		
		time = attackInterval;
		
		for (int i = time; i > 0; i--) {
		}
		
		return true;
			}
	
	@Override
	public void init() throws SlickException {
	}

	@Override
	public void Render(Graphics g) throws SlickException {
	}

	@Override
	public void Update(int delta) throws SlickException {
	}

}
