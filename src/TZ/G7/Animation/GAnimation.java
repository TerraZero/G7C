package TZ.G7.Animation;

import TZ.G7.GObj;
import TZ.G7.Actions.GAction;
import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Game.State.GState;

/**
 * 
 * @author Terra
 * @created 04.12.2014
 * 
 * @file GAnimation.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public abstract class GAnimation extends GObj implements GAction {
	
	protected GState state;
	protected GCompAlt component;
	protected int duration;
	
	public GAnimation(GState state, GCompAlt component, int duration) {
		this.component = component;
		this.duration = duration;
		this.state = state;
		this.state.addAction(this);
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
	}
	
	public int duration() {
		return this.duration;
	}
	
	public GCompAlt component() {
		return this.component;
	}
	
	public GState state() {
		return this.state;
	}
	
	/* 
	 * @see TZ.G7.Actions.GAction#update(float)
	 */
	@Override
	public void update(float delta) {
		this.animation(delta);
		if (this.finished()) {
			state.removeAction(this);
		}
	}
	
	public abstract void animation(float delta);
	
	public abstract boolean finished();

}
