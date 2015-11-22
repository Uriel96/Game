package com.Team.GameName.Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.GameObject;
import com.Team.GameName.Weapons.Pistol;
import com.Team.GameName.Weapons.Sword;
import com.Team.GameName.Weapons.Weapon;

public abstract class Character extends GameObject{
	//FIELDS
	private float maxHealth = 100;
	private float currentHealth = 100;
	private Weapon currentWeapon;
	
	//CONSTRUCTORS
	public Character() throws SlickException {
		super();
	}
	public Character(float positionX, float positionY) throws SlickException {
		super(positionX, positionY);
	}
	public Character(float positionX, float positionY, int width, int height, float maxVelocityX) throws SlickException {
		super(positionX, positionY, width, height, maxVelocityX);
	}
	public Character(float positionX, float positionY, int width, int height, float maxVelocityX, float health) throws SlickException {
		super(positionX, positionY, width, height, maxVelocityX);
		this.maxHealth = health;
		this.currentHealth = health;
	}
	
	//IMPLEMENTED METHODS
	@Override
	public void Render(Graphics g) throws SlickException {
		super.setBoundingBox();
		this.applyDamage(g);
		if(super.getCurrentAnimation() != null){
			if(super.getDirection() == Direction.Right)
				super.getCurrentAnimation().draw(super.getRealPositionX(), super.getRealPositionY(), super.getWidth(), super.getHeight());
			else
				super.getCurrentAnimation().draw(super.getRealPositionX()+super.getWidth(), super.getRealPositionY(), -super.getWidth(), super.getHeight());
		}
	}
	@Override
	public void Update(int delta) throws SlickException{
		super.getCurrentAnimation().update(delta);
		this.checkDead();
		if(this.getCurrentWeapon() != null){
			if(this.getDirection() == Direction.Right){
				this.getCurrentWeapon().setPositionX(this.getPositionX()+super.getWidth()+2);
				this.getCurrentWeapon().setDirection(Direction.Right);
			}else{
				this.getCurrentWeapon().setPositionX(this.getPositionX()-this.getCurrentWeapon().getWidth()-4);
				this.getCurrentWeapon().setDirection(Direction.Left);
			}
			this.getCurrentWeapon().setPositionY(super.getPositionY()+super.getHeight()/2.0f);
		}
	}
	
	//METHODS
	public void takeAwayHealth(float damage){
		this.currentHealth -= damage;
	}
	public void addHealth(float moreHealth){
		this.currentHealth += moreHealth;
		if(this.currentHealth > this.maxHealth){
			this.currentHealth = this.maxHealth;
		}
	}
	public void attack() throws SlickException {
		if(this.getCurrentWeapon() instanceof Sword){
			if(((Sword)this.getCurrentWeapon()).canAttack()){
				((Sword)this.getCurrentWeapon()).swing();
			}
		}else if(this.getCurrentWeapon() instanceof Pistol){
			if(((Pistol)this.getCurrentWeapon()).canAttack()){
				((Pistol)this.getCurrentWeapon()).shoot();
			}
		}
	}
	
	//GETTERS AND SETTERS
	public Weapon getCurrentWeapon(){
		return this.currentWeapon;
	}
	public void setCurrentWeapon(Weapon weapon){
		Controller.add(weapon);
		weapon.setVisible();
		this.currentWeapon = weapon;
	}
	public float getHealth(){
		return currentHealth;
	}
	
	//ABSTRACT METHODS
	abstract void applyDamage(Graphics g) throws SlickException;
	abstract boolean checkDead();
}
