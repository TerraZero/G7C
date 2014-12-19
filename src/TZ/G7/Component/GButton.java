package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Handler.GInput;
import TZ.Ints.IntReply;

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
	
	protected String state = "";
	protected boolean clicked;

	/* 
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		float t = 2;
		this.width.speed(t);
		this.height.speed(t);
		this.x.speed(t / 2);
		this.y.speed(t / 2);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidht, int parentHeight) {
		super.renderComponent(g, parentWidht, parentHeight);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.width(), this.height());
		this.text.render(g, 0, 0, this.width(), this.height());
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
	}
	
	public void clicked() {
		
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
		super.eventComponent(input);
		IntReply reply = input.isIntern(this);
		if (reply.isTrue()) {
			this.bounds(250, 250, 150, 150);
		} else if (reply.isFalse()) {
			this.bounds(300, 300, 50, 50);
		}
	}
	
}
