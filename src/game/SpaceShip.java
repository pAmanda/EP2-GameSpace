package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class SpaceShip extends Sprite{
	int velX = 0, velY = 0;
	int speed = 2;

	public SpaceShip(int x, int y) {
		super(x, y);

	}

	public void update(){
		y += velY;
		x += velX;
		checkCollisons();
	}

	public void draw(Graphics2D g2D){
		g2D.drawImage(getPlayerImage(), x, y, null);
	}

	public Image getPlayerImage(){

		ImageIcon ic = new ImageIcon("imagens/spaceship.png");
		Image i = ic.getImage();
		return i;	
	}

	public void KeyPressed(KeyEvent e){
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
			velY = -speed;

		}else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
			velY = speed;
		}else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
			velX = -speed;
		}else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			velX = speed;
		}else if(key == KeyEvent.VK_SPACE){
			GameFrame.addMissile(new Missile(x + 5, y - 5));
		}
	}

	public void KeyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
			velY = 0;

		}else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
			velY = 0;
			
		}else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
			velX = 0;
			
		}else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
	}
	
	public void checkCollisons(){
		ArrayList<Enemy> enemies = GameFrame.getEnemyList();
		for(int i = 0; i < enemies.size(); i++){
			Enemy enemyTemp = enemies.get(i);
			if(getBounds().intersects(enemyTemp.getBounds())){
				GameFrame.removeEnemy(enemyTemp);
				GameFrame.life--;
			}
		}
		if(x < 0)	
			x = 500;
		if(x > 500)
			x = 0;
		if(y > 550)
			y = 550;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImage().getWidth(null), getPlayerImage().getHeight(null));
	}

}
