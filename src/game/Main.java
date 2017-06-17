package game;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Criar a janela do jogo 
				JFrame frame = new JFrame("Space Game");
				frame.setSize(500, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.add(new GameFrame());
				frame.setVisible(true);

	}

}
