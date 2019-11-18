package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Harbor extends Building {

	public Harbor() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/F.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
