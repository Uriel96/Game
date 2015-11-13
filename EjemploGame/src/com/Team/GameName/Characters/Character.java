package com.Team.GameName.Characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.GameObject;
import com.Team.GameName.Weapons.Weapon;

public abstract class Character extends GameObject{
	
	protected float health;
	protected Weapon currentWeapon;
	protected int currentState;
	protected Animation[] states;
	
	//CONSTRUCTORS
	public Character() throws SlickException {
		super();
		defineStates();
	}
	
	public Character(float positionX, float positionY) throws SlickException {
		super(positionX, positionY);
		defineStates();
	}
	
	public Character(float positionX, float positionY, int width, int height) throws SlickException {
		super(positionX, positionY, width, height);
		defineStates();
	}
	
	//ABSTRACT METHODS
	abstract void defineStates() throws SlickException;
}
