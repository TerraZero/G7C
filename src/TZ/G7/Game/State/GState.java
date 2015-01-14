package TZ.G7.Game.State;

import java.awt.Graphics;

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
	
	protected boolean transparentUpdate;
	protected boolean transparentRender;
	protected boolean transparentEvent;
	protected String name;
	
	public GState(String name) {
		this.name = name;
	}
	
	/*
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
	}
	
	public boolean isTransparentUpdate() {
		return this.transparentUpdate;
	}
	
	public boolean isTransparentRender() {
		return this.transparentRender;
	}
	
	public boolean isTransparentEvent() {
		return this.transparentEvent;
	}
	
	public String name() {
		return this.name;
	}
	
	public void render(Graphics g, int parentWidth, int parentHeight) {
		this.setBounds(0, 0, parentWidth, parentHeight);
		super.render(g, parentWidth, parentHeight);
	}
	
	public void stateInit() {
		
	}
	
	public void stateLoad() {
		
	}
	
	public void stateClose() {
		
	}
	
	public void statePurge() {
		
	}
	
}
