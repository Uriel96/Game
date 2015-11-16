package com.Team.GameName.Weapons;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Characters.Character;


public class Barrel extends Weapon {

	public Barrel(int damage, int attackInterval) throws SlickException {
		super(damage, attackInterval);
	}
	
	public void explode(Controller controller, Pistol pistol, Barrel barrel, Character character){
		if(pistol.intersects(barrel)){
			controller.checkRange(character, 0, 0, 50);
			dealDamage(super.damage, character);
		}
		
	}

	@Override
	public void init() throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
}
