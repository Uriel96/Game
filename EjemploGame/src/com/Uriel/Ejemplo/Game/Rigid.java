package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public abstract class Rigid{
	protected Animation animation;
	protected Image image;
	protected float positionX;
	protected float positionY;
	protected int width;
	protected int height;
	protected float weight;
	protected Shape boundingBox = null;
	protected boolean ignoreCollision = false;
	
	//CONSTRUCTORS
	public Rigid(){
		init();
	}
	
	public Rigid(float positionX, float positionY){
		this();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public Rigid(Image image, float positionX, float positionY){
		this(positionX, positionY);
		this.image = image;
	}
	
	public Rigid(float positionX, float positionY, int width, int height){
		this(positionX, positionY);
		this.width = width;
		this.height = height;
	}
	
	public Rigid(Image image, float positionX, float positionY, int width, int height){
		this(image, positionX, positionY);
		this.width = width;
		this.height = height;
	}

	
	//FUNCTIONS
	/*public boolean checkRange(GameObject go, float range){
		if(distance(this.positionX+(bounds[2]/2),this.positionY+(bounds[3]/2),go.positionX+(go.bounds[2]/2),go.positionY+(go.bounds[3]/2)) <= range){
			return true;
		}
		return false;
	}
	
	private float distance(float dist1X, float dist1Y, float dist2X, float dist2Y){
		return (float) Math.sqrt(Math.pow(dist1X - dist2X,2) + Math.pow(dist1Y - dist2Y,2));
	}*/
	
	public boolean intersects(GameObject go) {
	    if (this.getBoundingBox() == null || go.getBoundingBox() == null) {
	        return false;
	    }
	    return this.getBoundingBox().intersects(go.getBoundingBox());
	}
	
	//GETTERS AND SETTERS
	public Shape getBoundingBox() {
		return this.boundingBox;
	}
	
	
	//ABSTRACT METHODS
	public abstract void init();
	
	public abstract void Render(Graphics g) throws SlickException;
	
	public abstract void Update(int delta) throws SlickException;
}
