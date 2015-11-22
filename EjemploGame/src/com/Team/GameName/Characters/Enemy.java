package com.Team.GameName.Characters;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.States;;

public abstract class Enemy extends Character{
	//FIELDS
	private float inicialPositionX;
	private float visionRange;
	private float attackRange;
	
	//CONSTRUCTOR
	public Enemy(float positionX, float positionY, int width, int height, float maxVelocityX) throws SlickException {
		super(positionX, positionY, width, height, maxVelocityX);
		this.inicialPositionX = super.getPositionX();
	}
	public Enemy(float positionX, float positionY, int width, int height, float maxVelocityX, float visionRange, float attackRange) throws SlickException {
		this(positionX, positionY, width, height, maxVelocityX);
		this.visionRange = visionRange;
		this.attackRange = attackRange;
	}
	public Enemy(float positionX, float positionY, int width, int height, float maxVelocityX, float visionRange, float attackRange, float health) throws SlickException {
		super(positionX, positionY, width, height, maxVelocityX, health);
		this.inicialPositionX = super.getPositionX();
		this.visionRange = visionRange;
		this.attackRange = attackRange;
	}
	
	//IMPLEMENTED METHODS
	@Override
	public void applyDamage(Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawRect(this.getRealPositionX() + 5, this.getRealPositionY() - 11, 21, 6);
		if(super.getHealth() > 0){
			g.setColor(Color.green);
			g.fillRect(this.getRealPositionX() + 5, this.getRealPositionY() - 10, super.getHealth() * 0.2f, 5);
		}
		g.setColor(Color.white);
	}
	@Override
	public boolean checkDead(){
		if(this.getHealth() <= 0){
			Controller.deleteControl(this);
			return true;
		}
		return false;
	}
	
	//METHODS
	public MainCharacter checkSight(){
		MainCharacter playerCast = Controller.doRayCast(this, this.visionRange, 400, MainCharacter.class);
		MainCharacter playerRange = Controller.checkRange(this, super.getPositionX(), super.getPositionY(), this.visionRange, MainCharacter.class);
		if(playerCast != null && playerRange != null && playerCast == playerRange)
			return playerCast;
		else
			return null;
	}
	public void chase(float delta, MainCharacter player) throws SlickException{
		if(Controller.getRange(this, player) > this.attackRange)
		{
			if(player.getPositionX() > super.getPositionX()){
				super.setDirection(Direction.Right);
				
				this.move(delta);
				super.setCurrentAnimation(States.ENEMYWALK.getAnimation());
			}else if(player.getPositionX() < super.getPositionX()){
				super.setDirection(Direction.Left);
				this.move(delta);
				super.setCurrentAnimation(States.ENEMYWALK.getAnimation());
			}else{
				super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
			}
		}else{
			if(super.getCurrentWeapon() != null){
				if(super.getCurrentWeapon().canAttack()){
					this.attack();
					super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
				}
			}
		}
	}
	public void returnPosition(float delta) throws SlickException{
		if(!moveTo(delta, inicialPositionX, 6)){
			super.setCurrentAnimation(States.ENEMYWALK.getAnimation());
		}else{
			super.resetCurrentVelocity();
			super.setCurrentAnimation(States.ENEMYSTAND.getAnimation());
		}
		
	}

	//GETTERS AND SETTERS
	public float getInicialPositionX() {
		return inicialPositionX;
	}
	public void setInicialPositionX(float inicialPositionX) {
		this.inicialPositionX = inicialPositionX;
	}
	public float getVisionRange() {
		return visionRange;
	}
	public void setVisionRange(float visionRange) {
		this.visionRange = visionRange;
	}
	public float getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(float attackRange) {
		this.attackRange = attackRange;
	}
}
