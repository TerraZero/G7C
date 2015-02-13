package TZ.G7.Component.I;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file GComp.java
 * @project G7C
 * @identifier TZ.G7.Component.I
 *
 */
public interface GComp<data extends GCompData, updater extends GCompUpdater<data>, render extends GCompRender<data>> {

	public data data();
	
	public updater updater();
	
	public render render();
	
}
