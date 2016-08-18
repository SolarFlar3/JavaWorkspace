package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	private Handler handler;
	private static int speed = 4;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		this.velX = speed;
		this.velY = speed;
	}

	@Override
	public void tick() {
		if (this.x >= Game.WIDTH - 16 || this.x <= 0) velX = -velX;
		if (this.y >= Game.HEIGHT - 32 || this.y <= 0) velY = -velY;
		
		x += velX;
		y += velY;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
