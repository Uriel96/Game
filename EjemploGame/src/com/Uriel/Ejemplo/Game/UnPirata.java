package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class UnPirata extends GameObject implements Personaje{
	
	public enum State{
		WALKRIGHT,
		WALKLEFT,
		STANDRIGHT,
		STANDLEFT,
		DIE
	}
	
	public State currentState = State.WALKLEFT;
	
	private float jumpVelocity = 2f;
	
	public UnPirata(Image image, float positionX, float positionY) throws SlickException{
		super(image, positionX, positionY, 108, 140, 8, 1, 8, 50);
		super.maxVelocity = 0.2f;
	}
	
	public void jump(){
		super.inicialVelocityY = jumpVelocity;
	}
	
	@Override
	public void init() throws SlickException {
			Image derecha = new Image("res/nuevomonoderecha.png");
			Image izquierda = new Image("res/nuevomonoizquierda.png");
			super.animation[0] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
			super.animation[1] = super.getAnimation(izquierda, 8, 1, 108, 140, 8, 50);
			super.animation[2] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
			super.animation[3] = super.getAnimation(izquierda, 8, 1, 108, 140, 8, 50);
			super.animation[4] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
	}

	@Override
	public void Render(Graphics g) throws SlickException {
		super.animation[currentState.ordinal()].draw(super.positionX, super.positionY,27,35);
	}
	
	@Override
	public void Update(int delta) throws SlickException{
		super.animation[currentState.ordinal()].update(delta);
		super.boundingBox = new Rectangle(positionX, positionY, 27, 35);
	}

	
	@Override
	public void implementarVida() {
		
	}
	
}