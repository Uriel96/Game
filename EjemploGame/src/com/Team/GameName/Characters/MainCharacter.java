package com.Team.GameName.Characters;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.States;
import com.Team.GameName.Weapons.Pistol;
import com.Team.GameName.Weapons.Sword;

public class MainCharacter extends Character{
	//FIELDS
	private float jumpVelocity;
	
	//CONSTRUCTORS
	public MainCharacter(float positionX, float positionY) throws SlickException{
		super(positionX, positionY, 27, 35, 0.3f);
	}
	
	//IMPLEMENTED METHODS
	@Override
	public void init() throws SlickException {
		this.jumpVelocity = 2f;
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
		g.draw(super.getBoundingBox());
		this.applyDamage(g);
	}
	@Override
	public void Update(Controller controller, int delta) throws SlickException{
		super.getCurrentAnimation().update(delta);
		this.checkDead(controller);
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
	}
	@Override
	public void attack(Controller controller) throws SlickException {
		if(super.getCurrentWeapon() instanceof Sword){
			((Sword)super.getCurrentWeapon()).swing(controller);
		}else if(super.getCurrentWeapon() instanceof Pistol){
			((Pistol)super.getCurrentWeapon()).shoot(controller);
		}
	}
	@Override
	public void applyDamage(Graphics g) throws SlickException{
		g.setColor(Color.red);
		g.drawRect(super.getPositionX() + 5, super.getPositionY() - 11, 21, 6);
		if(super.getHealth() > 0){
			g.setColor(Color.green);
			g.fillRect(super.getPositionX() + 5, super.getPositionY() - 10, super.getHealth() * 0.2f, 5);
		}
		g.setColor(Color.white);
	}

	//METHODS
	public void moverse(Controller controller, GameContainer gc, float delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_W)){
			this.jump();
		}else if(input.isKeyPressed(Input.KEY_SPACE)){
			if(super.getCurrentWeapon() != null){
				if(super.getCurrentWeapon().canAttack()){
					this.attack(controller);
					super.setCurrentAnimation(States.PLAYERATTACK.getAnimation());
				}
			}
		}else if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_D)){
			if(input.isKeyDown(Input.KEY_A)){
				super.setDirection(Direction.Left);
			}
			if(input.isKeyDown(Input.KEY_D)){
				super.setDirection(Direction.Right);
			}
			this.move(controller, delta);
			super.setCurrentAnimation(States.PLAYERWALK.getAnimation());
		}else{
			super.setCurrentAnimation(States.PLAYERSTAND.getAnimation());
		}
		this.gravity(controller, delta);
	}
	public void jump(){
		super.setInicialVelocityY(jumpVelocity);
	}
	@Override
	public boolean checkDead(Controller controller){
		if(super.checkDead(controller)){
			controller.gameOver = true;
			return true;
		}
		return false;
	}
}
