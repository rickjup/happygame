import java.awt.Container;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

//遊戲跑動
public class fresh extends Thread {
	background bk;
	player man;
	panel p;
	setpanel sp;

	main m;
	int speed = 10;

	public fresh(panel p) {
		this.p = p;
		bk = new background();
	}

	public void run() {
		man = new player();
		while (!p.over()) {
			// 控制左右
			if (p.right) {
				p.right();

			} else if (p.left) {
				p.left();

			}
			try {

				// bk.roll();
				// System.out.println(new Date());
				p.repaint();

				Thread.sleep(p.speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// 重製遊戲面板
		Container c = p.getParent();

		while (!(c instanceof main)) {
			c = c.getParent();
		}
		main m = (main) c;

		int result = JOptionPane.showConfirmDialog(m, "是否重新", "GG", JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			m.restart();
		} else {
			System.exit(0);
		}
	}
}
