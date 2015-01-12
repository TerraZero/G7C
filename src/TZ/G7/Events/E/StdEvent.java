package TZ.G7.Events.E;

import TZ.G7.Component.I.GComp;
import TZ.G7.Events.GEEvent;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Jan 12, 2015
 * 
 * @file StdEvent.java
 * @project G7C
 * @identifier TZ.G7.Events.E
 *
 */
public class StdEvent implements GEEvent {
	
	protected GInput input;
	protected GComp comp;

	public StdEvent(GInput input, GComp comp) {
		this.input = input;
		this.comp = comp;
	}
	
	/* 
	 * @see TZ.G7.Events.GEEvent#id()
	 */
	@Override
	public int id() {
		return 1;
	}
	
	public GInput input() {
		return this.input;
	}
	
	public GComp component() {
		return this.comp;
	}

}
