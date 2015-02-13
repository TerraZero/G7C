package TZ.G7.Animation;

import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Game.State.GState;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file SizeAnimation.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class SizeAnimation extends GAnimation {
	
	protected float startwidth;
	protected float startheight;
	
	protected float widthspeed;
	protected float heightspeed;
	
	protected int width;
	protected int height;
	
	public SizeAnimation(GState state, GCompAlt component, int duration, int width, int height) {
		super(state, component, duration);
		this.widthspeed = (width - this.component.width()) / duration;
		this.heightspeed = (height - this.component.height()) / duration;
		this.startwidth = this.component.width();
		this.startheight = this.component.height();
		this.width = width;
		this.height = height;
	}

	/* 
	 * @see TZ.G7.Animation.GAnimation#finished()
	 */
	@Override
	public boolean finished() {
		return this.component.width() == this.width && this.component.height() == this.height;
	}

	/* 
	 * @see TZ.G7.Animation.GAnimation#animation(float)
	 */
	@Override
	public void animation(float delta) {
		this.startwidth += this.widthspeed / delta;
		this.startheight += this.heightspeed / delta;
		if (this.width != this.component.width()) this.component.width((int)this.startwidth);
		if (this.height != this.component.height()) this.component.height((int)this.startheight);
	}

}
