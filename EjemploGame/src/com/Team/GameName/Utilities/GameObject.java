package com.Team.GameName.Utilities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Environment.TrianglePlatform;

public abstract class GameObject extends Rigid{
	//FIELDS
	private float inicialVelocityY = 0;
	private float maxVelocityX;
	private boolean inGround;
	private float timer = 0;
	private static final float aceleration = 9.8f;
	
	//CONSTRUCTORS
	public GameObject() throws SlickException{
		super();
	}
	public GameObject(float positionX, float positionY) throws SlickException{
		super(positionX, positionY);
	}
	public GameObject(float positionX, float positionY, int width, int height, float maxVelocityX) throws SlickException{
		super(positionX, positionY, width, height);
		this.maxVelocityX = maxVelocityX;
	}
	public GameObject(float positionX, float positionY, int width, int height, int widthImage, int heightImage, boolean repeat, float maxVelocityX) throws SlickException{
		super(positionX, positionY, width, height,widthImage,heightImage,repeat);
		this.maxVelocityX = maxVelocityX;
	}
	
	//METHODS
	public boolean move(Controller controller, float delta) throws SlickException{
		float deltaPosition = (super.getDirection() == Direction.Right ? 1 : -1) * Math.abs(delta) * maxVelocityX;
		Rigid collision = (Rigid) controller.checkCollision(this, deltaPosition, 0, Collision.class);
		if(collision == null){
			this.addPositionX(deltaPosition);
		}else{
			if(collision instanceof TrianglePlatform){
				float angle = ((TrianglePlatform)collision).getAngle();
				this.addPositionX(deltaPosition * (float)Math.sin(angle));
				this.addPositionY(Math.abs(deltaPosition * (float)Math.cos(angle)));
				return true;
			}
			return false;
		}
		return true;
	}
	public void gravity(Controller controller, float delta) throws SlickException{
		float deltaY = this.inicialVelocityY * timer - aceleration * timer * timer / 2f;
		deltaY = (float)Math.round(deltaY * 100f) / 100f;
		if(controller.checkCollision(this, 0f, -deltaY, Collision.class) != null){
			this.inicialVelocityY = 0;
			timer = 0.05f;
			inGround = true;
		}else{
			timer += delta/1000f;
			super.addPositionY(deltaY);
			inGround = false;
		}
	}

	//GETTERS AND SETTERS
	public boolean isInGround(){
		return inGround;
	}	
	public float getInicialVelocityY() {
		return inicialVelocityY;
	}
	public void setInicialVelocityY(float inicialVelocityY) {
		this.inicialVelocityY = inicialVelocityY;
	}
}
