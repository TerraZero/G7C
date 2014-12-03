/**
 * 
 */
package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.GObj;
import TZ.G7.Component.I.GBackground;

/**
 * 
 * @author Terra
 * @created 03.12.2014
 * 
 * @file DefaultBackground.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class DefaultBackground extends GObj implements GBackground {
	
	protected Color color;
	
	public DefaultBackground() {
		this.color = Color.BLACK;
	}
	
	public DefaultBackground(Color color) {
		this.color = color;
	}

	/*
	 * @see TZ.G7.Component.I.GBackground#render(java.awt.Graphics, int, int)
	 */
	@Override
	public void render(Graphics g, int width, int height) {
		g.setColor(this.color);
		g.fillRect(0, 0, width, height);
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
