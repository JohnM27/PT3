package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class House extends Building {
	
	public House() {
		super();
		
		try {
			double r = Math.random();
			if(r <= 0.5)
				setImg(ImageIO.read(new File("Graphismes/House.png")));
			else
				setImg(ImageIO.read(new File("Graphismes/House2.png")));
		} catch (IOException e) {}
		
		setPopulation(5);
	}
}
