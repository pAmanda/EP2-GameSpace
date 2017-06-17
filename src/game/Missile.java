package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Missile extends Sprite{
	public Missile(int x, int y){
		super(x, y);
	}

	public void update(){
		y -= 4;
	}

	public void draw(Graphics2D g2D){
		g2D.drawImage(getMissileImage(), x, y, null);
	}
	
	public Image getMissileImage(){
		ImageIcon ic = new ImageIcon("imagens/missile.png");
		Image i = ic.getImage();
		return i;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, getMissileImage().getWidth(null), getMissileImage().getHeight(null));	
	}
}
