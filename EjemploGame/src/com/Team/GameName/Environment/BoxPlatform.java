package com.Team.GameName.Environment;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BoxPlatform extends Platform{
	public BoxPlatform(float positionX, float positionY, int width, int height) throws SlickException{
		super(positionX, positionY, width, height);
	}
	
	@Override
	public void Init() {
		
	}
	
	public void Render(Graphics g) throws SlickException{
		super.setBoundingBox();
	}

	@Override
	public void Update(int delta) throws SlickException {
		
	}
}
