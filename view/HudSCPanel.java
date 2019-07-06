package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HudSCPanel extends JPanel {
	 int typeCase = 1000;
	 
	 private JLabel essai;
	 
	 public HudSCPanel() {
		 super();
		 
		 this.setPreferredSize(new Dimension(1300, 380));
		 
		 switch(typeCase) {
		 	default:
		 		essai = new JLabel("Rien n'a été sélectionné");
		 		add(essai);
		 		break;
		 }
		 
	 }

}
