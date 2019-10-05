package view;
import controller.Controller;
import model.JourListener;

public abstract class View implements JourListener{
	private Controller controller;
	
	public View(Controller controller) {
		super();
		
		this.controller = controller;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
	
	public abstract void about();
}
