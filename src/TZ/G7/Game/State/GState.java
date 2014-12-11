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
	
	/*
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.actions = new ArrayList<GAction>();
	}

	public void render(Graphics g, int width, int height) {
		
	}
	
	public void update(float delta) {
		this.actions.forEach(a -> a.update(delta));
	}
	
}
