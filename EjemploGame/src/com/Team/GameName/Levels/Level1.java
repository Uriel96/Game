package com.Team.GameName.Levels;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.Team.GameName.Characters.MainCharacter;
import com.Team.GameName.Environment.BoxPlatform;
import com.Team.GameName.Environment.TrianglePlatform;
import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Weapons.Sword;

public class Level1 extends BasicGameState{
	MainCharacter mono;
	Controller controlador;
	BoxPlatform caja;
	TrianglePlatform triangulo;
	BoxPlatform caja2;
	TrianglePlatform triangulo2;
	Sword espada;
	
	public Level1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		espada = new Sword();
		mono = new MainCharacter(100, 10);
		mono.setCurrentWeapon(espada);
		caja = new BoxPlatform(0, 300, 640, 20);
		caja2 = new BoxPlatform(40, 160, 30, 50);
		triangulo = new TrianglePlatform(0, 250, 250, 50, TrianglePlatform.Side.LEFT);
		triangulo2 = new TrianglePlatform(350, 250, 250, 50, TrianglePlatform.Side.RIGHT);
		
		controlador = new Controller();
		controlador.add(mono);
		controlador.add(caja);
		controlador.add(caja2);
		controlador.add(triangulo);
		controlador.add(triangulo2);
		controlador.add(espada);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Rigid go : controlador){
			go.Render(g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mono.moverse(controlador, gc, delta);
		for(Rigid go : controlador){
			go.Update(controlador, delta);
		}
	}

	@Override
	public int getID() {
		return 0;
	}


}
