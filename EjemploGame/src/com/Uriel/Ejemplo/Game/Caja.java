package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Caja extends GameObject{
	public Caja(float positionX, float positionY, int width, int height){
		super(positionX,positionY);
		super.width = width;
		super.height = height;
	}
	
	@Override
	public void init() {
		
	}
	
	public void Render(Graphics g) throws SlickException{
		super.boundingBox = new Rectangle(super.positionX, super.positionY, width, height);
		g.drawRect(super.positionX, super.positionY, width, height);
	}

	@Override
	public void Update(int delta) throws SlickException {
		
	}
}
