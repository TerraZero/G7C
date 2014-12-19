package TZ.G7.Game.State;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Component.GButton;
import TZ.G7.Component.I.GComp;

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
	
	GComp c;
	
	/* 
	 * @see TZ.G7.Game.State.GState#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.state = "";
		c = new GButton();
		this.add(c);
		c.setBounds(10, 200, 200, 80);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
		super.renderComponent(g, parentWidth, parentHeight);
		g.setColor(Color.RED);
		g.fillRect(0, 0, this.width(), this.height());
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
	}
	
}
