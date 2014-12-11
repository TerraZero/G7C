package TZ.G7.Game;

import TZ.G7.Canvas.GCanvas;
import TZ.G7.Game.State.MenuState;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GStates.java
 * @project G7C
 * @identifier TZ.G7
 *
 */
public class GStates {
	
	private static GStates singleton;
	
	protected String state;
	
	protected MenuState menu;
	
	public static GStates singleton() {
		if (GStates.singleton == null) {
			GStates.singleton = new GStates();
		}
		return GStates.singleton;
	}
	
	public GStates() {
		this.menu = new MenuState();
		this.state = MenuState.STATE;
	}

	public void update(float delta) {
		switch (this.state) {
			case "option"  :
				
				break;
			case "game" :
				
				break;
			case MenuState.STATE :
				this.menu.update(delta);
				break;
		}
	}
	
	public void render() {
		switch (this.state) {
			case "option"  :
				
			case "game" :
				
				break;
			case MenuState.STATE :
				GCanvas.singleton().render(this.menu);
				break;
		}
	}
	
	public void set(String state) {
		this.state = state;
	}
	
}
