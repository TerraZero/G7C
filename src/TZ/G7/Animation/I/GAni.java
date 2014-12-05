package TZ.G7.Animation.I;

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
public interface GAni {

	public GAni function(String function);
	
	public GAni component(GComp component);
	
	public GAni duration(long duration);
	
	public GAni update();
	
	public String function();
	
	public GComp component();
	
	public long duration();
	
}
