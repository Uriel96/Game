package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Monillo extends GameObject{
	private Image imagen;
	private float jumpVelocity = 2f;
	
	public Monillo(String path, float positionX, float positionY){
		super(path, positionX, positionY);
		super.maxVelocityX = 0.2f;
	}
	
	public void Update() throws SlickException{
		this.imagen = new Image(path);
		super.boundingBox = new Rectangle(positionX,positionY,32,32);
		imagen.draw(positionX, positionY, 32, 32);
	}
	
	public void moverse(Control controlador, GameContainer gc, float delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_A)){
			GameObject collision = controlador.checkCollision(this, -delta,0);
			if(collision == null){
				moveLeft(delta);
			}else{
				if(collision instanceof Triangulo){
					Triangulo col = (Triangulo)collision;
					moveLeft(delta * (float)Math.sin(col.angle));
					moveUp(delta * (float)Math.cos(col.angle));
				}
			}
		}
		if(input.isKeyDown(Input.KEY_D)){
			GameObject collision = controlador.checkCollision(this, delta,0);
			if(collision == null){
				moveRight(delta);
			}else{
				if(collision instanceof Triangulo){
					Triangulo col = (Triangulo)collision;
					moveRight(delta * (float)Math.sin(col.angle));
					moveUp(delta * (float)Math.cos(col.angle));
				}
			}
		}
		if(input.isKeyPressed(Input.KEY_SPACE)){
			jump();
		}
		gravity(delta,controlador);
	}
	
	public void jump(){
		super.inicialVelocityY = jumpVelocity;
	}
	
}
