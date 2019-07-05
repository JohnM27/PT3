package controller;

//import model;
import view.View;

public class Controller {
	//private Model model;
	private View view;
	
	public Controller(/*Model model*/) {
		//this.model = model;
		
		view = new MenuView(this);
		
		//addListenersToModel();
	}
	
	/*private void addListenersToModel() {
		
	}*/
	
	public void displayView() {
		view.display();
	}
	
	public void closeView() {
		view.close();
	}
	
	
}
