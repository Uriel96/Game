package com.Team.GameName.Weapons;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;


public abstract class Sword extends Weapon {

	public int damage;
	public int attackInterval;
	public int instance;
	
	
	//Constructor
	public Sword(int damage, int attackInterval) throws SlickException {
		super(damage, attackInterval);
	}
	
	public void Swing(Controller controller, Character character) throws SlickException{
		//Check collision, if true the sword deals damage
		controller.checkListCollision(character, 10, 0);
		dealDamage(super.damage, character); //Get health from the character
	}
}
