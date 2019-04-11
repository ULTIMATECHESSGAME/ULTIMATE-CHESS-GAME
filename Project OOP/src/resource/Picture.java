package resource;

import javax.swing.ImageIcon;

public class Picture {
	private static ImageIcon bg = new ImageIcon("table.jpg");
	private static ImageIcon table = new ImageIcon("PapanCatur.png");
	private static ImageIcon number = new ImageIcon("number.png");

	public static ImageIcon getNumber() {
		return number;
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
