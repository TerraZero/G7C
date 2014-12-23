package TZ.G7.Game.State;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Component.GButton;
import TZ.G7.Component.I.GComp;
import TZ.G7.Handler.GInput;
import TZ.Ints.IntReply;

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
		this.setBackground(Color.RED);
		c.text("test");
		c.text().setColor(Color.RED);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
		super.renderComponent(g, parentWidth, parentHeight);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
		super.eventComponent(input);
		IntReply intern = input.isIntern(c);
		if (intern.isTrue()) {
			//c.background(Color.BLUE);
			c.text().color(Color.GREEN);
			c.text().size(30);
		} else if (intern.isFalse()) {
			//c.background(Color.BLACK);
			c.text().color(Color.RED);
			c.text().size(13);
		}
	}
	
}
