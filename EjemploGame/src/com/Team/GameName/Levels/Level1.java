package com.Team.GameName.Levels;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.Team.GameName.Characters.Enemy;
import com.Team.GameName.Characters.MainCharacter;
import com.Team.GameName.Characters.Pirate1;
import com.Team.GameName.Environment.BoxPlatform;
import com.Team.GameName.Environment.Platform;
import com.Team.GameName.Environment.TrianglePlatform;
import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Weapons.Barrel;
import com.Team.GameName.Weapons.Weapon;

public class Level1 extends BasicGameState{
	MainCharacter mono;
	LinkedList<Platform> plataformas = new LinkedList<Platform>();
	LinkedList<Weapon> armas = new LinkedList<Weapon>();
	LinkedList<Enemy> enemigos = new LinkedList<Enemy>();
	boolean primera = true;
	
	public Level1(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		if(primera){
			primera = false;
			
			Controller.newInstance(2000, 360);
			
			plataformas.clear();
			armas.clear();
			enemigos.clear();
			
			mono = new MainCharacter(100, 10);
			enemigos.add(new Pirate1(600,20));
			enemigos.add(new Pirate1(1200,20));
			plataformas.add(new BoxPlatform(0, 300, 4000, 10));
			plataformas.add(new BoxPlatform(0, 200, 200, 100));
			plataformas.add(new BoxPlatform(1200, 200, 500, 100));
			plataformas.add(new TrianglePlatform(200, 200, 300, 100, TrianglePlatform.Side.LEFT));
			plataformas.add(new TrianglePlatform(900, 200, 300, 100, TrianglePlatform.Side.RIGHT));
			plataformas.add(new TrianglePlatform(1400, 100, 300, 100, TrianglePlatform.Side.RIGHT));
			armas.add(new Barrel(1300,175));
			
			Controller.add(mono);
			Controller.addAll(plataformas);
			Controller.addAll(enemigos);
			Controller.addAll(armas);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Controller.iterate();
		while (Controller.hasNext()) {
			Rigid go = Controller.next();
			go.render(g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mono.moverse(gc, delta);
		Controller.follow(mono, 0, 0);
		Controller.iterate();
		while (Controller.hasNext()) {
			Rigid go = Controller.next();
			go.update(delta);
		}
		if(Controller.isGameOver()){
			primera = true;
			sbg.init(gc);
		}
	}

	@Override
	public int getID() {
		return 0;
	}
}
