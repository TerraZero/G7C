package TZ.G7.Component.I;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import TZ.G7.Data.Unit.GText;
import TZ.G7.Handler.GInput;

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
public interface GCompAlt {
	
	public GCompAlt size(int width, int height);
	
	public GCompAlt setSize(int width, int height);
	
	public GCompAlt location(int x, int y);
	
	public GCompAlt setLocation(int x, int y);
	
	public GCompAlt background(Color background);
	
	public GCompAlt setBackground(Color background);
	
	public int width();
	
	public int height();
	
	public int x();
	
	public int y();
	
	public Color background();
	
	public void updateComponent(float delta);
	
	public void eventComponent(GInput input);
	
	public void renderComponent(Graphics g, int parentWidth, int parentHeight);
	
	public List<GCompAlt> getComponents();
	
	public GCompAlt add(GCompAlt component);
	
	public GCompAlt remove(GCompAlt component);
	
	public GCompAlt text(GText text);
	
	public GText text();
	
	
	
	// defaults
	
	public default String getComponent() {
		return "GComp";
	}

	public default GCompAlt width(int width) {
		return this.size(width, this.height());
	}
	
	public default GCompAlt setWidth(int width) {
		return this.setSize(width, this.height());
	}
	
	public default GCompAlt height(int height) {
		return this.size(this.width(), height);
	}
	
	public default GCompAlt setHeight(int height) {
		return this.setSize(this.width(), height);
	}
	
	public default GCompAlt x(int x) {
		return this.location(x, this.y());
	}
	
	public default GCompAlt setX(int x) {
		return this.setLocation(x, this.y());
	}
	
	public default GCompAlt y(int y) {
		return this.location(this.x(), y);
	}
	
	public default GCompAlt setY(int y) {
		return this.setLocation(this.x(), y);
	}
	
	public default GCompAlt size(Dimension size) {
		return this.size(size.width, size.height);
	}
	
	public default GCompAlt setSize(Dimension size) {
		return this.setSize(size.width, size.height);
	}
	
	public default GCompAlt location(Point p) {
		return this.location(p.x, p.y);
	}
	
	public default GCompAlt setLocation(Point p) {
		return this.setLocation(p.x, p.y);
	}
	
	public default GCompAlt bounds(int x, int y, int width, int height) {
		return this.location(x, y).size(width, height);
	}
	
	public default GCompAlt setBounds(int x, int y, int width, int height) {
		return this.setLocation(x, y).setSize(width, height);
	}
	
	public default GCompAlt bounds(Point p, Dimension size) {
		return this.location(p.x, p.y).size(size.width, size.height);
	}
	
	public default GCompAlt setBounds(Point p, Dimension size) {
		return this.setLocation(p.x, p.y).setSize(size.width, size.height);
	}
	
	public default GCompAlt bounds(Rectangle bounds) {
		return this.location(bounds.x, bounds.y).size(bounds.width, bounds.height);
	}
	
	public default GCompAlt setBounds(Rectangle bounds) {
		return this.setLocation(bounds.x, bounds.y).setSize(bounds.width, bounds.height);
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
	
	public default void render(Graphics g, int parentWidth, int parentHeight) {
		this.renderComponent(g, parentWidth, parentHeight);
		this.renderContainer(g, parentWidth, parentHeight);
	}
	
	public default void renderContainer(Graphics g, int parentWidth, int parentHeight) {
		this.getComponents().forEach((c) -> c.render(g.create(c.x(), c.y(), c.width(), c.height()), parentWidth, parentHeight));
	}
	
	public default void event(GInput input) {
		this.eventComponent(input);
		this.eventComponents(input);
	}
	
	public default void update(float delta) {
		this.updateComponent(delta);
		this.updateComponents(delta);
	}
	
	public default void updateComponents(float delta) {
		for (GCompAlt c : this.getComponents()) {
			c.update(delta);
		}
	}
	
	public default void eventComponents(GInput input) {
		for (GCompAlt c : this.getComponents()) {
			c.event(input);
		}
	}
	
	public default GCompAlt text(String text) {
		this.text().set(text);
		return this;
	}
	
}
