package TZ.G7.Animation;

import TZ.G7.GObj;
import TZ.G7.Animation.I.GAni;
import TZ.G7.Component.I.GComp;

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
public class GAnimation extends GObj implements GAni {
	
	protected String function;
	protected GComp component;
	protected long duration;

	/* 
	 * @see TZ.G7.Animation.GAni#function(java.lang.String)
	 */
	@Override
	public GAni function(String function) {
		this.function = function;
		return this;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#component(TZ.G7.Component.I.GComp)
	 */
	@Override
	public GAni component(GComp component) {
		this.component = component;
		return this;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#duration(long)
	 */
	@Override
	public GAni duration(long duration) {
		this.duration = duration;
		return this;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#update()
	 */
	@Override
	public GAni update() {
		return this;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#function()
	 */
	@Override
	public String function() {
		return this.function;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#component()
	 */
	@Override
	public GComp component() {
		return this.component;
	}

	/* 
	 * @see TZ.G7.Animation.GAni#duration()
	 */
	@Override
	public long duration() {
		return this.duration;
	}

}
