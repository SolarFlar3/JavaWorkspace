package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	private static int speed = 1;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
		}
		
		this.handler = handler;
		
		this.velX = speed;
		this.velY = speed;
	}

	@Override
	public void tick() {
		
		if (player.getX()+8 > this.getX())
			x += velX;
		if (player.getY()+8 > this.getY())
			y += velY;
		if (player.getX()+8 < this.getX())
			x -= velX;
		if (player.getY()+8 < this.getY())
			y -= velY;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(x, y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
