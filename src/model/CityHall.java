package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CityHall extends Building {
	
	public CityHall() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/H.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
