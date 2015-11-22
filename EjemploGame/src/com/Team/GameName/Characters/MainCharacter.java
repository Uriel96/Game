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
	private Sword sword;
	private Pistol pistol;
	
	//CONSTRUCTORS
	public MainCharacter(float positionX, float positionY) throws SlickException{
		super(positionX, positionY, 27, 35, 0.3f);
	}
	
	//IMPLEMENTED METHODS
	@Override
	public void Init() throws SlickException {
		this.jumpVelocity = 2f;
		this.setPistol(new Pistol(0,0));
		this.setSword(new Sword(0,0));
		this.getPistol().notVisible();
		this.getSword().notVisible();
		this.setCurrentWeapon(this.getPistol());
	}
	/*
	@Override
	public void attack() throws SlickException {
		if(super.getCurrentWeapon() instanceof Sword){
			((Sword)super.getCurrentWeapon()).swing();
		}else if(super.getCurrentWeapon() instanceof Pistol){
			((Pistol)super.getCurrentWeapon()).shoot();
		}
	}
	*/
	@Override
	public void applyDamage(Graphics g) throws SlickException{
		g.setColor(Color.red);
		g.drawRect(this.getRealPositionX() + 5, this.getRealPositionY() - 11, 21, 6);
		if(super.getHealth() > 0){
			g.setColor(Color.green);
			g.fillRect(this.getRealPositionX() + 5, this.getRealPositionY() - 10, super.getHealth() * 0.2f, 5);
		}
		g.setColor(Color.white);
	}

	//METHODS
	public void moverse(GameContainer gc, float delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_W)){
			this.jump();
		}else if(input.isKeyPressed(Input.KEY_SPACE)){
			if(super.getCurrentWeapon() != null){
				if(super.getCurrentWeapon().canAttack()){
					this.attack();
					super.setCurrentAnimation(States.PLAYERATTACK.getAnimation());
				}
			}
		}else if(input.isKeyPressed(Input.KEY_1)){
			if(pistol != null){
				super.setCurrentWeapon(pistol);
				pistol.setVisible();
				if(sword != null){
					sword.notVisible();
				}
			}
		}else if(input.isKeyPressed(Input.KEY_2)){
			if(sword != null){
				super.setCurrentWeapon(sword);
				sword.setVisible();
				if(pistol != null){
					pistol.notVisible();
				}
			}
		}else if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_D)){
			if(input.isKeyDown(Input.KEY_A)){
				super.setDirection(Direction.Left);
			}
			if(input.isKeyDown(Input.KEY_D)){
				super.setDirection(Direction.Right);
			}
			this.move(delta);
			super.setCurrentAnimation(States.PLAYERWALK.getAnimation());
		}else{
			super.resetCurrentVelocity();
			super.setCurrentAnimation(States.PLAYERSTAND.getAnimation());
		}
		this.gravity(delta);
	}
	public void jump(){
		super.setInicialVelocityY(jumpVelocity);
	}
	
	public boolean checkDead(){
		if(super.getHealth() <= 0){
			Controller.GameOver();
			return true;
		}
		return false;
	}
	
	//GETTERS AND SETTERS
	public Sword getSword() {
		return sword;
	}

	public void setSword(Sword sword) {
		Controller.add(sword);
		this.sword = sword;
	}

	public Pistol getPistol() {
		return pistol;
	}

	public void setPistol(Pistol pistol) {
		Controller.add(pistol);
		this.pistol = pistol;
	}
}
