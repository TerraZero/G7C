package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Config.GConfig;
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
	protected Color color;
	protected float transformColor;

	/* 
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.transformColor = 10;
		this.text.color(Color.WHITE).size(15);
		this.text.size(GConfig.singleton().getInt("text-size", 13));
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g) {
		super.renderComponent(g);
		g.setColor(new Color((int)this.transformColor, (int)this.transformColor, (int)this.transformColor));
		g.fillRect(0, 0, this.width, this.height);
		this.text.render(g, 0, 0, this.width, this.height);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
		if (this.clicked) this.clicked(); 
		if (this.state == "hover") {
			if (this.transformColor < 80) {
				this.transformColor += 0.3 * delta;
			} 
		} else if (this.state == "") {
			if (this.transformColor > 10) {
				this.transformColor -= 0.3 * delta;
			}
		}
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
			this.state = "hover";
		} else if (reply.isFalse()) {
			this.state = "";
		}
		
		this.clicked = false;
		if (input.isClick(this).isTrue()) {
			this.clicked = true;
		}
	}
	
}
