package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Characters.Character;
import com.Team.GameName.Utilities.Controller;

public class Sword extends Weapon{
	
	public Sword(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 15, 5, 5, 0.2f);
	}

	public void swing() throws SlickException{
		currentTime = attackInterval;
		dealDamage();
	}
	
	@Override
	public void dealDamage() throws SlickException{
		Character ch = Controller.checkCollision(this, 0, 0, Character.class);
		if(ch != null){
			ch.takeAwayHealth(this.damage);
		}
	}

	@Override
	public void Init() throws SlickException {
		
	}

	@Override
	public void Render(Graphics g) throws SlickException {
		
	}
	
}
