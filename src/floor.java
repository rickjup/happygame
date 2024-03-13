import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class floor {
	BufferedImage img;
	BufferedImage fake, normal, spiking, spring, track, trackr;
	panel p;
	int x = 0, y = 0;
	int r = 0;
	int speed = p.speed;

	public floor() {
		try {
			fake = ImageIO.read(new File("img/java/fake.jpg")); // ¥ÕªO
			normal = ImageIO.read(new File("img/java/normal.png"));// ¦aªO
			spiking = ImageIO.read(new File("img/java/spiking.png"));// ¨ë¨ë
			spring = ImageIO.read(new File("img/java/spring.png"));// ¼u¸õªO
			track = ImageIO.read(new File("img/java/track.png"));// ¼i±a
			trackr = ImageIO.read(new File("img/java/trackr.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * if (first) {
		 * 
		 * x = 200; y = 400; r = 2; first = false; } else {
		 * 
		 * x = (int) (Math.random() * 304) + 22; r = (int) (Math.random() * 5) + 1; y =
		 * 400; }
		 */
		x = (int) (Math.random() * 304) + 22;
		r = (int) (Math.random() * 6) + 1;
		y = 400;

		Random rr = new Random();

		if (r == 1) {
			img = fake;
		} else if (r == 2) {
			img = normal;
		} else if (r == 3) {
			img = spiking;
		} else if (r == 4) {
			img = spring;
		} else if (r == 5) {
			img = track;
		} else if (r == 6) {
			img = trackr;
		}

	}

	public void move() {
		y -= 1;
		// System.out.println(r);

	}

	// ¦aªO¦ì¸m½d³ò
	public Rectangle getBounds() {
		return new Rectangle(x, y, img.getWidth(), img.getHeight() - 10);

	}

	int time2 = 0, time3 = 0;

	// ª±®a½òªº½ñªO
	public int getmanfloor(BufferedImage i) {
		// System.out.println(i);
		if (i == track) {
			return 1;
		} else if (i == normal) {
			return 2;
		} else if (i == spiking) {
			return 3;
		} else if (i == spring) {
			return 4;
		} else if (i == trackr) {
			return 6;
		} else {

			return 5;
		}
	}

	/*
	 * public void gety() { yy=y; } public Rectangle haveman() {
	 * System.out.println(x+" "+yy); yy-=1;
	 * 
	 * return new Rectangle(x,yy,img.getWidth(),img.getHeight());
	 * 
	 * }
	 */

}
