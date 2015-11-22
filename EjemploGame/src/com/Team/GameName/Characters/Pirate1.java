package com.Team.GameName.Characters;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.States;
import com.Team.GameName.Weapons.Pistol;

public class Pirate1 extends Enemy{
	//CONSTRUCTORS
	public Pirate1(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 27, 35, 0.2f, 300, 150);
	}
	public Pirate1(float positionX, float positionY, float health) throws SlickException {
		super(positionX, positionY, 27, 35, 0.2f, 300, 150, health);
	}

	//IMPLEMENTED METHODS
	@Override
	public void Init() throws SlickException {
		super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
		super.setCurrentWeapon(new Pistol(0,0));
}
	
	@Override
	public void Update(int delta) throws SlickException {
		super.Update(delta);
		this.gravity(delta);
		MainCharacter player = checkSight();
		if (player != null){
			chase(delta, player);
		}else{
			returnPosition(delta);
		}
	}
}
