import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main extends JFrame {

	static main frm = new main();
	static panel p;
	static setpanel p2;

	public main() {

		setLayout(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		setVisible(true);
		p = new panel(); // 新PANEL // 遊戲介面
		p2 = new setpanel(); // 設置介面

		Container pan = getContentPane();

		pan.add(p);
		pan.add(p2);

		p.setBounds(0, 0, 440, 400);
		p2.setBounds(0, 0, 500, 500);

		addKeyListener(p);
		// p3.setVisible(false);
		// p.setVisible(false);
		// p2.setVisible(false);
		// setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void restart() {
		// 重新開始
		Container pan = getContentPane();
		pan.removeAll();
		panel p = new panel();
		setpanel p2 = new setpanel();

		pan.add(p);
		pan.add(p2);

		p.setBounds(0, 0, 440, 400);
		p2.setBounds(0, 0, 500, 500);

		addKeyListener(p);
		setResizable(false);
		validate();

	}

}
