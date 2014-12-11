package TZ.G7.Game.State;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.Actions.GAction;
import TZ.G7.Component.GComponent;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GState.java
 * @project G7C
 * @identifier TZ.G7.Game
 *
 */
public class GState extends GComponent {
	
	protected List<GAction> actions;
	protected List<GAction> addActions;
	protected List<GAction> removeActions;
	
	/*
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.actions = new ArrayList<GAction>();
		this.addActions = new ArrayList<GAction>();
		this.removeActions = new ArrayList<GAction>();
	}

	public void render(Graphics g, int width, int height) {
		
	}
	
	public void update(float delta) {
		this.actions.forEach(a -> a.update(delta));
		this.actions.addAll(this.addActions);
		this.addActions.clear();
		this.actions.removeAll(this.removeActions);
		this.removeActions.clear();
	}
	
	public void addAction(GAction action) {
		this.addActions.add(action);
	}
	
	public void removeAction(GAction action) {
		this.removeActions.add(action);
	}
	
}
