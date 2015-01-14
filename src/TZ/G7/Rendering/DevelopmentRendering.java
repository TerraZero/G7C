package TZ.G7.Rendering;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Component.I.GComp;

/**
 * 
 * @author terrazero
 * @created Jan 7, 2015
 * 
 * @file DevelopmentRendering.java
 * @project G7C
 * @identifier TZ.G7.Rendering
 *
 */
public class DevelopmentRendering {

	public static void renderBorder(Graphics g, GComp component) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawRect(0, 0, component.width() - 1, component.height() - 1);
		g.setColor(c);
	}
	
}
