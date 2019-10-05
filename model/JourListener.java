package model;

import java.util.EventListener;

public interface JourListener extends EventListener {

	public void jourChanged(JourChangedEvent event);
}
