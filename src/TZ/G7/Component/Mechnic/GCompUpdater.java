package TZ.G7.Component.Mechnic;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file GCompUpdate.java
 * @project G7C
 * @identifier TZ.G7.Component.I
 *
 */
public interface GCompUpdater<data extends GCompData> {

	public void update(data data, float delta);
	
}
