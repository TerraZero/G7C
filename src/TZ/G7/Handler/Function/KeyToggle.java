package TZ.G7.Handler.Function;

import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file KeyToggle.java
 * @project G7C
 * @identifier TZ.G7.Handler.Function
 *
 */
public abstract class KeyToggle implements ToggleFunction {
	
	protected char toggle;

	public KeyToggle(char c) {
		this.toggle = c;
	}
	
	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#isPressed(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inActive(GInput input) {
		return input.isPressed(this.toggle);
	}

	/* 
	 * @see TZ.G7.Handler.Function.ToggleFunction#isReleased(TZ.G7.Handler.GInput)
	 */
	@Override
	public boolean inDeactive(GInput input) {
		return input.isReleased(this.toggle);
	}

}
