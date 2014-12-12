package TZ.G7.Game.State;

import java.awt.Color;
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
	
	protected Color back;
	
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
		switch (this.state) {
			case "a" :
				g.setColor(Color.GREEN);
				break;
			case "s" :
				g.setColor(Color.RED);
				break;
			case "d" :
				g.setColor(Color.BLUE);
				break;
			case "f" :
				g.setColor(Color.ORANGE);
				break;
			case "g" :
				g.setColor(Color.YELLOW);
				break;
			default :
				g.setColor(Color.BLACK);
				break;
		}
		g.fillRect(0, 0, this.width, this.height);
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
		if (input.isPressed('f', 'g')) {
			this.state = "d";
		} else if (input.isReleased('f', 'g')) {
			this.state = "";
		}
	}
	
}
