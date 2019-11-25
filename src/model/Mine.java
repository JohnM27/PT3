package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mine extends Building {

	public Mine() {
		super();
		
		try {
			double r = Math.random();
			if(r <= 0.5)
				setImg(ImageIO.read(new File("Graphismes/Mine.png")));
			else
				setImg(ImageIO.read(new File("Graphismes/Mine2.png")));
		} catch (IOException e) {}
		
		setPopulation(5);
	}
}
