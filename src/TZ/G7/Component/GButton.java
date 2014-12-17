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

	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g) {
		super.renderComponent(g);
		switch (state) {
			case "" :
				g.setColor(Color.YELLOW);
				break;
			case "hover" :
				g.setColor(Color.GREEN);
				break;
		}
		g.fillRect(0, 0, this.width, this.height);
		this.text.render(g, 0, 0, this.width, this.height);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
		super.eventComponent(input);
		IntReply reply = input.isIntern(this);
		if (reply.isTrue()) {
			this.state = "hover";
		} else if (reply.isFalse()) {
			this.state = "";
		}
	}
	
}
