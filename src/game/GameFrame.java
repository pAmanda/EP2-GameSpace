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
	
	//Constantes
	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;
	
	public static int level = EASY;
	public static int life = 10;
	public static int score = 0;

	Timer mainTimer;
	SpaceShip spaceShip;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Missile> missiles = new ArrayList<Missile>();
	Random rand = new Random();
	
	public GameFrame(){
		setFocusable(true);

		spaceShip = new SpaceShip(250, 550);
		addKeyListener(new KeyAdapt(spaceShip));

		mainTimer = new Timer(10, this); //this class
		mainTimer.start();
		
		startLevel(level);

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
		if(score == 50){
			level = MEDIUM;
			startLevel(level);
			score++;
		}else if(score == 120){
			level = HARD;
			startLevel(level);
			score++;    
		}
		for(int i =0; i < missiles.size(); i++){
			Missile missile = missiles.get(i);
			missile.update();
		}
		checkEnd();
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

	public void startLevel(int qtde){
		enemies.clear();
		missiles.clear();
		int countEnemy = qtde * 85;
		
		for(int i = 0; i < countEnemy; i++){
			addEnemy(new Enemy(rand.nextInt(500), -10 + -rand.nextInt(600)));

		}
	}
	
	public void checkEnd(){
		if(enemies.size() == 0 || life == 0){
			System.exit(1);
		}
	}

}
