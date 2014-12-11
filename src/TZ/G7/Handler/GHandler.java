package TZ.G7.Handler;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file GActions.java
 * @project G7C
 * @identifier TZ.G7.Actions
 *
 */
public class GHandler extends GObj {
	
	private static GHandler singleton;
	
	public static GHandler singleton() {
		if (GHandler.singleton == null) {
			GHandler.singleton = new GHandler();
		} 
		return GHandler.singleton;
	}

	protected GKeyHandler keys;
	
	@Override
	protected void init() {
		super.init();
		this.keys = new GKeyHandler();
	}
	
	public GKeyHandler keys() {
		return this.keys;
	}
	
	public void preFrame() {
		this.keys.preFrame();
	}
	
	public void purge() {
		this.keys.purge();
	}
	
}
