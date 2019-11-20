package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mine extends Building {

	public Mine() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/Mine.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
