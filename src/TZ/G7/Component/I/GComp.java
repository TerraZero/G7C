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
	
	public String getComponent();

	public GComp width(int width);
	
	public GComp height(int height);
	
	public GComp x(int x);
	
	public GComp y(int y);
	
	public GComp size(int width, int height);
	
	public GComp size(Dimension size);
	
	public GComp location(int x, int y);
	
	public GComp location(Point p);
	
	public GComp bounds(int x, int y, int width, int height);
	
	public GComp bounds(Point p, Dimension size);
	
	public GComp bounds(Rectangle bounds);
	
	public int width();
	
	public int height();
	
	public int x();
	
	public int y();
	
	public Dimension size();
	
	public Point location();
	
	public Rectangle bounds();
	
	public void render(Graphics g);
	
	public void renderComponent(Graphics g);
	
	public void renderContainer(Graphics g);
	
	public List<GComp> getComponents();
	
	public GComp add(GComp component);
	
	public GComp remove(GComp component);
	
}
