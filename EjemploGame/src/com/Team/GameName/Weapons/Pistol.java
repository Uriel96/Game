package com.Team.GameName.Weapons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Characters.Character;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Utilities.Rigid.Direction;

public class Pistol extends Weapon {
	
	public int totalAmmo;
	public float reloadTime;
	public int currentAmmo;
	public int ammoCapacity;
	public float currentTimeReload;
	public int ammo;
	public float range;
	
	public Pistol(float positionX, float positionY) throws SlickException {
		super(positionX, positionY, 15, 5, 20, 0.5f);
		this.reloadTime = 2f;
		this.range = 300;
	}
	
	//METHODS
	public void shoot() throws SlickException{
		this.currentAmmo = this.currentAmmo - 1;
		this.currentTime = super.attackInterval;
		dealDamage();
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
	public void Init() throws SlickException {
		
	}

	@Override
	public void Update(int delta) throws SlickException {
		if(super.isVisible()){
			super.Update(delta);
			if(currentTimeReload >= 0){
				currentTimeReload -= delta / 1000f;
			}
		}
	}

	@Override
	public void dealDamage() throws SlickException {
		Character ob = Controller.doRayCast(this, this.range, 3, Character.class);
		Barrel barrel = Controller.doRayCast(this, this.range, 3, Barrel.class);
		if(ob != null){
			ob.takeAwayHealth(this.damage);
		}
		if(barrel != null){
			barrel.explode();
		}
	}

	@Override
	public void Render(Graphics g) throws SlickException {
	
	}
	
	

}