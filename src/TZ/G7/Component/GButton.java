package TZ.G7.Component;

import java.awt.Graphics;

import TZ.G7.Events.E.StdEvent;
import TZ.G7.Events.E.StdHandler;
import TZ.G7.Events.E.StdListener;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file GButton.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class GButton extends GComponent {
	
	protected StdHandler click;

	/* 
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.click = new StdHandler();
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidht, int parentHeight) {
		super.renderComponent(g, parentWidht, parentHeight);
		this.text.render(g, this);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
		super.eventComponent(input);
		if (input.isClick(this).isTrue()) {
			this.click.fire(new StdEvent(input, this));
		}
	}
	
	public void click(StdListener listener) {
		this.click.add(listener);
	}
	
}
