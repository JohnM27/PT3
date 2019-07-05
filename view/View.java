package view;
import controller.Controller;

public abstract class View {
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
}
