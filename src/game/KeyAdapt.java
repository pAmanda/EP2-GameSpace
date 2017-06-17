package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAdapt implements KeyListener{
	SpaceShip spaceShip;
	
	public KeyAdapt(SpaceShip p){
		spaceShip = p;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		spaceShip.KeyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		spaceShip.KeyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
