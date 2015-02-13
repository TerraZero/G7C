package TZ.G7.Remove;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Animation.GTransform;
import TZ.G7.Component.GComponentTransition;
import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Data.Unit.GText;
import TZ.G7.Rendering.TextRendering;

/**
 * 
 * @author Terra
 * @created 30.12.2014
 * 
 * @file GMessage.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class GMessageOld extends GComponentTransition {
	
	public static void show(GCompAlt parent, String text) {
		
	}
	
	private boolean rendered;
	protected GTransform diagonal;
	protected GTransform underline;
	
	private int twidth;
	private int theight;
	
	protected String state;

	/* 
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.diagonal = new GTransform().speed(0.6f);
		this.underline = new GTransform().speed(0.6f);
		this.background.set(Color.GREEN);
		this.state = "hidden";
		this.text("Hallo das ist eine message mal sehen ob sie komplett sichtbar is");
		this.text.color(Color.GREEN);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
		switch (this.state) {
			case "show-diagonal" :
				this.diagonal.update(delta);
				if (this.diagonal.isTarget()) {
					this.state = "show-underline";
				}
				break;
			case "show-underline" : 
				this.underline.update(delta);
				if (this.underline.isTarget()) {
					this.state = "show";
				}
				break;
			case "hidden-underline" :
				this.underline.update(delta);
				if (this.underline.isTarget()) {
					this.state = "hidden-diagonal";
				}
				break;
			case "hidden-diagonal" :
				this.diagonal.update(delta);
				if (this.diagonal.isTarget()) {
					this.state = "hidden";
				}
				break;
			default :
		}
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics, int, int)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
		if (this.state != "hidden") {
			if (!this.rendered && this.state.startsWith("show")) {
				this.rendered = true;
				this.underline.set(this.text.renderingWidth(g) + 20);
				this.twidth = this.underline.getTarget();
				this.theight = this.text.renderingHeight(g);
				this.setWidth(this.diagonal.getTarget() + this.underline.getTarget());
			}
			g.setColor(this.background.get());
			g.drawLine(0, this.height(), this.diagonal.getInt(), this.height() - this.diagonal.getInt());
			g.drawLine(this.diagonal.getInt(), this.height() - this.diagonal.getInt(), this.diagonal.getInt() + this.underline.getInt(), this.height() - this.diagonal.getInt());
			if (this.state == "show") {
				this.text.renderingHeight(g);
				this.text.render(g, this.diagonal.getInt() + 20, this.height() - this.diagonal.getInt() - this.theight, this.twidth - 20, this.theight);
			}
		}
	}
	
	public void show() {
		this.state = "show-diagonal";
		this.diagonal.set(50);
		this.underline.set(this.twidth);
	}
	
	public void hidden() {
		this.state = "hidden-underline";
		this.underline.set(0);
		this.diagonal.set(0);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#text(TZ.G7.Data.GText)
	 */
	@Override
	public GCompAlt text(GText text) {
		this.rendered = false;
		return super.text(text);
	}
	
}
