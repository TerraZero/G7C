package TZ.G7.Handler.Function;

import TZ.G7.Component.GComponentTransition;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file ComponentToggle.java
 * @project G7C
 * @identifier TZ.G7.Handler.Function
 *
 */
public abstract class ComponentToggle implements ToggleFunction {
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public ComponentToggle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public ComponentToggle(GComponentTransition c) {
		this.x = c.x();
		this.y = c.y();
		this.w = c.width();
		this.h = c.height();
	}

}
