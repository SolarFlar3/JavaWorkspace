package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JavaGame extends JFrame{
	
	int x, y;
	private Image dbImage;
	private Graphics dbGraphics;
	public static final int BALL_SPEED = 100;
	
	Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			
			movePlayer(keyCode, e);
		}
		
		private void movePlayer(int keyCode, KeyEvent e) {
			if (keyCode == e.VK_LEFT){
				if (x <= 0){
					x = 0;
				} else {
					
					//x -= BALL_SPEED;
				}
			}
			if (keyCode == e.VK_RIGHT){
				if (x >= 480){
					x = 480;
				} else {
					//x += BALL_SPEED;
				}			
			}
			if (keyCode == e.VK_UP){
				if (y <= 25){
					y = 25;
				} else {
					//y -= BALL_SPEED;
				}
			}
			if (keyCode == e.VK_DOWN){
				if (y >= 485){
					y = 485;
				} else {
					//y += BALL_SPEED;
				}
			}
		}
		public void keyReleased(KeyEvent e){
			int keyCode = e.getKeyCode();
		}
	}
	
	public JavaGame(){
		
		
		
		//Game Properties
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.CYAN);
		x = 150;
		y = 150;
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
		g.setFont(font);
		g.setColor(Color.MAGENTA);
		g.drawString("Hello World", 50, 50);
		g.setColor(Color.red);
		g.fillOval(x, y, 15, 15);
		
		repaint();
	}
	
	public static void main(String args[]){
		new JavaGame();
	}
	
}
