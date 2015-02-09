package TZ.G7;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Terra
 * @created 07.02.2015
 * 
 * @file State.java
 * @project G7C
 * @identifier TZ.G7
 *
 */
public class State<type> extends GObj {

	protected List<type> states;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.states = new ArrayList<type>();
	}
	
	public boolean is(type state) {
		type current = this.get();
		return current != null && current.equals(state);
	}
	
	public type get() {
		if (!this.states.isEmpty()) {
			return this.states.get(0);
		}
		return null;
	}
	
	public void finish() {
		this.states.remove(0);
	}
	
	public void add(type state) {
		this.states.add(state);
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return (this.get() != null ? this.get().toString() : "[null]");
	}
	
}
