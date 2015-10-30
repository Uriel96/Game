package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Caja extends GameObject{
	public Caja(float positionX, float positionY){
		super(positionX,positionY);
	}
	
	public void Update(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		super.boundingBox = new Rectangle(super.positionX, super.positionY, 30, 30);
		g.drawRect(super.positionX, super.positionY, 30, 30);
	}
}
