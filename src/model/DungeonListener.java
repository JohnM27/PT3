package model;

import java.util.EventListener;

public interface DungeonListener extends EventListener {

	public void AddAdventurer(DungeonEvent event);

	public void Refresh(DungeonEvent event);

}
