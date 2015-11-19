package com.Team.GameName.Utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import com.Team.GameName.Utilities.Rigid.Direction;

public class Controller extends ArrayList<Rigid>{
	
	public Iterator<Rigid> i;
	public boolean gameOver = false;
	
	public int positionX = 0;
	public int positionY = 0;
	public int score = 0;

	public int width;
	public int height;
	
	public Controller(int w, int h){
		width = w;
		height = h;
	}
	
	public <T> T checkCollision(Rigid ob, float deltaX, float deltaY, Class<T> cls) throws SlickException{
		ob.setBoundingBox(new Rectangle(ob.getPositionX()+deltaX,ob.getPositionY()+deltaY,32,32));
		for(Rigid other : this){
			if(ob != other && cls.isInstance(other) && ob.intersects(other)){
				return cls.cast(other);
			}
		}
		return null;
	}
	
	public <T> LinkedList<T> checkCollisionList(Rigid ob, float deltaX, float deltaY, Class<T> cls) throws SlickException{
		ob.setBoundingBox(new Rectangle(ob.getPositionX()+deltaX,ob.getPositionY()+deltaY,32,32));
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : this){
			if(ob != other && ob.intersects(other)){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}
	
	public <T> T doRayCast(Rigid ob, float rayX, float rayY, float range, Class<T> cls) {
		Rectangle ray = new Rectangle(ob.getDirection() == Direction.Right ? rayX : rayX-range, rayY,range, 3);
		for(Rigid other : this){
			if(ob != other && cls.isInstance(other) && ray.intersects(other.getBoundingBox())){
				return cls.cast(other);
			}
		}
		return null;
	}
	
	public <T> LinkedList<T> doRayCastList(Rigid ob, float rayX, float rayY, float range, Class<T> cls) {
		
		Rectangle ray = new Rectangle(rayX, rayY, ob.getDirection() == Direction.Right ? range : -range, 3);
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : this){
			if(ob != other && cls.isInstance(other) && ray.intersects(other.getBoundingBox())){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}

	public <T> LinkedList<T> checkRangeList(Rigid ob, float rangeX, float rangeY, float radius, Class<T> cls) {
		Circle range = new Circle(rangeX, rangeY, radius);
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : this){
			if(ob != other && cls.isInstance(other) && range.intersects(other.getBoundingBox())){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}
	
	public <T> T checkRange(Rigid ob, float rangeX, float rangeY, float radius, Class<T> cls) {
		Circle range = new Circle(rangeX,rangeY,radius);
		for(Rigid other : this){
			if(ob != other && cls.isInstance(other) && range.intersects(other.getBoundingBox())){
				return cls.cast(other);
			}
		}
		return null;
	}
	
	public float getRange (Rigid ob, Rigid target) {
		return (float) Math.sqrt(Math.pow(ob.getPositionX() - target.getPositionX(), 2) + Math.pow(ob.getPositionY() - target.getPositionY(), 2));
	}
	
	public void deleteControl() {
		this.i.remove();
	}
	
	public <T> boolean deleteControl(Class<T> cls) {
		boolean found = false;
		for(Rigid other : this){
			if (cls.isInstance(other)) {
				this.remove(other);
				found = true;
			}
		}
		return found;
	}
	
	public void moveCamera(float deltaX, float deltaY) {
		if (positionX + deltaX >= 0 && positionX + deltaX <= width) {
			positionX += deltaX;
		} else {
			positionX += deltaX;
			this.get(0).setPositionX(this.get(0).getPositionX() + deltaX);
		}
		if (positionY + deltaY >= 0 && positionY + deltaY <= height) {
			positionY += deltaY;
		} else {
			positionY += deltaY;
			this.get(0).setPositionY(this.get(0).getPositionY() + deltaY);
		}
	}
	
	public void giveScore(int points) {
		score += points;
	}
}