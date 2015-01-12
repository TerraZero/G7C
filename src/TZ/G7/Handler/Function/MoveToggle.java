package TZ.G7.Handler.Function;

import TZ.G7.Component.GComponent;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file MoveToggle.java
 * @project G7C
 * @identifier TZ.G7.Handler.Function
 *
 */
public abstract class MoveToggle extends ComponentToggle {
	
	public MoveToggle(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public MoveToggle(GComponent c) {
		super(c);
	}

	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#inActive(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inActive(GInput input) {
		return input.isIntern(this.x, this.y, this.w, this.h).isTrue();
	}

	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#inDeactive(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inDeactive(GInput input) {
		return input.isExtern(this.x, this.y, this.w, this.h).isTrue();
	}

}
