package com.Team.GameName.Weapons;

import org.lwjgl.input.Controller;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;

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
	public void dealDamage(int damage, Character character){
		
		int health;
		
		health = character.GetHealth; //Takes the health of the character
		character.SetHealth(health-damage);//Reduces the health of the character 
		
		/*character.health = health - damage;
		return health;
		Rigid hola;
		if(hola instanceof MainCharacter)
		else if(hola instanceof )*/
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
}


