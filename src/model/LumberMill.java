package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LumberMill extends Building {

	public LumberMill() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/L.png")));
		} catch (IOException e) {e.printStackTrace();}
		
		setPopulation(2);
		
		System.out.println(getLevel());
	}
}
