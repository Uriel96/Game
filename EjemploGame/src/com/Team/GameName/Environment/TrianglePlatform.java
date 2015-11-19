package com.Team.GameName.Environment;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

import com.Team.GameName.Utilities.Collision;
import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;



public class TrianglePlatform extends Rigid implements Collision{

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
	public void init() {
		
	}
	
	@Override
	public void Render(Controller controller, Graphics g) throws SlickException{
		float[] points = new float[6];
		switch(this.side){
			case DOWNLEFT:
				break;
			case DOWNRIGHT:
				break;
			case LEFT:
				points = new float[] {super.getPositionX(), super.getPositionY(), super.getPositionX(), super.getPositionY() + super.getHeight(), super.getPositionX() + super.getWidth(), super.getPositionY() + super.getHeight()};
				break;
			case RIGHT:
				points = new float[] {super.getPositionX() + super.getWidth(), super.getPositionY(), super.getPositionX(), super.getPositionY() + super.getHeight(), super.getPositionX() + super.getWidth(), super.getPositionY() + super.getHeight()};
				break;
		}
		super.setBoundingBox(new Polygon(points));
		g.draw(super.getBoundingBox());
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		//DO NOTHING
	}
	
}
