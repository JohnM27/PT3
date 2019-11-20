package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Farm extends Building {
	
	public Farm() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/F.png")));
		} catch (IOException e) {}
		
		setPopulation(2);
	}

}
