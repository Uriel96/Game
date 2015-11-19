package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.Team.GameName.Characters.Character;

import com.Team.GameName.Utilities.Controller;

public class Sword extends Weapon{
	
	public Sword(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 15, 5, 5, 0.2f);
	}

	public void swing(Controller controller) throws SlickException{
		currentTime = attackInterval;
		dealDamage(controller);
	}
	
	@Override
	public void dealDamage(Controller controller) throws SlickException{
		Character ch = controller.checkCollision(this, 0, 0, Character.class);
		if(ch != null){
			ch.takeAwayHealth(this.damage);
		}
	}

	@Override
	public void init() throws SlickException {
		
	}

	@Override
	public void Render(Controller controller, Graphics g) throws SlickException {
		
		super.setBoundingBox();
		if(super.getDirection() == Direction.Right){
			g.draw(super.getBoundingBox());
		}else{
			g.draw(super.getBoundingBox());
		}
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		super.Update(controller, delta);
	}
	
}
