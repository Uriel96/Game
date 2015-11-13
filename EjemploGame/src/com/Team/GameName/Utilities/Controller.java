package com.Team.GameName.Utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Controller extends ArrayList<Rigid>{
	
	public Controller(){
		
	}
	
	public Rigid checkCollision(Rigid ob, float deltaX, float deltaY) throws SlickException{
		ob.boundingBox = new Rectangle(ob.positionX+deltaX,ob.positionY+deltaY,32,32);
		for(Rigid other : this){
			if(ob != other && ob.intersects(other)){
				return other;
			}
		}
		return null;
	}
	
	public LinkedList<Rigid> checkListCollision(Rigid ob, float deltaX, float deltaY) throws SlickException{
		ob.boundingBox = new Rectangle(ob.positionX+deltaX,ob.positionY+deltaY,32,32);
		LinkedList<Rigid> list = new LinkedList<Rigid>();
		for(Rigid other : this){
			if(ob != other && ob.intersects(other)){
				list.add(other);
			}
		}
		return (list.size() == 0) ? null : list;
	}
}