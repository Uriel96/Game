package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Triangulo extends GameObject{

	protected float angle;
	
	public Triangulo(float positionX, float positionY, int width, int height){
		super(positionX,positionY);
		super.width = width;
		super.height = height;
		angle = (float) (Math.atan2(width,height));
	}
	
	@Override
	public void Update() throws SlickException {
		
	}
	
	public void Update(GameContainer gc, StateBasedGame sbg, Graphics g){
		super.boundingBox = new Polygon(new float[]{positionX,positionY,positionX,positionY+height,positionX+width,positionY+height});
		g.draw(super.boundingBox);
	}
	
}
