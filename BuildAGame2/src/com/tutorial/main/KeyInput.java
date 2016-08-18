package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private static int keysPressed;
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
					wPressed = true;
					keysPressed++;
					if(wPressed && sPressed) tempObject.setVelY(0);
					else tempObject.setVelY(-Player.getSpeed());
				}
				if (key == KeyEvent.VK_S && sPressed == false){
					keysPressed++;
					sPressed = true;
					if(wPressed && sPressed) tempObject.setVelY(0);
					else tempObject.setVelY(Player.getSpeed());
				}
				if (key == KeyEvent.VK_A && aPressed == false){
					keysPressed++;
					aPressed = true;
					if(aPressed && dPressed) tempObject.setVelX(0);
					else tempObject.setVelX(-Player.getSpeed());
				}
				if (key == KeyEvent.VK_D && dPressed == false){
					keysPressed++;
					dPressed = true;
					if(aPressed && dPressed) tempObject.setVelX(0);
					else tempObject.setVelX(Player.getSpeed());
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
					keysPressed--;
					wPressed = false;
					tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_S){
					keysPressed--;
					sPressed = false;
					tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_A){
					keysPressed--;
					aPressed = false;
					tempObject.setVelX(0);
				}
				if (key == KeyEvent.VK_D){
					keysPressed--;
					dPressed = false;
					tempObject.setVelX(0);
				}
			}
		}
	}
	
	public static int getKeysPressed(){
		return keysPressed;
	}
	
	public static void tick(){
		if (getKeysPressed() == 2) Player.setSpeed((float)2.8);
		else Player.setSpeed(4);
	}
}
