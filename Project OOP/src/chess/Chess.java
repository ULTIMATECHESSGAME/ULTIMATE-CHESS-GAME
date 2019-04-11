package chess;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1360, 720);
		frame.add(new GamePanel());
		frame.setVisible(true);
	}

}
