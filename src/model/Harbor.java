package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Harbor extends Building {

	public Harbor() {
		super();
		
		double r = Math.random();
		if(r <= 0.5)
			setImg("Harbor.png");
		else
			setImg("Harbor2.png");
		
		setPopulation(3);
	}
}
