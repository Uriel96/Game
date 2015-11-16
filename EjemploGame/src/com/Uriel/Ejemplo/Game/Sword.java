package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.SlickException;

public class Sword extends Weapon {

	int damage;
	int attackInterval;
	
	//Constructor
	public Sword(int damage, int attackInterval) throws SlickException {
		super(damage, attackInterval);
	}
	
	public void Swing(Control controller){
		//Check collision, if true the sword deals damage
		if(controller.checkCollision(this, 0, 0,Character.class))
			dealDamage(damage, health) //Get health from the character
	}
}
