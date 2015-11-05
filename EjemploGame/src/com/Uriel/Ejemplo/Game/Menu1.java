package com.Uriel.Ejemplo.Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Uriel.Ejemplo.Game.Triangulo.Side;

public class Menu1 extends BasicGameState{
	Monillo mono;
	Monillo otroMonillo;
	Control controlador;
	Caja caja;
	Triangulo triangulo;
	Caja caja2;
	Triangulo triangulo2;
	
	public Menu1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		Image imagenjohn = new Image("res/nuevomono.png");
		
		
		Image la = new Image("res/nuevomono.png");
		mono = new Monillo(la, 100, 10);
		otroMonillo = new Monillo(la, 320, 20);
		caja = new Caja(0, 300, 640, 20);
		caja2 = new Caja(40, 160, 30, 50);
		triangulo = new Triangulo(0, 250, 250, 50, Side.LEFT);
		triangulo2 = new Triangulo(250, 250, 250, 50, Side.RIGHT);
		
		controlador = new Control();
		controlador.add(mono);
		controlador.add(otroMonillo);
		controlador.add(caja);
		controlador.add(caja2);
		controlador.add(triangulo);
		controlador.add(triangulo2);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(GameObject go : controlador){
			go.Render(g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for(GameObject go : controlador){
			go.Update(delta);
		}
		//caja2.gravity(delta, controlador);
		mono.moverse(controlador, gc, delta);
		otroMonillo.gravity(delta,controlador);
	}

	@Override
	public int getID() {
		return 0;
	}


}
