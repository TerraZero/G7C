package TZ.G7.Rendering;

import java.awt.Graphics;

import TZ.G7.Component.Mechnic.GCompAlt;

/**
 * 
 * @author Terra
 * @created 29.12.2014
 * 
 * @file BorderRendering.java
 * @project G7C
 * @identifier TZ.G7.Rendering
 *
 */
public class BorderRendering {
	
	public static void renderSide(Graphics g, int width, int middle, GCompAlt c) {
		BorderRendering.renderSide(g, width, middle, 0, 0, c.width(), c.height());
	}

	public static void renderSide(Graphics g, int width, int middle, int x, int y, int w, int h) {
		int border = (width > middle ? middle : width);
		
		g.fillRect(x, y, middle, border);
		g.fillRect(x, y, border, h);
		g.fillRect(x, y + h - border, middle, border);
		
		g.fillRect(x + w - middle, y, middle, border);
		g.fillRect(x + w - border, y, border, h);
		g.fillRect(x + w - middle, y + h - border, middle, border);
	}
	
}
