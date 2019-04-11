package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.org.glassfish.gmbal.GmbalException;
import com.sun.swing.internal.plaf.metal.resources.metal;

import chess.GamePanel;

public class Chess extends JPanel {
	JButton buttonExit = new JButton("Reset") {
		{setSize(100,100);}
	};
	private GamePanel gamePanel = new GamePanel();
	private static boolean menu = false;
	private JFrame frame = new JFrame("Chess");
	boolean check;
	private MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(menu);
			
			if (!menu) {
				menu = true;
				check = menu;
			} else {
				if (check) {
					
					gamePanel = new GamePanel();
					frame.add(gamePanel,BorderLayout.CENTER);
					frame.setVisible(true);
					check = false;
				}else {
					System.out.println("mm");
					frame.remove(gamePanel);
					gamePanel = null;
//					frame.setVisible(false);
					menu = false;
				}

			}
		}
	};

	public Chess() {
		// TODO Auto-generated constructor stub

		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1360, 720);
		buttonExit.setBackground(Color.BLACK);
		buttonExit.addMouseListener(mouseListener);
//		buttonExit.setLocation(100, arg1);
		buttonExit.setSize(100, 100);
		frame.add(buttonExit, BorderLayout.NORTH);
		
//		while (true) {

		frame.setVisible(true);

//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Chess();
	}

}
