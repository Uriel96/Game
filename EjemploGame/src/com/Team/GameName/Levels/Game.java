package com.Team.GameName.Levels;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String nombreJuego = "Piratas";
	public static final int menu = 0;
	public static final int nivel1 = 1;
	public static final int nivel2 = 2;
	
	public Game(String nombreJuego){
		super(nombreJuego);
		this.addState(new Level1(menu));
		//this.addState(new Menu(nivel1));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		//this.getState(nivel1).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(nombreJuego));
			appgc.setDisplayMode(1000, 600, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}
