package com.Team.GameName.Environment;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Team.GameName.Utilities.Collision;
import com.Team.GameName.Utilities.Controller;
import com.Team.GameName.Utilities.Rigid;

public class BoxPlatform extends Rigid implements Collision{
	public BoxPlatform(float positionX, float positionY, int width, int height) throws SlickException{
		super(positionX, positionY, width, height);
	}
	
	@Override
	public void init() {
		
	}
	
	public void Render(Controller controller, Graphics g) throws SlickException{
		super.setBoundingBox();
		g.draw(super.getBoundingBox());
	}

	@Override
	public void Update(Controller controller, int delta) throws SlickException {
		
	}
}
