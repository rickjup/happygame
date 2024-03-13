import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class panel extends JPanel implements KeyListener {
	Graphics2D g2;
	main m;
	BufferedImage img, top;
	setpanel sp;
	player man;
	fresh fresh;

	background bk;
	BufferedImage fakeac[] = new BufferedImage[5];

	int time2 = 0, time3 = 0;
	int y = 390;
	int ii = 0;
	floor f = new floor();
	static final int speed = 20;
	int go = 0;
	int time = 0;
	int check = 0;
	int i = 0;

	// HashMap<Integer, BufferedImage> flor = new HashMap();
	boolean isover = false;
	int s = 0;
	ArrayList<floor> list = new ArrayList<floor>();

	public panel() {
		fresh t1 = new fresh(this);
		t1.start();
		img = new BufferedImage(440, 400, BufferedImage.TYPE_INT_BGR);
		try {
			top = ImageIO.read(new File("img/java/top.png"));
			fakeac[0] = ImageIO.read(new File("img/java/fake0.png"));
			fakeac[1] = ImageIO.read(new File("img/java/fake1.png"));
			fakeac[2] = ImageIO.read(new File("img/java/fake2.png"));
			fakeac[3] = ImageIO.read(new File("img/java/fake3.png"));
			fakeac[4] = ImageIO.read(new File("img/java/fake5.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g2 = img.createGraphics();// ø�sg2
		man = new player();
		bk = new background();
		sp = new setpanel();
		list.add(f);// �K�[floor
		// flor.put(1, f);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	boolean right = false, left = false;

	public void right() {
		man.right();
	}

	public void left() {
		man.left();
	}

	@Override

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
			// man.right();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
			
		} else if (e.getKeyChar() == KeyEvent.VK_X) {
			// man.skill();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		left = false;
		right = false;
		go = 0;
		man.re();
		man.d = 1;
	}

	public void paint(Graphics g) {
		Imagepaint();

		g.drawImage(img, 0, 0, 440, 400, this);

	}

	int on = 0;
	int iii = 0;

	public void Imagepaint() {// ���Ϥ��ʰ_��
		y -= 1;

		sp.point();
		g2.drawImage(bk.back1, bk.x, bk.y, this);
		g2.drawImage(bk.back2, bk.x, bk.y - 400, this);

		// g2.drawRect(22, 0,398,20);
		bk.roll();
		on = 0;
		// g2.drawRect(man.getBounds().x, man.getBounds().y,
		// man.getBounds().width,
		// man.getBounds().height);

		if (time > 1000) {
			list.add(new floor()); // �K�[�sfloor
			time = 0;
		}
		man.drop();
		for (i = 0; i < list.size(); i++) {
			// ø�s�sfloor

			floor fl = list.get(i);
			;
			if (i == 0) {
				// �Ĥ@�Ӧa�O�����q�a�O
				fl.img = f.normal;
				fl.x = 190;
			}
			fl.move();
			fl.getBounds();
			// �P�_�����m
			if (man.y >= 410) {
				isover = true;
			}
			if (man.y <= 10) {
				man.unhealth();
				man.y = man.y + 5;
			}
			// �P�_����ͩR
			if (man.hel <= 0) {
				isover = true;
				sp.life(0);
				man.reco();
			}
			// g2.drawRect(fl.getBounds().x,
			// fl.getBounds().y,fl.getBounds().width,
			// fl.getBounds().height);
			// �P�_�O�_�����a�O
			if (fl.getBounds().intersects(man.getBounds())) {

				// man.re();
				on = 1;
				int type = fl.getmanfloor(list.get(i).img);
				// �P�_�a�O����
				if (type == 1) { // ��������
					man.onfloor();
					man.ontrack();
					if (iii != i) { // �O�_�S���a�O��
						man.health();
					}

				} else if (type == 2) {
					man.onfloor(); // normal
					if (iii != i) {
						man.health();
					}
				} else if (type == 3) { // spiking
					// isover = true;
					man.onfloor();
					man.onspiking();
					if (iii != i) {

						man.unhealth();
					}
				} else if (type == 4) { // spring
					man.onfloor();
					man.onspring();

					man.health();

				} else if (type == 5) { // fake
					if (iii != i) {
						man.health();
					}
					if (fl.time3 == 80) {
						// fake�a�O�ʵe
						ii++;
						fl.img = fakeac[ii];
						fl.time3 = 0;
					}
					if (ii == 4) {
						ii = 0;
					}

					fl.time3 += speed;
					man.onfloor();
					// �H�������p�ɾ�
					fl.time2 += speed;
					if (fl.time2 == 400) {

						man.y = man.y + 10;
						fl.time2 = 0;
					}
				} else if (type == 6) { // ���k����
					if (iii != i) {
						man.health();
					}
					man.onfloor();
					man.ontrackr();
				}
				iii = i;
			}
			g2.drawImage(fl.img, fl.x, fl.y, this);
			g2.drawImage(top, 22, 0, this);
		}

		man.move();
		if (man.drop) {
			// �������A
			time2 = 0; // �^�_�H���bfake�a�O�����p�ɾ�
			time3 = 0; // �^�_fake�a�O�p�ɾ�
			ii = 0;
			man.dropani();
		} else {
			// �D�����^�_�R��A
			man.re();
		}
		g2.drawImage(man.now, man.x, man.y, this);
		time += speed;

	}

	public boolean over() {
		// �P�_�����C��

		if (isover) {
			sp.save();

		}
		return isover;

	}

}
