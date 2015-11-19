package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Characters.Character;
import com.Team.GameName.Utilities.Controller;

public class Pistol extends Weapon {
	
	public int totalAmmo;
	public float reloadTime;
	public int currentAmmo;
	public int ammoCapacity;
	public float currentTimeReload;
	public int ammo;
	
	public Pistol(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 15, 5, 20, 0.3f);
		this.reloadTime = 2f;
	}
	
	//METHODS
	public void shoot(Controller controller) throws SlickException{
		this.currentAmmo = this.currentAmmo - 1;
		dealDamage(controller);
	}
	
	public void reload(){
		this.currentTimeReload = this.reloadTime;
		
		/*for (int i = totalAmmo; i>0|| this.currentAmmo == 5; i--) {
			this.currentAmmo = this.currentAmmo + 1;
			this.totalAmmo = this.totalAmmo - 1;
		}*/
	}
	
	public void addAmmo(int newAmmo){
		/*checkrange(character Maincharacter, float range){
		 * 	if(drop in range){
		 * 	this.totalAmmo = totalAmmo + 5;
		 * }
		 */
	}

	@Override
	public void init() throws SlickException {
		
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		super.Update(controller, delta);
		if(currentTimeReload >= 0){
			currentTimeReload -= delta / 1000f;
		}
	}

	@Override
	public void dealDamage(Controller controller) throws SlickException {
		Character ch = controller.doRayCast(this, super.getPositionX(), super.getPositionY(), 200, Character.class);
		if(ch != null){
			ch.takeAwayHealth(this.damage);
		}
	}

	@Override
	public void Render(Controller controller, Graphics g) throws SlickException {
		super.setBoundingBox();
		if(super.getDirection() == Direction.Right){
			g.draw(super.getBoundingBox());
		}else{
			g.draw(super.getBoundingBox());
		}
	}
	
	

}