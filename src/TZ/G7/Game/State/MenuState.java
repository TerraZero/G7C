package TZ.G7.Game.State;

import java.awt.Graphics;

import TZ.G7.Handler.GInput;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file MenuState.java
 * @project G7C
 * @identifier TZ.G7.Game.State
 *
 */
public class MenuState extends GState {
	
	public static final String NAME = "menu";
	
	private static MenuState singleton;
	
	public static MenuState singleton() {
		if (MenuState.singleton == null) {
			MenuState.singleton = new MenuState();
		}
		return MenuState.singleton;
	}
	
	protected String state;
	
	public MenuState() {
		super(MenuState.NAME);
	}
	
	/* 
	 * @see TZ.G7.Game.State.GState#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.state = "";
	}

	/* 
	 * @see TZ.G7.Game.State.GState#render(java.awt.Graphics, int, int)
	 */
	@Override
	public void render(Graphics g, int width, int height) {
		super.render(g, width, height);
		this.bounds(0, 0, width, height);
		this.render(g);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		super.render(g);
	}
	
	/* 
	 * @see TZ.G7.Game.State.GState#update(float)
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
	}
	
	/* 
	 * @see TZ.G7.Game.State.GState#event(TZ.G7.Handler.GInput)
	 */
	@Override
	public void event(GInput input) {
		super.event(input);
	}
	
}
