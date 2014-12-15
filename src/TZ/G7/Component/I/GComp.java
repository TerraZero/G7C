package TZ.G7.Component.I;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

/**
 * 
 * @author TerraZero
 * @created 02.12.2014
 * 
 * @file G7Component.java
 * @project V7S
 * @identifier TZ.G7.G7Component
 *
 */
public interface GComp {
	
	public GComp size(int width, int height);
	
	public GComp location(int x, int y);
	
	public int width();
	
	public int height();
	
	public int x();
	
	public int y();
	
	public void update(float delta);
	
	public void render(Graphics g);
	
	public void renderComponent(Graphics g);
	
	public void renderContainer(Graphics g);
	
	public List<GComp> getComponents();
	
	public GComp add(GComp component);
	
	public GComp remove(GComp component);
	
	
	
	public default String getComponent() {
		return "GComp";
	}

	public default GComp width(int width) {
		return this.size(width, this.height());
	}
	
	public default GComp height(int height) {
		return this.size(this.width(), height);
	}
	
	public default GComp x(int x) {
		return this.location(x, this.y());
	}
	
	public default GComp y(int y) {
		return this.location(this.x(), y);
	}
	
	public default GComp size(Dimension size) {
		return this.size(size.width, size.height);
	}
	
	public default GComp location(Point p) {
		return this.location(p.x, p.y);
	}
	
	public default GComp bounds(int x, int y, int width, int height) {
		return this.location(x, y).size(width, height);
	}
	
	public default GComp bounds(Point p, Dimension size) {
		return this.location(p.x, p.y).size(size.width, size.height);
	}
	
	public default GComp bounds(Rectangle bounds) {
		return this.location(bounds.x, bounds.y).size(bounds.width, bounds.height);
	}
	
	public default Dimension size() {
		return new Dimension(this.width(), this.height());
	}
	
	public default Point location() {
		return new Point(this.x(), this.y());
	}
	
	public default Rectangle bounds() {
		return new Rectangle(this.x(), this.y(), this.width(), this.height());
	}	
	
	public default void resize(int parentWidth, int parentHeight) {
		for (GComp c : this.getComponents()) {
			c.resize(this.width(), this.height());
		}
	}
	
}
