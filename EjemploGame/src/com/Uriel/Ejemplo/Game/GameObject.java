package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tests.xml.Entity;

public class GameObject extends Entity{
	protected String path;
	protected float positionX;
	protected float positionY;
	protected int width;
	protected int height;
	protected float weight;
	protected Rectangle boundingBox = null;
	protected float inicialVelocityY = 0;
	protected float maxVelocityX = 0;
	protected boolean inGround;
	private float timer = 0;
	private static final float aceleration = 9.8f;
	
	public GameObject(){
		
	}
	public GameObject(float positionX, float positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public GameObject(String path, float positionX, float positionY){
		this.path = path;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void moveRight(float delta){
		this.positionX += Math.abs(delta) * maxVelocityX;
	}
	
	public void moveLeft(float delta){
		this.positionX -= Math.abs(delta) * maxVelocityX;
	}
	
	public boolean checkCollision(){
		return Math.floor(this.positionY) <= 330;
	}
	
	public boolean checkCollision(float positionY){
		return Math.floor(positionY) <= 330;
	}
	
	/*public boolean checkRange(GameObject go, float range){
		if(distance(this.positionX+(bounds[2]/2),this.positionY+(bounds[3]/2),go.positionX+(go.bounds[2]/2),go.positionY+(go.bounds[3]/2)) <= range){
			return true;
		}
		return false;
	}*/
	
	private float distance(float dist1X, float dist1Y, float dist2X, float dist2Y){
		return (float) Math.sqrt(Math.pow(dist1X - dist2X,2) + Math.pow(dist1Y - dist2Y,2));
	}
	
	public void gravity(float delta){
		float timer2 = timer / 1000f;
		float deltaY = this.inicialVelocityY * timer2 - aceleration * timer2 * timer2 / 2f;
		if(checkCollision(positionY - deltaY)){
			timer += delta;
			positionY -= deltaY;
			inGround = false;
		}else{
			this.inicialVelocityY = 0;
			timer = 0;
			inGround = true;
		}
	}
	
	public boolean isInGround(){
		return inGround;
	}
	
	public Rectangle getBoundingBox() {
	  return this.boundingBox;
	}
	
	public boolean intersects(GameObject go) {
	    if (this.getBoundingBox() == null || go.getBoundingBox() == null) {
	    	System.out.println("perdedor");
	        return false;
	    }
	    return this.getBoundingBox().intersects(go.getBoundingBox());
	}
}
