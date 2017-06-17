package game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	int level = 1;

	Timer mainTimer;
	SpaceShip spaceShip;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Missile> missiles = new ArrayList<Missile>();
	Random rand = new Random();

	public GameFrame(){
		setFocusable(true);

		spaceShip = new SpaceShip(250, 530);
		addKeyListener(new KeyAdapt(spaceShip));

		mainTimer = new Timer(10, this); //this class
		mainTimer.start();
		
		startGame();

	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		
		ImageIcon ic = new ImageIcon("imagens/space.jpg");
		Image im = ic.getImage();
		g2D.drawImage(im, 0, 0, null);
		
		spaceShip.draw(g2D);
		for(int i = 0; i < enemies.size(); i++){
			Enemy temp = enemies.get(i);
			temp.draw(g2D);
		}
		for(int i = 0; i < missiles.size(); i++){
			Missile missile = missiles.get(i);
			missile.draw(g2D);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		spaceShip.update();
		for(int i = 0; i < enemies.size(); i++){
			Enemy temp = enemies.get(i);
			temp.update();
		}
		for(int i =0; i < missiles.size(); i++){
			Missile missile = missiles.get(i);
			missile.update();
		}
		
		repaint();

	}

	public static void addEnemy(Enemy e){
		enemies.add(e);
	}

	public static void removeEnemy(Enemy e){
		enemies.remove(e);
	}

	public static ArrayList<Enemy> getEnemyList(){
		return enemies;
	}
	
	public static void addMissile(Missile m){
		missiles.add(m);
	}

	public static void removeMissile(Missile m){
		missiles.remove(m);
	}

	public static ArrayList<Missile> getMissileList(){
		return missiles;
	}

	public void startGame(){

		int countEnemy = level * 200;
		for(int i = 0; i < countEnemy; i++){
			addEnemy(new Enemy(rand.nextInt(500), -10 + -rand.nextInt(600)));

		}
	}
	
	public void checkEnd(){
		if(missiles.size() == 0){
			level++;
			missiles.clear();
			enemies.clear();
			startGame();
		}
	}

}
