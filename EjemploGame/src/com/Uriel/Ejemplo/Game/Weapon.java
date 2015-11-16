package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.util.Timer;
import java.util.TimerTask;

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
	public int dealDamage(int damage, Character character){
		character.health = health - damage;
		return health;
		Rigid hola;
		if(hola instanceof MainCharacter)
		else if(hola instanceof )
	}
	
	/*Takes the attack interval and reduces it to zero, to not allow the player to 
	attack for a period of time*/
	public boolean canAttack(int attackInterval){
		
		Timer timer = new Timer();
		 timer.scheduleAtFixedRate(new TimerTask() {
	            int i = attackInterval;
	            public void run() {
	                if (i< 0)
	                    timer.cancel();
	            }
	        }, 0, 1000);
		
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
