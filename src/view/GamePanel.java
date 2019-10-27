package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class GamePanel extends JPanel {
	private Controller controller;
	
	private JLabel essai;
	
	public GamePanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		this.setBackground(new Color(255, 255, 255));
		
		essai = new JLabel("ON TESTE NOTRE PATTERN MVC");
		essai.setBackground(new Color(0, 0, 0));
		add(essai);
	}

}
