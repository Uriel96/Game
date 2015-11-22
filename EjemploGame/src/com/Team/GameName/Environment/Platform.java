package com.Team.GameName.Environment;

import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Collision;
import com.Team.GameName.Utilities.Rigid;

public abstract class Platform  extends Rigid implements Collision{

	public Platform(float positionX, float positionY, int width, int height) throws SlickException{
		super(positionX, positionY, width, height);
	}

}
