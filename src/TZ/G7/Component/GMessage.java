package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Animation.GTransformControlled;
import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Data.Unit.GText;

/**
 * 
 * @author terrazero
 * @created Jan 7, 2015
 * 
 * @file GMess.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class GMessage extends GComponentTransition {
	
	public static GMessage show(GCompAlt parent, String text, int x, int y) {
		return new GMessage(parent, text, x, y).show();
		
	}

	protected GTransformControlled diagonal;
	protected GTransformControlled underline;
	
	private int twidth;
	private int theight;
	private boolean rendered;
	
	private int diagonalLength;
	
	protected GMessageState state;
	
	public GMessage() {
	}
	
	public GMessage(String text) {
		this.text(text);
	}
	
	public GMessage(String text, int x, int y) {
		this.text(text).setLocation(x, y);
	}
	
	public GMessage(GCompAlt parent, String text, int x, int y) {
		this.text(text).setLocation(x, y);
		parent.add(this);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.diagonalLength = 30;
		
		this.diagonal = new GTransformControlled(this.diagonalLength).speed(0.8f);
		this.underline = new GTransformControlled().speed(0.8f);
		this.state = GMessageState.HIDDEN;
		this.height(this.diagonalLength);
		
		// dev
		this.background.set(Color.CYAN);
		this.text.color(Color.CYAN);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		super.updateComponent(delta);
		switch (this.state) {
			case SHOW_DIAGONAL :
				if (this.diagonal.updateUp(delta)) {
					this.state = GMessageState.SHOW_UNDERLINE;
				}
				break;
			case SHOW_UNDERLINE :
				if (this.underline.updateUp(delta)) {
					this.state = GMessageState.SHOW;
				}
				break;
			case HIDDEN_UNDERLINE : 
				if (this.underline.updateDown(delta)) {
					this.state = GMessageState.HIDDEN_DIAGONAL;
				}
				break;
			case HIDDEN_DIAGONAL : 
				if (this.diagonal.updateDown(delta)) {
					this.state = GMessageState.HIDDEN;
				}
				break;
			default :
				break;
		}
		this.setWidth(this.diagonal.getInt() + this.underline.getInt());
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#renderComponent(java.awt.Graphics, int, int)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
		if (this.state != GMessageState.HIDDEN) {
			if (!this.rendered) {
				this.rendered = true;
				this.twidth = this.text.renderingWidth(g) + 40;
				this.theight = this.text.renderingHeight(g);
				this.underline.target(twidth);
				this.setHeight(this.diagonalLength + this.theight);
				this.setY(this.y() - this.height());
			}
			
			g.setColor(this.background.get());
			g.drawLine(0, this.height(), this.diagonal.getInt(), this.height() - this.diagonal.getInt());
			g.drawLine(this.diagonal.getInt(), this.height() - this.diagonal.getInt(), this.diagonal.getInt() + this.underline.getInt(), this.height() - this.diagonal.getInt());
			if (this.state == GMessageState.SHOW) {
				this.text.render(g, this.diagonal.getInt() + 20, this.height() - this.diagonal.getInt() - this.theight, this.twidth - 40, this.theight);
			}
		}
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#text(TZ.G7.Data.GText)
	 */
	@Override
	public GCompAlt text(GText text) {
		this.rendered = false;
		return super.text(text);
	}
	
	public GCompAlt text(String text) {
		this.rendered = false;
		return super.text(text);
	}
	
	public GMessage show() {
		switch (this.state) {
			case HIDDEN :
			case HIDDEN_DIAGONAL : 
				this.state = GMessageState.SHOW_DIAGONAL;
				break;
			case HIDDEN_UNDERLINE :
				this.state = GMessageState.SHOW_UNDERLINE;
				break;
			default :
				break;
		}
		return this;
	}
	
	public GMessage hidden() {
		switch (this.state) {
			case SHOW :
			case SHOW_UNDERLINE : 
				this.state = GMessageState.HIDDEN_UNDERLINE;
				break;
			case SHOW_DIAGONAL :
				this.state = GMessageState.HIDDEN_DIAGONAL;
				break;
			default : 
				break;
		}
		return this;
	}
	
	public boolean isShow() {
		return this.state == GMessageState.SHOW;
	}
	
	public boolean isHidden() {
		return this.state == GMessageState.HIDDEN;
	}
	
	public boolean isInAnimation() {
		return this.state != GMessageState.HIDDEN && this.state == GMessageState.SHOW;
	}
	
	public GMessageState getState() {
		return this.state;
	}
	
}

enum GMessageState {

	SHOW,
	HIDDEN,
	
	SHOW_DIAGONAL,
	SHOW_UNDERLINE,
	HIDDEN_UNDERLINE,
	HIDDEN_DIAGONAL
	
}