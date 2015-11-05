package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tests.xml.Entity;

public abstract class GameObject extends Rigid{
	
	protected float inicialVelocityY = 0;
	protected float maxVelocity = 0;
	protected boolean inGround;
	private float timer = 0;
	private static final float aceleration = 9.8f;
	
	//CONSTRUCTORS
	public GameObject(){
		super();
	}
	
	public GameObject(float positionX, float positionY){
		super(positionX, positionY);
	}
	
	public GameObject(Image image, float positionX, float positionY){
		super(image, positionX, positionY);
	}
	
	public GameObject(float positionX, float positionY, int width, int height){
		super(positionX, positionY, width, height);
	}
	
	public GameObject(Image image, float positionX, float positionY, int width, int height){
		this(image, positionX, positionY);
		this.width = width;
		this.height = height;
	}
	
	public GameObject(Image image, float positionX, float positionY, int width, int height, int spriteX, int spriteY, int frames, int duration) throws SlickException{
		super(image, positionX, positionY, width, height);
		this.animation = this.getAnimation(this.image, spriteX, spriteY, this.width, this.height, frames, duration);
	}
	
	//FUNCTIONS
	public void moveRight(float delta){
		this.positionX += Math.abs(delta) * maxVelocity;
	}
	
	public void moveLeft(float delta){
		this.positionX -= Math.abs(delta) * maxVelocity;
	}
	
	public void moveUp(float delta){
		this.positionY -= Math.abs(delta) * maxVelocity;
	}
	
	public void moveDown(float delta){
		this.positionY += Math.abs(delta) * maxVelocity;
	}
	
	/*public boolean checkRange(GameObject go, float range){
		if(distance(this.positionX+(bounds[2]/2),this.positionY+(bounds[3]/2),go.positionX+(go.bounds[2]/2),go.positionY+(go.bounds[3]/2)) <= range){
			return true;
		}
		return false;
	}
	
	private float distance(float dist1X, float dist1Y, float dist2X, float dist2Y){
		return (float) Math.sqrt(Math.pow(dist1X - dist2X,2) + Math.pow(dist1Y - dist2Y,2));
	}*/
	
	public void gravity(float delta, Control controlador) throws SlickException{
		float timer2 = timer / 1000f;
		float deltaY = this.inicialVelocityY * timer2 - aceleration * timer2 * timer2 / 2f;
		if(controlador.checkCollision(this, 0f,-deltaY,false) != null){
			this.inicialVelocityY = 0;
			timer = 0;
			inGround = true;
		}else{
			timer += delta;
			positionY -= deltaY;
			inGround = false;
		}
	}
	
	
	//GETTERS AND SETTERS
	public boolean isInGround(){
		return inGround;
	}
	
	public Animation getAnimation(Image i, int spriteX, int spriteY, int spriteWidth, int spriteHeight, int frames, int duration){
		Animation a = new Animation(false);
		for(int y = 0; y < spriteY; y++){
			for(int x = 0; x < spriteX; x++){
				a.addFrame(i.getSubImage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight), duration);
			}
		}
		return a;
	}

}
