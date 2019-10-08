package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class HudSCPanel extends JPanel {
	private Controller controller;
	 int typeCase = 1000;
	 
	 private JLabel essai;
	 
	 public HudSCPanel(Controller controller) {
		 super();
		 
		 this.controller = controller;
		 
		 //this.setPreferredSize(new Dimension(1300, 240));
		 //this.setPreferredSize(new Dimension(832, 158));
		 this.setBackground(new Color(255,100,100));
		 
		 switch(typeCase) {
		 	default:
		 		essai = new JLabel("Rien n'a été sélectionné");
		 		add(essai);
		 		break;
		 }
		 
	 }

}
