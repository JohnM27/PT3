package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LumberMill extends Building {

	public LumberMill() {
		super();
		
		try {
			double r = Math.random();
			if(r <= 0.5)
				setImg(ImageIO.read(new File("Graphismes/LumberMill.png")));
			else
				setImg(ImageIO.read(new File("Graphismes/LumberMill2.png")));
		} catch (IOException e) {}
		
		setPopulation(2);
		
		System.out.println(getLevel());
	}
}
