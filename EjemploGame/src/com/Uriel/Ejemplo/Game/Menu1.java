package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu1 extends BasicGameState{
	Monillo mono;
	Monillo otroMonillo;
	Control controlador;
	Caja caja;
	
	public Menu1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		controlador = new Control();
		controlador.add(mono);
		controlador.add(otroMonillo);
		//controlador.add(caja);
		
		//caja = new Caja(60,30);
		mono = new Monillo("res/cosarara.gif",320,70);
		otroMonillo = new Monillo("res/cosarara.gif",240,20);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		mono.Update();
		otroMonillo.Update();
		//caja.Update(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_A)){
			mono.moveLeft(delta);
		}
		if(input.isKeyDown(Input.KEY_D)){
			mono.moveRight(delta);
		}
		if(input.isKeyPressed(Input.KEY_SPACE)){
			mono.jump();
		}
		/*if(otroMonillo.intersects(mono)){
			System.out.println("Están cerca");	
		}*/
		if(controlador.checkCollision(mono, 0f))
		{
			System.out.println("lalala");
		}
		if(!controlador.checkCollision(mono, delta)){
		
		}
		mono.gravity(delta);
		//caja.gravity(delta);
		otroMonillo.gravity(delta);
	}

	@Override
	public int getID() {
		return 0;
	}


}
