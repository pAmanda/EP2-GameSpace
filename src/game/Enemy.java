package game;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	private int startY;
	public Enemy(int x, int y) {
		super(x, y);
		startY = y;
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += 1;
		checkCollisions();
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2D){
		g2D.drawImage(getEnemyImage(), x, y, null);
	}
	
	public Image getEnemyImage(){
		ImageIcon ic = new ImageIcon("imagens/alien_EASY.png");
		Image i = ic.getImage();
		return i;	
	}
	
	public void checkCollisions(){
		for(int i = 0; i < GameFrame.getMissileList().size(); i++){
			Missile missile = GameFrame.getMissileList().get(i);
			if(getBounds().intersects(missile.getBounds())){
				GameFrame.removeMissile(missile);
				GameFrame.removeEnemy(this);
			}
		}
	}
	
	public void checkOffScreen(){
		if(y >= 630){
			y = startY;
		}
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getEnemyImage().getWidth(null), getEnemyImage().getHeight(null));
	}

}
