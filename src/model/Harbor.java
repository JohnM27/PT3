package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Harbor extends Building {

	public Harbor() {
		super();
		
		try {
			double r = Math.random();
			if(r <= 0.5)
				setImg(ImageIO.read(new File("Graphismes/Harbor.png")));
			else
				setImg(ImageIO.read(new File("Graphismes/Harbor2.png")));
		} catch (IOException e) {}
		
		setPopulation(3);
	}
}
