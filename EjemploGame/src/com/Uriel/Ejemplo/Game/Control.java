package com.Uriel.Ejemplo.Game;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Control extends ArrayList<GameObject>{
	
	public Control(){
		
	}
	
	public GameObject checkCollision(GameObject ob, float deltaX, float deltaY, boolean considerHasNoCollision) throws SlickException{
		ob.boundingBox = new Rectangle(ob.positionX+deltaX,ob.positionY+deltaY,32,32);
		for(GameObject other : this){
			if(considerHasNoCollision || other.hasCollision){
				if(ob != other){
					if(ob.intersects(other)){
						return other;
					}
				}
			}
		}
		return null;
	}
}