package com.Team.GameName.Utilities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum States {
	PLAYERWALK("res/Enemy/Pirate1/pirate_walk_right.jpg", 6, 1, 41, 59, 6, 50),
	PLAYERSTAND("res/Enemy/Pirate1/pirate_stand_right.jpg", 3, 1, 42, 59, 3, 250),
	PLAYERATTACK("res/Enemy/Pirate1/pirate_scare_right.jpg", 8, 1, 108, 140, 8, 50),
	PLAYERDIE("res/Enemy/Pirate1/pirate_scare_right.jpg", 8, 1, 108, 140, 8, 5),
	
	ENEMYWALK("res/Enemy/Pirate1/pirate_walk_right.jpg", 6, 1, 41, 59, 6, 50),
	ENEMYSTAND("res/Enemy/Pirate1/pirate_stand_right.jpg", 3, 1, 42, 59, 3, 250),
	ENEMYATTACK("res/Enemy/Pirate1/pirate_scare_right.jpg", 8, 1, 108, 140, 8, 50),
	ENEMYDIE("res/Enemy/Pirate1/pirate_scare_right.jpg", 8, 1, 108, 140, 8, 5);
	
	private Animation animation;
	
	States(String path, int spriteX, int spriteY, int spriteWidth, int spriteHeight, int frames, int duration){
		Image i = null;
		try {
			i = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		animation = new Animation(false);
		for(int y = 0; y < spriteY; y++){
			for(int x = 0; x < spriteX; x++){
				animation.addFrame(i.getSubImage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight), duration);
			}
		}
	}

	public Animation getAnimation() {
		return animation;
	}
}
