package com.Team.GameName.Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

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
	public void Init() throws SlickException {
		super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
	}
	@Override
	public void Render(Graphics g) throws SlickException {
		super.setBoundingBox();
		if(super.getCurrentAnimation() != null){
			if(super.getDirection() == Direction.Right)
				super.getCurrentAnimation().draw(super.getRealPositionX(), super.getRealPositionY(), super.getWidth(), super.getHeight());
			else
				super.getCurrentAnimation().draw(super.getRealPositionX()+super.getWidth(), super.getRealPositionY(), -super.getWidth(), super.getHeight());
		}
		this.applyDamage(g);
	}
	
	@Override
	public void Update(int delta) throws SlickException {
		super.getCurrentAnimation().update(delta);
		super.checkDead();
		if(super.getCurrentWeapon() != null){
			if(super.getDirection() == Direction.Right){
				super.getCurrentWeapon().setPositionX(super.getPositionX()+super.getWidth()+2);
				super.getCurrentWeapon().setDirection(Direction.Right);
			}else{
				super.getCurrentWeapon().setPositionX(super.getPositionX()-4);
				super.getCurrentWeapon().setDirection(Direction.Left);
			}
			super.getCurrentWeapon().setPositionY(super.getPositionY()+super.getHeight()/2.0f);
		}
		this.gravity(delta);
		MainCharacter player = checkSight();
		if (player != null){
			chase(delta, player);
		}else{
			returnPosition(delta);
		}
	}
	@Override
	public void attack() throws SlickException {
		((Sword)super.getCurrentWeapon()).swing();
	}
}
