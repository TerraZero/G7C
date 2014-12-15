package TZ.G7.Handler.Function;

import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file ToggleFunction.java
 * @project G7C
 * @identifier TZ.G7.Handler.Function
 *
 */
public interface ToggleFunction {
	
	public boolean inActive(GInput input);
	
	public boolean inDeactive(GInput input);

	public void active();
	
	public void deactive();
	
	public default boolean strickt() {
		return false;
	}
	
}
