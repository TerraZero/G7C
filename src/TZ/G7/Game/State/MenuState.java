package TZ.G7.Game.State;

import java.awt.Graphics;

import TZ.G7.Component.GButton;
import TZ.G7.Component.GMessage;
import TZ.G7.Component.I.GComp;
import TZ.G7.Game.GStates;
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
	
	protected GMessage message;
	protected String state;
	
	public MenuState() {
		super(MenuState.NAME);
	}
	
	GButton[] b;
	
	/* 
	 * @see TZ.G7.Game.State.GState#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.state = "";
		this.message = new GMessage();
		this.add(this.message);
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
	 * @see TZ.G7.Game.State.GState#eventState(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventState(GInput input) {
		super.eventState(input);
		if (input.isPressed('g')) {
			GStates.singleton().addState(GameState.NAME);
		}
	}
	
	public void message(String text, int x, int y) {
		if (this.message.isShow()) {
			this.message.hidden();
		} else {
			this.message.text(text).setLocation(x, y);
			this.message.show();
		}
	}
	
	public void message(String text, GComp comp) {
		this.message(text, comp.x() + comp.width(), comp.y());
	}
	
}
