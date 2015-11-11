package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemigo extends GameObject{
	
	private int vida;
	
	public Enemigo(Image image, float positionX, float positionY, int width, int height, int spriteX, int spriteY, int frames, int duration) throws SlickException {
		super(image, positionX, positionY, width, height, spriteX, spriteY, frames, duration);
	}

	@Override
	public void init() throws SlickException {
		
	}

	@Override
	public void Render(Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawRect(super.positionX+5, super.positionY-11, 21, 6);
		g.setColor(Color.green);
		g.fillRect(super.positionX+5, super.positionY-10, (float) (vida*0.2), 5);
		g.setColor(Color.white);
	}

	@Override
	public void Update(int delta) throws SlickException {
		
	}
	
}
