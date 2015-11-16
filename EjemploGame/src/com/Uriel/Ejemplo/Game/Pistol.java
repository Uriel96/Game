package com.Uriel.Ejemplo.Game;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.SlickException;

public class Pistol extends Weapon {
	
	public int totalAmmo;
	public int reloadTime;
	public int currentAmmo;
	public int ammoCapacity;
	public int ammo;
	
	
	public Pistol(int damage, int attackInterval) throws SlickException {
		super(damage, attackInterval);
	}
	
	//Methods
	
	public void shoot(int currentAmmo){
		this.currentAmmo = currentAmmo - 1;
			/*if(checkray(object){
			 * dealdamage(this.damage, Character character){
			 * }
			 * }			
			 */
	}
	
	public void reload(int totalAmmo, int ammo, int reloadTime, int currentAmmo){
		//Time to reload
		Timer timer = new Timer();
		 timer.scheduleAtFixedRate(new TimerTask() {
	            int i = reloadTime;
	            public void run() {
	                if (i< 0)
	                    timer.cancel();
	            }
	        }, 0, 1000);
		 for (int i = 0; i <0; i++) {
			 
			 if(totalAmmo > 0){
				 this.currentAmmo = currentAmmo + 1;
			 }
			 else{
				 break;
			 }
			
		} 
		 
	}
	
	public void addAmmo(int totalAmmo, Character character){
		/*checkrange(character Maincharacter, float range){
		 * 	if(drop in range){
		 * 	this.totalAmmo = totalAmmo + 5;
		 * }
		 */
	}
	
	

}
