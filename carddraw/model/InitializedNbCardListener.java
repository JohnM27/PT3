package model;

import java.util.EventListener;

public interface InitializedNbCardListener extends EventListener {

	public void InitializedNbCard(InitializedNbCardEvent event);
}
