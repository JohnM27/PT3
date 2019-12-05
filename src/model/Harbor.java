package model;

@SuppressWarnings("serial")
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
