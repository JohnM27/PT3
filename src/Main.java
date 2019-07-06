import control.CardController;
import model.CardModel;

public class Main {

	/*
	public static void runCardFrame() {
		CardFrame f = new CardFrame("M'44 Card Draw");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}*/
	
	public static void main(String[] args) {
		CardModel cModel = new CardModel();
		CardController cController = new CardController(cModel);
		cController.displayView();
	}
}
