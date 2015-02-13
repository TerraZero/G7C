package TZ.G7.Component.I;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file GCompData.java
 * @project G7C
 * @identifier TZ.G7.Component.I
 *
 */
public interface GCompData {
	
	public GCompData size(int width, int height);
	
	public GCompData setSize(int width, int height);
	
	public GCompData location(int x, int y);
	
	public GCompData setLocation(int x, int y);

	public int width();
	
	public int height();
	
	public int x();
	
	public int y();
	
	public int dwidth();
	
	public int dheight();
	
	public int dx();
	
	public int dy();
	
	public Color background();
	
	public Color dbackground();
	
	public GCompData background(Color background);
	
	public GCompData setBackground(Color background);
	
	// default
	
	public default GCompData width(int width) {
		return this.size(width, this.height());
	}
	
	public default GCompData setWidth(int width) {
		return this.setSize(width, this.height());
	}
	
	public default GCompData height(int height) {
		return this.size(this.width(), height);
	}
	
	public default GCompData setHeight(int height) {
		return this.setSize(this.width(), height);
	}
	
	public default GCompData x(int x) {
		return this.location(x, this.y());
	}
	
	public default GCompData setX(int x) {
		return this.setLocation(x, this.y());
	}
	
	public default GCompData y(int y) {
		return this.location(this.x(), y);
	}
	
	public default GCompData setY(int y) {
		return this.setLocation(this.x(), y);
	}
	
	public default GCompData size(Dimension size) {
		return this.size(size.width, size.height);
	}
	
	public default GCompData setSize(Dimension size) {
		return this.setSize(size.width, size.height);
	}
	
	public default GCompData location(Point p) {
		return this.location(p.x, p.y);
	}
	
	public default GCompData setLocation(Point p) {
		return this.setLocation(p.x, p.y);
	}
	
	public default GCompData bounds(int x, int y, int width, int height) {
		return this.location(x, y).size(width, height);
	}
	
	public default GCompData setBounds(int x, int y, int width, int height) {
		return this.setLocation(x, y).setSize(width, height);
	}
	
	public default GCompData bounds(Point p, Dimension size) {
		return this.location(p.x, p.y).size(size.width, size.height);
	}
	
	public default GCompData setBounds(Point p, Dimension size) {
		return this.setLocation(p.x, p.y).setSize(size.width, size.height);
	}
	
	public default GCompData bounds(Rectangle bounds) {
		return this.location(bounds.x, bounds.y).size(bounds.width, bounds.height);
	}
	
	public default GCompData setBounds(Rectangle bounds) {
		return this.setLocation(bounds.x, bounds.y).setSize(bounds.width, bounds.height);
	}
	
}
