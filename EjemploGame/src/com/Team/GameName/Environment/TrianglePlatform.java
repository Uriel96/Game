package com.Team.GameName.Environment;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

public class TrianglePlatform extends Platform{

	protected float angle;
	protected Side side;
	
	public enum Side{
		RIGHT, LEFT, DOWNRIGHT, DOWNLEFT
	}
	
	public TrianglePlatform(float positionX, float positionY, int width, int height, Side side) throws SlickException{
		super(positionX, positionY, width, height);
		this.angle = (float) Math.abs(Math.atan2(width, height));
		this.side = side;
	}
	
	public int getAngle(){
		return (int) (angle * 180 / Math.PI);
	}
	
	@Override
	public void Init() {
		
	}
	
	@Override
	public void Render(Graphics g) throws SlickException{
		float posX = super.getPositionX();
		float posY = super.getPositionY();
		float[] points = new float[6];
		switch(this.side){
			case DOWNLEFT:
				break;
			case DOWNRIGHT:
				break;
			case LEFT:
				points = new float[] {posX, posY, posX, posY + super.getHeight(), posX + super.getWidth(), posY + super.getHeight()};
				break;
			case RIGHT:
				points = new float[] {posX + super.getWidth(), posY, posX, posY + super.getHeight(), posX + super.getWidth(), posY + super.getHeight()};
				break;
		}
		super.setBoundingBox(new Polygon(points));
}

	@Override
	public void Update(int delta) throws SlickException {
		//DO NOTHING
	}
	
}
