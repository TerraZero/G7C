package TZ.G7.Events;

import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Jan 12, 2015
 * 
 * @file GEHandler.java
 * @project G7C
 * @identifier TZ.G7.Events
 *
 */
public class GEHandler<listener extends GEListener<event>, event extends GEEvent> extends GObj {

	protected List<listener> listeners;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.listeners = new ArrayList<listener>();
	}
	
	public void add(listener listener) {
		this.listeners.add(listener);
	}
	
	public void remove(listener listener) {
		this.listeners.remove(listener);
	}
	
	public void fire(event event) {
		for (listener l : this.listeners) {
			l.fire(event);
		}
	}
	
}
