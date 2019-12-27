package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import controller.Controller;
import model.DungeonEvent;
import model.DungeonListener;

public class DungeonView extends View implements DungeonListener {
	
	private JFrame frame;
	
	private DungeonCPanel dungeonCPanel;
	private DungeonSPanel dungeonSPanel;
	private DungeonWPanel dungeonWPanel;
	private JScrollPane scroll;
	
	public DungeonView(Controller controller, JFrame frame) {
		super(controller);
		
		this.frame = frame;
		
		dungeonCPanel = new DungeonCPanel();
		dungeonSPanel = new DungeonSPanel(super.getController());
		dungeonWPanel = new DungeonWPanel(super.getController());
		
		scroll = new JScrollPane(dungeonWPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI()
	    {   
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
	        
	        protected void configureScrollBarColors() {
	            this.thumbColor = new Color(200,200,200);
	            this.thumbHighlightColor = new Color(150,150,150);
	        }
	    });
	}

	public void display() {
		
		frame.add(dungeonCPanel, BorderLayout.CENTER);
		frame.add(dungeonSPanel, BorderLayout.SOUTH);
		frame.add(scroll, BorderLayout.WEST);
		
		frame.revalidate();
		frame.repaint();
	}

	public void close() {
		frame.getContentPane().removeAll();
	}

	@Override
	public void AddAdventurer(DungeonEvent event) {
		dungeonWPanel.addAdventurer(event.getLastAdventurer());
		dungeonSPanel.getCenter().display(event.getNbGold());
	}

	@Override
	public void Refresh(DungeonEvent event) {
		dungeonWPanel.addAllAdventurer(event.getAdventurers());
	}

	public void DungeonGenerated(DungeonEvent event) {
		dungeonCPanel.displayDungeon();
	}

	public void Expedition(DungeonEvent event) {
		dungeonSPanel.getCenter().displayExpedition();
		ChangeFoodExpedition(event);
	}
	
	public void AddAdventurerToDungeon(DungeonEvent event) {
		dungeonSPanel.getCenter().addAdventurer(event.getAdventurer(), event.getNbAdventurerInDungeon());
		ChangeFoodExpedition(event);
		dungeonWPanel.disableButton(event.getAdventurerInDungeon());
	}

	public void NoExpedition(DungeonEvent event) {
		dungeonSPanel.getCenter().display(event.getNbGold());
		dungeonWPanel.enableAllButton();
	}

	@Override
	public void SendAdventurer(DungeonEvent dungeonEvent) {
		//je sais pas ce que tu modifier comme panneau ici donc à toi de me dire
		System.out.println("Let's go for an adventurer !!!!!");
	}

	@Override
	public void DeleteAdventurer(DungeonEvent event) {
		dungeonSPanel.getCenter().removeAdventurer(event.getDigitAdvRemove(), event.getNbAdventurerInDungeon());
		dungeonWPanel.enableButton(event.getAdvRemove());
	}
	
	public void ChangeFoodExpedition(DungeonEvent event) {
		dungeonSPanel.getCenter().changeFood(event.getNbFood(), event.getNbFoodInDg());
	}
}
