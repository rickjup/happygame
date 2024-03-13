import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//³]¸m­I´º
public class background {
	BufferedImage back1, back2;
	int x = 0, y = 0;

	public background() {
		try {
			back1 = ImageIO.read(new File("img/java/bk1.png"));
			back2 = ImageIO.read(new File("img/java/bk2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = 0;
		y =400;
	}

	// ­I´º±²°Ê
	public void roll() {
		if (y == 0) {
			y =400;
		} else {
			y -= 2;
		}

	}

}
