import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class setpanel extends JPanel {
	BufferedImage img;
	panel pl;
	player man;
	static JButton b1 = new JButton();
	static Label p = new Label("第0階");
	static Label record = new Label("最高:第0階");
	static Label hp = new Label("HP");
	static JLabel h = new JLabel("12");
	static ImageIcon h0 = new ImageIcon("img/java/h0.png");
	static ImageIcon h1 = new ImageIcon("img/java/h1.png");
	static ImageIcon h2 = new ImageIcon("img/java/h2.png");
	static ImageIcon h3 = new ImageIcon("img/java/h3.png");
	static ImageIcon h4 = new ImageIcon("img/java/h4.png");
	static ImageIcon h5 = new ImageIcon("img/java/h5.png");
	static ImageIcon h6 = new ImageIcon("img/java/h6.png");
	static int time = 0, pp = 0;

	String ppp;
	String p1;
	int ps = 0, y = 0;

	public setpanel() {
		// 介面設置
		img = new BufferedImage(40, 100, BufferedImage.TYPE_INT_BGR);
		setLayout(null);
		setBackground(Color.lightGray);
		// b1.setBounds(460,400, 100, 100);
		p.setBounds(0, 400, 150, 50);
		// p.setBackground(Color.black);
		hp.setBounds(440, 0, 50, 50);
		h.setBounds(440, 50, 50, 200);
		h.setIcon(h0);
		hp.setFont(new Font("標楷體", Font.BOLD, 32));
		p.setFont(new Font("標楷體", Font.BOLD, 32));
		record.setBounds(170, 400, 170, 50);
		// 讀取最高紀錄
		try {
			FileReader fr = new FileReader("D:\\record.txt");
			BufferedReader bfr = new BufferedReader(fr);
			while ((p1 = bfr.readLine()) != null) {
				ps = Integer.parseInt(p1);
				record.setText("最高" + p1 + "階");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		add(hp);
		add(h);
		add(record);
		add(b1);
		add(p);
		record.setFont(new Font("標楷體", Font.BOLD, 32));
	}

	public void life(int hel) {
		// 生命判定
		int hh = hel;
		System.out.println(hh);
		if (hel == 6) {
			h.setIcon(h0);
		} else if (hel == 5) {
			h.setIcon(h1);
		} else if (hel == 4) {
			h.setIcon(h2);
		} else if (hel == 3) {
			h.setIcon(h3);
		} else if (hel == 2) {
			h.setIcon(h4);
		} else if (hel == 1) {
			h.setIcon(h5);
		} else if (hel == 0) {
			h.setIcon(h6);

		}

	}

	// 顯示階層
	public void point() {
		time += 20;
		if (time == 2000) {
			pp++;

			time = 0;
		}

		ppp = Integer.toString(pp);

		p.setText("第" + ppp + "階");

	}

	public void save() {

		if (pp > ps) {

			// 紀錄最高紀錄
			try {
				FileWriter fw = new FileWriter("D:\\record.txt");
				BufferedWriter bfw = new BufferedWriter(fw);
				bfw.write(ppp);
				bfw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		pp = 0;

	}

}
