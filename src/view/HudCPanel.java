package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.Controller;

public class HudCPanel extends JPanel {
	private Controller controller;

	private Image[][] img;
	private Image[][] imgOver;
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		this.addMouseListener(controller);
		this.setPreferredSize(new Dimension(1098, 610));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 610; i = i+61) {
			for(int j = 0; j < 1098; j = j+61) {
				g.drawImage(img[i/61][j/61], j, i, this);
				
				if(imgOver[i/61][j/61] != null) {
					g.drawImage(imgOver[i/61][j/61], j, i, this);
				}
			}
		}
	}
//
	public void mapGenerated(Image[][] img, Image[][] imgOver) {
		this.img = img;
		this.imgOver = imgOver;
	}
	
	public void fogOff(int i, int j) {
		this.imgOver[i][j] = null;
		repaint();
	}
}
