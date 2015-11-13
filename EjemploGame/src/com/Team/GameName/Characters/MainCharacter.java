package com.Team.GameName.Characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Weapons.Sword;

public class MainCharacter extends Character{
	
	public enum State{
		WALKRIGHT,
		WALKLEFT,
		STANDRIGHT,
		STANDLEFT,
		ATTACKRIGHT,
		ATTACKLEFT,
		DIE
	}
	private float jumpVelocity;
	
	public MainCharacter(float positionX, float positionY) throws SlickException{
		super(positionX, positionY);
	}
	
	public void moverse(Controller controller, GameContainer gc, float delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_A)){
			this.move(controller, delta, Direction.Left);
			super.currentAnimation = getAnimation(State.WALKLEFT);
		}
		if(input.isKeyDown(Input.KEY_D)){
			this.move(controller, delta, Direction.Right);
			super.currentAnimation = getAnimation(State.WALKRIGHT);
		}
		if(input.isKeyPressed(Input.KEY_W)){
			this.jump();
		}
		if(input.isKeyDown(Input.KEY_SPACE)){ 
			if(super.currentWeapon.canAttack()){
				this.attack();
			}
		}
		this.gravity(controller, delta);
	}
	
	private Animation getAnimation(State state){
		return super.states[state.ordinal()];
	}
	
	public void jump(){
		super.inicialVelocityY = jumpVelocity;
	}
	
	@Override
	public void init() throws SlickException {
		super.width = 27;
		super.height = 35;
		super.maxVelocityX = 0.2f;
		super.maxVelocityY = 2.0f;
		this.jumpVelocity = 1.5f;
		this.health = 100;
		this.currentWeapon = new Sword();
	}

	@Override
	public void Render(Graphics g) throws SlickException {
		if(super.currentAnimation != null){
			super.currentAnimation.draw(super.positionX, super.positionY, super.width, super.height);
		}
		this.applyDamage(g);
	}
	
	@Override
	public void Update(Controller controller, int delta) throws SlickException{
		super.currentAnimation.update(delta);
		super.boundingBox = new Rectangle(positionX, positionY, super.width, super.height);
	}

	@Override
	public void defineStates() throws SlickException {
		Image derecha = new Image("res/nuevomonoderecha.png");
		Image izquierda = new Image("res/nuevomonoizquierda.png");
		super.states = new Animation[7];
		//WALK
		super.states[0] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
		super.states[1] = super.getAnimation(izquierda, 8, 1, 108, 140, 8, 50);
		//STAND
		super.states[2] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
		super.states[3] = super.getAnimation(izquierda, 8, 1, 108, 140, 8, 50);
		//ATTACK
		super.states[4] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 5);
		super.states[5] = super.getAnimation(izquierda, 8, 1, 108, 140, 8, 5);
		//DIE
		super.states[6] = super.getAnimation(derecha, 8, 1, 108, 140, 8, 50);
		super.currentAnimation = states[0];
	}

	
	@Override
	public void attack() {
		super.currentAnimation = getAnimation(State.ATTACKLEFT);
	}
	

	@Override
	public void applyDamage(Graphics g) throws SlickException{
		g.setColor(Color.red);
		g.drawRect(super.positionX + 5, super.positionY - 11, 21, 6);
		g.setColor(Color.green);
		g.fillRect(super.positionX + 5, super.positionY - 10, (float) (super.health * 0.2), 5);
		g.setColor(Color.white);
	}
}
