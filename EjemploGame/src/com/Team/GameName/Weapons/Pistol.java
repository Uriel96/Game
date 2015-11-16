package com.Team.GameName.Weapons;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;
import com.Team.GameName.Characters.Character;

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
	public void shoot(Controller controller,int currentAmmo, Character charac){
		this.currentAmmo = currentAmmo - 1;
		
			controller.doRayCastList(charac, 0, 0, 200);
			if(controller.doRayCast(charac, 0, 0, 200)){
			 super.dealDamage(super.damage, charac);
			}
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

	@Override
	public void init() throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	

}
