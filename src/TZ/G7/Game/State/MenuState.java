package TZ.G7.Game.State;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import TZ.G7.Component.GButton;
import TZ.G7.Component.I.GComp;
import TZ.G7.Loader.FLoader;

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
		c.bounds(200, 200, 200, 80);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g) {
		super.renderComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, this.width, this.height);
	}
	
	boolean b;
	FLoader loader = new FLoader("~", "test-3.csv");
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
		if (loader.load()) {
			if (b) {
				c.x(c.x() - 10);
			} else {
				c.x(c.x() + 10);
			}
			if (c.x() < 200 || c.x() > 600) {
				b = !b;
			}
		} else {
			System.out.println(loader.data().size());
		}
		
	}
	
}
