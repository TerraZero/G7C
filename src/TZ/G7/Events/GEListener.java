package TZ.G7.Events;

/**
 * 
 * @author terrazero
 * @created Jan 12, 2015
 * 
 * @file GEListener.java
 * @project G7C
 * @identifier TZ.G7.Events
 *
 */
public interface GEListener<event extends GEEvent> {

	public void fire(event event);
	
}
