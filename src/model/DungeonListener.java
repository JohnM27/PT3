package model;

import java.util.EventListener;

public interface DungeonListener extends EventListener {

	public void AddAdventurer(DungeonEvent event);

	public void Refresh(DungeonEvent event);

	public void DungeonGenerated(DungeonEvent event);

	public void Expedition(DungeonEvent event);
	
	public void AddAdventurerToDungeon(DungeonEvent event);

	public void NoExpedition(DungeonEvent event);

	public void SendAdventurer(DungeonEvent dungeonEvent);

	public void DeleteAdventurer(DungeonEvent event);

	public void ChangeFoodExpedition(DungeonEvent event);

}
