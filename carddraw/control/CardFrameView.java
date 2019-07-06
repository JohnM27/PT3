package control;

import javax.swing.JFrame;

import model.InitializedNbCardEvent;
import view.CardFrame;
import view.CardView;
import view.HandPanel;

public class CardFrameView extends CardView {

	private CardFrame cf;
	private HandPanel hp;
	
	private int nbCard;
	
	public CardFrameView(CardController controller) {
		super(controller);
		
		buildFrame();
	}

	private void buildFrame() {
		cf = new CardFrame("M'44 Card Draw");
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		hp = new HandPanel(getController());
		cf.add(hp);
		
		cf.pack();
	}

	
	public void InitializedNbCard(InitializedNbCardEvent event) {
		nbCard = event.getNbCard();
		System.out.println("3- View receives nbCard from Model: " + event.getNbCard());
		

	}
	
	
	public void notifyController(int x) {
		getController().setNbCard(x);
	}

	
	public void display() {
		cf.setVisible(true);

	}

	
	public void close() {
		cf.dispose();

	}
}
