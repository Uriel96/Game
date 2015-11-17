package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import com.Team.GameName.Characters.Character;

import com.Team.GameName.Utilities.Controller;

public class Sword extends Weapon{
	public Sword() throws SlickException {
		super(5,0.2f);
	}

	public void swing(Controller controller) throws SlickException{
		currentTime = attackInterval;
		dealDamage(controller);
	}

	@Override
	public void init() throws SlickException {
		super.width = 15;
		super.height = 5;
	}

	@Override
	public void Render(Graphics g, Controller controller) throws SlickException {
		if(currentDirection == Direction.Right){
			g.drawRect(positionX, positionY, width, height);
		}else{
			g.drawRect(positionX, positionY, -width, height);
		}
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		super.Update(controller, delta);
	}
	
}
