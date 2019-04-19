package resource;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Picture {
	private static ImageIcon bg = new ImageIcon("table.jpg");
	private static ImageIcon table = new ImageIcon("PapanCatur.png");
	private static BufferedImage[] number = new BufferedImage[10];

	public Picture() {
		// TODO Auto-generated constructor stub
		try {
			number[0] = ImageIO.read(new File("number/nol.png"));
			number[1] = ImageIO.read(new File("number/satu.png"));
			number[2] = ImageIO.read(new File("number/dua.png"));
			number[3] = ImageIO.read(new File("number/tiga.png"));
			number[4] = ImageIO.read(new File("number/empat.png"));
			number[5] = ImageIO.read(new File("number/lima.png"));
			number[6] = ImageIO.read(new File("number/enam.png"));
			number[7] = ImageIO.read(new File("number/tujuh.png"));
			number[8] = ImageIO.read(new File("number/delapan.png"));
			number[9] = ImageIO.read(new File("number/sembilan.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Image getNumber(int idx) {
		return number[idx].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	}

	public static ImageIcon getBg() {
		return bg;
	}

	public static void setBg(ImageIcon bg) {
		Picture.bg = bg;
	}

	public static ImageIcon getTable() {
		return table;
	}

	public static void setTable(ImageIcon table) {
		Picture.table = table;
	}

}
