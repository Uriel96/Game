package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Monillo extends GameObject{
	private Image imagen;
	private float jumpVelocity = 1.5f;
	
	public Monillo(String path, float positionX, float positionY){
		super(path, positionX, positionY);
		super.maxVelocityX = 0.2f;
	}
	
	public void Update() throws SlickException{
		this.imagen = new Image(path);
		super.boundingBox = new Rectangle(positionX,positionY,32,32);
		imagen.draw(positionX, positionY, 32, 32);
	}
	
	public void jump(){
		super.inicialVelocityY = jumpVelocity;
	}
	
}
