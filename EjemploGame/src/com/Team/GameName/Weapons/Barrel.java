package com.Team.GameName.Weapons;

import java.util.LinkedList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;

public class Barrel extends Weapon {

	public Barrel(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 40, 25, 20, 1f);
	}

	public void explode(Controller controller){
		LinkedList<Character> ch = controller.checkRangeList(this, this.getPositionX(), this.getPositionY(), 100,Character.class);
		
		for(Character object : ch){
			object.takeAwayHealth(this.damage);
		}
		controller.remove(this);
	}

	@Override
	public void dealDamage(Controller controller) throws SlickException {
		
	}

	@Override
	public void init() throws SlickException {
		
	}

	@Override
	public void Render(Controller controller, Graphics g) throws SlickException {
		super.setBoundingBox();
		g.draw(super.getBoundingBox());
	}
}