package com.Team.GameName.Weapons;

import java.util.LinkedList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;

public class Barrel extends Weapon {
	//FIELDS
	private float range;
	
	//CONSTRUCTORS
	public Barrel(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 40, 25, 50, 1f);
	}

	//METHODS
	public void explode(){
		LinkedList<Character> ch = Controller.checkRangeList(this, this.getPositionX(), this.getPositionY(), this.range,Character.class);
		if(ch != null){
			for(Character object : ch){
				object.takeAwayHealth(this.damage);
			}
		}
		Controller.deleteControl(this);
	}

	@Override
	public void dealDamage() throws SlickException {
		
	}

	@Override
	public void Init() throws SlickException {
		this.range = 80;
	}

	@Override
	public void Render(Graphics g) throws SlickException {
		super.setBoundingBox();
	}
}