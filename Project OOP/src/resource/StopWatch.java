package resource;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Iterator;

import java.util.Timer;

import javax.swing.JPanel;

public class StopWatch extends JPanel {

	private long start = 0;
	private long stop;
	private Double time = (double) 0;
	private boolean flag;
	
	
	
	public double elapsedTime() {
		stop = System.currentTimeMillis();
		setTime();
		return (stop - start) / 1000.0;
	}

	private void setTime() {
		time += (stop - start) / 1000.0;
		flag = false;
	}

	public void startTime() {
		start = System.currentTimeMillis();
		flag = true;
	}

	public StopWatch() {
		// TODO Auto-generated constructor stub
//		start = System.currentTimeMillis();
		flag = false;
		th.start();
	}

	public String getTime() {
		return time.toString();
	}

	Graphics s;

	public Graphics timerDisplay(Graphics paint) {
		if (flag) {
			s = paint;
			paint.setColor(Color.BLACK);
			Double t = time + ((System.currentTimeMillis() - start) / 1000.0);
			paint.drawString(t.toString(), 700, 100);
		}
		return paint;
	}

	Thread th = new Thread(() -> {
		while (true) {

			try {
				if (flag) {
					System.out.println(time + ((System.currentTimeMillis() - start) / 1000.0));
					timerDisplay(s);
				}
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("ssss", 600, 100);
	};

}
