package TZ.G7.Actions;

import TZ.G7.Function.UpdateFunction;
import TZ.G7.Handler.GHandler;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file GKeyAction.java
 * @project G7C
 * @identifier TZ.G7.Actions
 *
 */
public class GKeyAction implements GAction {
	
	protected String trigger;
	protected UpdateFunction update;

	public GKeyAction(String trigger) {
		this.trigger = trigger;
	}
	
	public GKeyAction(String trigger, UpdateFunction update) {
		this.trigger = trigger;
		this.update = update;
	}
	
	public String getTrigger() {
		return this.trigger;
	}
	
	public UpdateFunction getAction() {
		return this.update;
	}
	
	public void setUpdate(UpdateFunction update) {
		this.update = update;
	}
	
	/* 
	 * @see TZ.G7.Actions.GAction#update(float)
	 */
	@Override
	public void update(float delta) {
		if (GHandler.singleton().keys().isAction(this.trigger)) {
			this.update.function(delta);
		}
	}

}
