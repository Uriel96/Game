package com.Team.GameName.Utilities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Environment.TrianglePlatform;
import com.Team.GameName.Utilities.Rigid.Direction;

public abstract class GameObject extends Rigid{
	//FIELDS
	private float inicialVelocityY = 0;
	private float maxVelocityX;
	private float currentVelocity = 0;
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
	public boolean move(float delta) throws SlickException{
		if(currentVelocity < maxVelocityX){
			currentVelocity += 0.001f*(Math.pow(2,currentVelocity));
		}
		float deltaPosition = (super.getDirection() == Direction.Right ? 1 : -1) * Math.abs(delta) * currentVelocity;
		Rigid collision = (Rigid) Controller.checkCollision(this, deltaPosition, 0, Collision.class);
		if(collision == null){
			super.addPositionX(deltaPosition);
		}else{
			if(collision instanceof TrianglePlatform){
				float angle = ((TrianglePlatform)collision).getAngle();
				float deltaX = deltaPosition * (float)Math.sin(angle);
				float deltaY = Math.abs(deltaPosition * (float)Math.cos(angle));
				super.addPositionX(deltaX);
				super.addPositionY(deltaY);
				return true;
			}else{
				currentVelocity = 0;
			}
			return false;
		}
		return true;
	}
	
	public boolean moveTo(float delta, float positionX, float range) throws SlickException{
		float deltaX = positionX - super.getPositionX();
		if(Math.abs(deltaX) < range){
			return true;
		}else{
			super.setDirection(deltaX > 0 ? Direction.Right : Direction.Left);
			this.move(delta);
			return false;
		}
	}
	
	public void gravity(float delta) throws SlickException{
		float deltaY = this.inicialVelocityY * timer - aceleration * timer * timer / 2f;
		deltaY = (float)Math.round(deltaY * 100f) / 100f;
		if(Controller.checkCollision(this, 0f, -deltaY, Collision.class) != null){
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
	public float getMaxVelocityX() {
		return maxVelocityX;
	}
	public void setMaxVelocityX(float maxVelocityX) {
		this.maxVelocityX = maxVelocityX;
	}
	public float getCurrentVelocity() {
		return currentVelocity;
	}
	public void resetCurrentVelocity() {
		this.currentVelocity = 0;
	}
}
