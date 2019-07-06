package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardFrame extends JFrame
{
	//Size card: 100x155 ; 261*403
	
	private Pan p;
	private int nbCard;
	private Image cardback, cardbackLarge;
	private Image[] card = new Image[30];
	private Image[] cardLarge = new Image[30];
	private Image[] cardDisplayed, cardDisplayedLarge;
	private int posX, posY;
	private int handIndex = 0, handClickedNb, handClicked2Nb, cardPioche, random;
	private int[] cardPos = {413, 5, 110, 215, 320, 425, 530};
	private boolean[] handOccuped = {false, false, false, false, false, false};
	private boolean handClicked = false, piocheClicked = false, handClicked2 = false, doublePiocheClicked = false;
	
	
	
	
	public CardFrame(String title)
	{
		super(title);
		
		
		p = new Pan();
		p.setPreferredSize(new Dimension(650,613));
		p.setBackground(Color.gray);
		p.setVisible(false);
		
		try
		{
			cardback = ImageIO.read(new File("imgcard/cardBack.png"));
			cardbackLarge = ImageIO.read(new File("imgcard/cardBack_large.png"));
			
			for(int i = 0 ; i<30 ; i++)
			{
				card[i] = ImageIO.read(new File("imgcard/card" + (i+1) + ".png"));
				cardLarge[i] = ImageIO.read(new File("imgcard/cardLarge" + (i+1) + ".png"));
			}
		}
		catch(IOException e)
		{
			System.out.println("Erreur image \n" + e);
		}
		
		p.addMouseListener(new MouseL());
	}
	
	/*
	public void afterButton()
	{
		remove(handPanel);
		this.setSize(p.getPreferredSize());
		add(p);
		
		validate();
		repaint();
	}
	*/
	
	
	
	class Pan extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.drawImage(cardback, 400, 80, this);
			g.setColor(Color.white);
			g.setFont(new Font("Stencil", Font.PLAIN, 24));
			g.drawString("< Pioche", 510, 160);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			g2.drawRect(350, 260, 200, 50);
			
			g.drawString("Choix 2 cartes", 358, 293);
			
			if(piocheClicked)
			{
				this.piocheClicked(g);
				piocheClicked = false;
			}
			
			if(handClicked)
			{
				this.handClicked(g);
				handClicked = false;
			}
			
			if(handClicked2)
			{
				this.handClicked2(g);
				handClicked2 = false;
			}
		}
		
		public void piocheClicked(Graphics g)
		{
			for(int i = 1 ; i<= nbCard ; i++)
			{
				if(!handOccuped[i-1])
				{
					if((int)(Math.random() * 3) <2)
						random = (int)(Math.random() * 15);
					else random = (int)(Math.random() * 15 + 15);
					
					
					cardDisplayed[i-1] = card[random];
					cardDisplayedLarge[i-1] = cardLarge[random];
					g.drawImage(cardDisplayed[i-1], cardPos[i], cardPos[0], this);
					handOccuped[i-1] = true;
				}
				else g.drawImage(cardDisplayed[i-1], cardPos[i], cardPos[0], this);
			}
			g.drawString("< Carte précédement jouée", 276, 50);
		}
		
		
		public void doublePiocheClicked()
		{
			System.out.println("OK");
		}
		
		
		public void handClicked(Graphics g)
		{
			handOccuped[handClickedNb] = false;
			g.drawImage(cardDisplayedLarge[handClickedNb], 5, 5, this);
			for(int i = 1 ; i<= nbCard ; i++)
				if(handOccuped[i-1]) g.drawImage(cardDisplayed[i-1], cardPos[i], cardPos[0], this);
			
			g.drawString("< Carte précédement jouée", 276, 50);
		}
		
		
		public void handClicked2(Graphics g)
		{
			g.drawImage(cardDisplayedLarge[handClicked2Nb], 5, 5, this);
			for(int i = 1 ; i<= nbCard ; i++)
				if(handOccuped[i-1]) g.drawImage(cardDisplayed[i-1], cardPos[i], cardPos[0], this);
			
			g.drawString("< Zoom sur carte", 276, 50);
		}
	}
	
	
	
	class MouseL extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			posX = e.getX();
			posY = e.getY();
			
			if(posX >= 400 && posX <= 500)
				if(posY >= 80 && posY <= 235)
				{
					piocheClicked = true;
					handIndex ++;
					p.repaint();
				}
			
			if(posX >= 350 && posX <= 550)
				if(posY >= 260 && posY <= 310)
				{
					p.doublePiocheClicked();
				}
			
			if((e.getButton() == MouseEvent.BUTTON1))
			{
				if(posY >= 413 && posY <= 568)
				{
					handClickedNb = posX/105;
					handClicked = true;
					p.repaint();
				}
			}
			else
			{
				if(posY >= 413 && posY <= 568)
				{
					handClicked2Nb = posX/105;
					handClicked2 = true;
					p.repaint();
				}
			}
		}
	}
	
	
	/*
	class ButtonL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(submit4))
				nbCard = 4;
			else
				nbCard = 6;
			
			cardDisplayed = new Image[nbCard];
			cardDisplayedLarge = new Image[nbCard];
			afterButton();
		}
	}*/
}
