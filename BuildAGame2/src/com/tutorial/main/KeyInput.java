package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	private boolean wPressed = false, aPressed = false, sPressed = false, dPressed = false;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//key events for player 1
				
				if (key == KeyEvent.VK_W && wPressed == false){
					tempObject.setVelY(tempObject.getVelY()-Player.getSpeed());
					wPressed = true;
				}
				if (key == KeyEvent.VK_S && sPressed == false){
					tempObject.setVelY(tempObject.getVelY()+Player.getSpeed());
					sPressed = true;
				}
				if (key == KeyEvent.VK_A && aPressed == false){
					tempObject.setVelX(tempObject.getVelX()-Player.getSpeed());
					aPressed = true;
				}
				if (key == KeyEvent.VK_D && dPressed == false){
					tempObject.setVelX(tempObject.getVelX()+Player.getSpeed());
					dPressed = true;
				}
			}
			
			if(key == KeyEvent.VK_ESCAPE){
				System.exit(1);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//key events for player 1
				
				if (key == KeyEvent.VK_W){
					tempObject.setVelY(tempObject.getVelY()+Player.getSpeed());
					wPressed = false;
				}
				if (key == KeyEvent.VK_S){
					tempObject.setVelY(tempObject.getVelY()-Player.getSpeed());
					sPressed = false;
				}
				if (key == KeyEvent.VK_A){
					tempObject.setVelX(tempObject.getVelX()+Player.getSpeed());
					aPressed = false;
				}
				if (key == KeyEvent.VK_D){
					tempObject.setVelX(tempObject.getVelX()-Player.getSpeed());
					dPressed = false;
				}
			}
		}
	}
}
