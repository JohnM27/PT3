package model;

@SuppressWarnings("serial")
public class LumberMill extends Building {

	public LumberMill() {
		super();
		
		double r = Math.random();
		if(r <= 0.5)
			setImg("LumberMill.png");
		else
			setImg("LumberMill2.png");
		
		setPopulation(2);
	}
}
