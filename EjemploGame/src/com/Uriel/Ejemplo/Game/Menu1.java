package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu1 extends BasicGameState{
	Monillo mono;
	Monillo otroMonillo;
	Control controlador;
	Caja caja;
	Triangulo triangulo;
	
	public Menu1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		mono = new Monillo("res/cosarara.gif",240,70);
		otroMonillo = new Monillo("res/cosarara.gif",320,20);
		caja = new Caja(0,300,640,20);
		triangulo = new Triangulo(0,250,400,50);
		
		controlador = new Control();
		controlador.add(mono);
		controlador.add(otroMonillo);
		controlador.add(caja);
		controlador.add(triangulo);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		mono.Update();
		otroMonillo.Update();
		caja.Update(gc, sbg, g);
		triangulo.Update(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mono.moverse(controlador, gc, delta);
		otroMonillo.gravity(delta,controlador);
	}

	@Override
	public int getID() {
		return 0;
	}


}
