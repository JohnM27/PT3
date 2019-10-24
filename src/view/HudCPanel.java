package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;
import model.Map;

public class HudCPanel extends JPanel {
	private Controller controller;

	private Image[][] img;
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		//this.img = img;
		
		this.addMouseListener(controller);
		this.setPreferredSize(new Dimension(1098, 610));
		
		//m.genererMap();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 610; i = i+61) {
			for(int j = 0; j < 1098; j = j+61) {
				g.drawImage(img[i/61][j/61], j, i, this);
			}
		}
	}

	public void mapGenerated(Image[][] img) {
		this.img = img;
	}
}
