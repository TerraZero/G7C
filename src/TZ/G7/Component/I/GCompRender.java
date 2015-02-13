package TZ.G7.Component.I;

import java.awt.Graphics;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file GCompRender.java
 * @project G7C
 * @identifier TZ.G7.Component.I
 *
 */
public interface GCompRender<data extends GCompData> {

	public void render(data data, Graphics g, int x, int y, int width, int height);
	
}
