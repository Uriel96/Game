package com.Team.GameName.Levels;

import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.Team.GameName.Characters.MainCharacter;
import com.Team.GameName.Characters.Pirate1;
import com.Team.GameName.Environment.BoxPlatform;
import com.Team.GameName.Environment.TrianglePlatform;
import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Weapons.Barrel;
import com.Team.GameName.Weapons.Pistol;
import com.Team.GameName.Weapons.Sword;

public class Level1 extends BasicGameState{
	MainCharacter mono;
	Controller controlador;
	BoxPlatform caja;
	TrianglePlatform triangulo;
	BoxPlatform caja2;
	TrianglePlatform triangulo2;
	Sword espada;
	Pistol pistola;
	Pirate1 enemigo;
	Barrel barril;
	
	public Level1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		espada = new Sword(0,0);
		pistola = new Pistol(0,0);
		mono = new MainCharacter(100, 10);
		mono.setCurrentWeapon(pistola);
		enemigo = new Pirate1(300,20);
		enemigo.setCurrentWeapon(espada);
		caja = new BoxPlatform(0, 300, 1000, 20);
		caja2 = new BoxPlatform(40, 160, 30, 50);
		triangulo = new TrianglePlatform(0, 250, 250, 50, TrianglePlatform.Side.LEFT);
		triangulo2 = new TrianglePlatform(350, 250, 250, 50, TrianglePlatform.Side.RIGHT);
		barril = new Barrel(150,275);
		
		controlador = new Controller(0,0);
		controlador.add(mono);
		controlador.add(caja);
		controlador.add(caja2);
		controlador.add(barril);
		controlador.add(enemigo);
		controlador.add(triangulo2);
		controlador.add(espada);
		controlador.add(pistola);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		controlador.i = controlador.iterator();
		while (controlador.i.hasNext()) {
			Rigid go = controlador.i.next();
			go.Render(controlador, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mono.moverse(controlador, gc, delta);
		controlador.i = controlador.iterator();
		while (controlador.i.hasNext()) {
			Rigid go = controlador.i.next();
			go.Update(controlador, delta);
		}
		if(controlador.gameOver){
			sbg.init(gc);
		}
	}

	@Override
	public int getID() {
		return 0;
	}
}
