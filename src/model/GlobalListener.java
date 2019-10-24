package model;

import java.util.EventListener;

public interface GlobalListener extends EventListener {

	public void jourChanged(JourChangedEvent event);

	public void MapGenerated(MapGeneratedEvent mapGeneratedEvent);
}
