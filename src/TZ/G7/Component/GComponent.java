package TZ.G7.Component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;
import TZ.G7.Component.I.GBackground;
import TZ.G7.Component.I.GComp;

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
public class GComponent extends GObj implements GComp {
	
	protected String component;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected GBackground background;
	protected List<GComp> components;
	
	public GComponent() {
		
	}
	
	public GComponent(String component) {
		this.component = component;
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.component = "Component";
		this.background = new DefaultBackground();
		this.components = new ArrayList<GComp>();
	}
	
	/* 
	 * @see TZ.G7.Component.I.GComp#getComponent()
	 */
	@Override
	public String getComponent() {
		return this.component;
	}

	/* 
	 * @see TZ.G7.I.G7C#setWidth(int)
	 */
	@Override
	public GComp width(int width) {
		this.width = width;
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setHeight(int)
	 */
	@Override
	public GComp height(int height) {
		this.height = height;
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setX(int)
	 */
	@Override
	public GComp x(int x) {
		this.x = x;
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setY(int)
	 */
	@Override
	public GComp y(int y) {
		this.y = y;
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setSize(int, int)
	 */
	@Override
	public GComp size(int width, int height) {
		this.width(width);
		this.height(height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setSize(java.awt.Dimension)
	 */
	@Override
	public GComp size(Dimension size) {
		this.width(size.width);
		this.height(size.height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setLocation(int, int)
	 */
	@Override
	public GComp location(int x, int y) {
		this.x(x);
		this.y(y);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setLocation(java.awt.Point)
	 */
	@Override
	public GComp location(Point p) {
		this.x(p.x);
		this.y(p.y);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setBounds(int, int, int, int)
	 */
	@Override
	public GComp bounds(int x, int y, int width, int height) {
		this.x(x);
		this.y(y);
		this.width(width);
		this.height(height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setBounds(java.awt.Point, java.awt.Dimension)
	 */
	@Override
	public GComp bounds(Point p, Dimension size) {
		this.x(p.x);
		this.y(p.y);
		this.width(size.width);
		this.height(size.height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setBounds(java.awt.Rectangle)
	 */
	@Override
	public GComp bounds(Rectangle bounds) {
		this.x(bounds.x);
		this.y(bounds.y);
		this.width(bounds.width);
		this.height(bounds.height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#getWidth()
	 */
	@Override
	public int width() {
		return this.width;
	}

	/* 
	 * @see TZ.G7.I.G7C#getHeight()
	 */
	@Override
	public int height() {
		return this.height;
	}

	/* 
	 * @see TZ.G7.I.G7C#getX()
	 */
	@Override
	public int x() {
		return this.x;
	}

	/* 
	 * @see TZ.G7.I.G7C#getY()
	 */
	@Override
	public int y() {
		return this.y;
	}

	/* 
	 * @see TZ.G7.I.G7C#getSize()
	 */
	@Override
	public Dimension size() {
		return new Dimension(this.width(), this.height());
	}

	/* 
	 * @see TZ.G7.I.G7C#getLocation()
	 */
	@Override
	public Point location() {
		return new Point(this.x(), this.y());
	}

	/* 
	 * @see TZ.G7.I.G7C#getBounds()
	 */
	@Override
	public Rectangle bounds() {
		return new Rectangle(this.x(), this.y(), this.width(), this.height());
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getComponent() + "[P(" + this.x() + ", " + this.y() + "), S[" + this.width() + ", " + this.height() + "]]";
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#getBackground()
	 */
	@Override
	public GBackground background() {
		return this.background;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setBackground(TZ.G7.Component.I.GBackground)
	 */
	@Override
	public GComp background(GBackground background) {
		this.background = background;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		this.renderComponent(g);
		this.renderContainer(g);
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g) {
		this.background.render(g, this.width, this.height);
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#renderContainer(java.awt.Graphics)
	 */
	@Override
	public void renderContainer(Graphics g) {
		this.components.forEach((c) -> c.render(g.create(c.x(), c.y(), c.width(), c.height())));
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#getComponents()
	 */
	@Override
	public List<GComp> getComponents() {
		return this.components;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#add(TZ.G7.Component.I.GComp)
	 */
	@Override
	public GComp add(GComp component) {
		this.components.add(component);
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#remove(TZ.G7.Component.I.GComp)
	 */
	@Override
	public GComp remove(GComp component) {
		this.components.remove(component);
		return this;
	}

}
