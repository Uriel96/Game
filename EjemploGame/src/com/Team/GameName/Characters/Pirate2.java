package com.Team.GameName.Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.States;
import com.Team.GameName.Weapons.Sword;

public class Pirate2 extends Enemy{
	//CONSTRUCTORS
	public Pirate2(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 27, 35, 0.2f, 150, 30);
	}
	public Pirate2(float positionX, float positionY, float health) throws SlickException {
		super(positionX, positionY, 27, 35, 0.2f, 150, 30, health);
	}

	//IMPLEMENTED METHODS
	@Override
	public void init() throws SlickException {
		super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
	}
	@Override
	public void Render(Controller controller, Graphics g) throws SlickException {
		super.setBoundingBox();
		if(super.getCurrentAnimation() != null){
			if(super.getDirection() == Direction.Right)
				super.getCurrentAnimation().draw(super.getPositionX(), super.getPositionY(), super.getWidth(), super.getHeight());
			else
				super.getCurrentAnimation().draw(super.getPositionX()+super.getWidth(), super.getPositionY(), -super.getWidth(), super.getHeight());
		}
		this.applyDamage(g);
		g.draw(super.getBoundingBox());
	}
	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		super.getCurrentAnimation().update(delta);
		if(super.getDirection() == Direction.Right){
			super.getCurrentWeapon().setPositionX(super.getPositionX()+super.getWidth()+2);
			super.getCurrentWeapon().setDirection(Direction.Right);
		}else{
			super.getCurrentWeapon().setPositionX(super.getPositionX()-4);
			super.getCurrentWeapon().setDirection(Direction.Left);
		}
		super.getCurrentWeapon().setPositionY(super.getPositionY()+super.getHeight()/2.0f);
		this.gravity(controller, delta);
		MainCharacter player = checkSight(controller);
		if (player != null)
			chase(controller, delta, player);
		else
			returnPosition(controller, delta);
	}
	@Override
	public void attack(Controller controller) throws SlickException {
		((Sword)super.getCurrentWeapon()).swing(controller);
	}
}
