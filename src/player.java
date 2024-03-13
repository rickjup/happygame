import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

public class player {
	BufferedImage now, stop;
	BufferedImage pleft0, pleft1, pleft2, pleft3;// player �V���]
	BufferedImage pright0, pright1, pright2, pright3;// player�V�k�]
	BufferedImage pdrop1, pdrop2, pdrop3; // �V�U��
	panel p;
	setpanel sp;
	floor f;
	fresh fr;
	int hel = 6;
	boolean isover = false; // �����P�w
	boolean drop = true; // �����P�w
	int type = 0;
	int x = 0, y = 0; // �y��
	int fallspeed = 3; // �����t��
	int onfloorspeed = fallspeed + 1;
	int sec = 0;
	int stepTimer = 0;// �p�ɾ�
	int fresh = panel.speed;
	int re = 0;

	public player() {
		fr = new fresh(p);
		sp = new setpanel();

		try {
			// �פJ�H���Ϥ�
			stop = ImageIO.read(new File("img/output/player_000.png"));
			pleft0 = ImageIO.read(new File("img/output/player_001.png"));
			pleft1 = ImageIO.read(new File("img/output/player_002.png"));
			pleft2 = ImageIO.read(new File("img/output/player_003.png"));
			pleft3 = ImageIO.read(new File("img/output/player_004.png"));
			pright0 = ImageIO.read(new File("img/output/player_010.png"));
			pright1 = ImageIO.read(new File("img/output/player_011.png"));
			pright2 = ImageIO.read(new File("img/output/player_012.png"));
			pright3 = ImageIO.read(new File("img/output/player_013.png"));
			pdrop1 = ImageIO.read(new File("img/output/player_038.png"));
			pdrop2 = ImageIO.read(new File("img/output/player_039.png"));
			pdrop3 = ImageIO.read(new File("img/output/player_040.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = 220;
		y = 21;

		now = stop;
		// System.out.println(fr.speed);
	}

	// �����P�w
	public void drop() {
		drop = true;
	}

	public void skill() {

		// y-=45;

	}

	/*
	 * public void life() { if(hel>=0) { hel=hel-3; } else { isover = true; }
	 * sp.life(hel);
	 * 
	 * 
	 * }
	 */
	public void move() {
		// ���U��
		// sec += fr.speed;

		// System.out.println(x);
		y += fallspeed;

	}

	public void right() {
		if (x < 389) {
			x += 4;
		}
		int tmp = stepTimer / 20 % 4;

		switch (tmp) {
		case 0:
			now = pright0;
			break;
		case 1:
			now = pright1;
			break;
		case 2:
			now = pright2;
			break;
		default:
			now = pright3;
			break;
		}
		stepTimer += fresh;
	}

	public void left() {
		if (x > 20) {
			x -= 4;
		}
		int tmp = stepTimer / 20 % 4;

		switch (tmp) {
		case 0:
			now = pleft0;
			break;
		case 1:
			now = pleft1;
			break;
		case 2:
			now = pleft2;
			break;
		default:
			now = pleft3;
			break;
		}
		stepTimer += fresh;
	}

	public void re() {
		// �^�_�R��ʵe
		if (d == 1) {
			now = stop;

			d = 0;

		}

	}

	int d = 0, dd = 0;

	public void reco() {
		hel = 6; // ���s�C����_�ͩR
	}

	public void dropani() {
		// �����ʵe
		int tmp = stepTimer / 30 % 3;
		if (tmp == 0) {
			now = pdrop1;
		} else if (tmp == 1) {
			now = pdrop2;
		} else {
			now = pdrop3;
		}
		d = 1;
		stepTimer += fresh;
	}

	// ���a��m�d��
	public Rectangle getBounds() {
		return new Rectangle(x + 4, y + 30, now.getWidth() - 10, now.getHeight() - 30);

	}

	public void onfloor() {
		/*
		 * if(hel<6) { hel++;} sp.life(hel);
		 */
		// �b�a�O�W
		drop = false;
		y -= onfloorspeed;
		boolean onfl = true;

	}

	public void health() {
		// �[�ͩR
		if (hel < 6) {
			hel++;
			sp.life(hel);
		}
	}

	public void unhealth() {
		// ���ͩR
		hel = hel - 3;
		sp.life(hel);

	}

	public void ontrack() {
		// ��������

		drop = false;
		if (x > 20) {
			x -= 2;
		}
	}

	public void ontrackr() {
		// ���k����
		if (x < 389) {

			x += 2;
		}
		drop = false;
	}

	static int k = 0;

	public void onspiking() {

	}

	public void onspring() {
		// �u®
		drop = false;
		// �p�ɾ�����u���t�v
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				y -= 10;
				k = k + 1;
				if (k == 4) {
					t.cancel();
					k = 0;
				}
			}

		};
		t.schedule(tt, 0, 20);

	}

}
