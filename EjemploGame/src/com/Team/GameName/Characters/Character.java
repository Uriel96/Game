package com.Team.GameName.Characters;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.GameObject;
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
	public boolean checkDead(Controller controller){
		if(this.getHealth() <= 0){
			controller.deleteControl();
			return true;
		}
		return false;
	}
	
	//GETTERS AND SETTERS
	public Weapon getCurrentWeapon(){
		return this.currentWeapon;
	}
	public void setCurrentWeapon(Weapon weapon){
		this.currentWeapon = weapon;
	}
	public float getHealth(){
		return currentHealth;
	}
	
	//ABSTRACT METHODS
	abstract void attack(Controller controller) throws SlickException;
	abstract void applyDamage(Graphics g) throws SlickException;
}
