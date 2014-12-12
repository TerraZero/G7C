package TZ.G7.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TZ.G7.GObj;
import TZ.G7.Canvas.GCanvas;
import TZ.G7.Exception.GException;
import TZ.G7.Game.State.GState;
import TZ.G7.Game.State.MenuState;
import TZ.G7.Handler.GInput;

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
public class GStates extends GObj {
	
	private static GStates singleton;
	
	public static GStates singleton() {
		if (GStates.singleton == null) {
			GStates.singleton = new GStates();
		}
		return GStates.singleton;
	}

	protected Map<String, GState> registry;
	protected List<GState> states;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.registry = new HashMap<String, GState>();
		this.states = new ArrayList<GState>();
		
		this.registryState(new MenuState());
		this.addState(MenuState.NAME);
	}
	
	public void registryState(GState state) {
		this.registry.put(state.name(), state);
	}
	
	public void addState(String name) {
		GState state = this.registry.get(name);
		if (state == null) {
			throw new GException("Unknown state '" + name + "'!", "State '" + name + "' was not registry");
		} else {
			this.states.add(0, state);
		}
	}
	
	public void removeState(String name) {
		GState state = this.registry.get(name);
		if (state == null) {
			throw new GException("Unknown state '" + name + "'!", "State '" + name + "' was not registry");
		} else {
			this.states.remove(state);
		}
	}
	
	public void event(GInput input) {
		for (GState state : this.states) {
			state.event(input);
			if (!state.isTransparentEvent()) break;
		}
	}

	public void update(float delta) {
		for (GState state : this.states) {
			state.update(delta);
			if (!state.isTransparentUpdate()) break; 
		}
	}
	
	public void render() {
		for (GState state : this.states) {
			GCanvas.singleton().render(state);
			if (!state.isTransparentRender()) break;
		}
	}
	
}
