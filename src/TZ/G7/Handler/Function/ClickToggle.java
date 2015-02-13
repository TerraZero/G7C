package TZ.G7.Handler.Function;

import TZ.G7.Component.GComponentTransition;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file ClickToggle.java
 * @project G7C
 * @identifier TZ.G7.Handler.Function
 *
 */
public abstract class ClickToggle extends ComponentToggle {
	
	protected boolean state;
	
	public ClickToggle(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public ClickToggle(GComponentTransition c) {
		super(c);
	}
	
	public boolean state() {
		return this.state;
	}
	
	public void state(boolean state) {
		this.state = state;
	}

	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#inActive(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inActive(GInput input) {
		if (!this.state && input.isClick(this.x, this.y, this.w, this.h).isTrue()) {
			this.state = true;
			return true;
		}
		return false;
	}

	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#inDeactive(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inDeactive(GInput input) {
		if (this.state && input.isClick(this.x, this.y, this.w, this.h).isTrue()) {
			this.state = false;
			return true;
		}
		return false;
	}
	
	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#strickt()
	 */
	@Override
	public boolean strickt() {
		return true;
	}

}
