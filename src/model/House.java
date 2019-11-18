package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class House extends Building {
	
	public House() {
		super();
		
		try {
			setImg(ImageIO.read(new File("Graphismes/H.png")));
		} catch (IOException e) {}
		
		setPopulation(5);
		
		System.out.println(getLevel());
	}
	
	
}
