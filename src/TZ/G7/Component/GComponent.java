package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;
import TZ.G7.Animation.GColorTransform;
import TZ.G7.Animation.GTransform;
import TZ.G7.Component.I.GComp;
import TZ.G7.Data.GText;
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
public class GComponent extends GObj implements GComp {
	
	protected String component;
	
	protected GTransform x;
	protected GTransform y;
	protected GTransform width;
	protected GTransform height;
	
	protected List<GComp> components;
	
	protected GText text;
	
	protected GColorTransform background;
	
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
		this.x = new GTransform();
		this.y = new GTransform();
		this.width = new GTransform();
		this.height = new GTransform();
		this.background = new GColorTransform();
		this.text = new GText();
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
	 * @see TZ.G7.I.G7C#setSize(int, int)
	 */
	@Override
	public GComp size(int width, int height) {
		this.width.set(width);
		this.height.set(height);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#setLocation(int, int)
	 */
	@Override
	public GComp location(int x, int y) {
		this.x.set(x);
		this.y.set(y);
		return this;
	}
	
	/* 
	 * @see TZ.G7.Component.I.GComp#setSize(int, int)
	 */
	@Override
	public GComp setSize(int width, int height) {
		this.width.value(width);
		this.height.value(height);
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setLocation(int, int)
	 */
	@Override
	public GComp setLocation(int x, int y) {
		this.x.value(x);
		this.y.value(y);
		return this;
	}
	
	/* 
	 * @see TZ.G7.Component.I.GComp#background(java.awt.Color)
	 */
	@Override
	public GComp background(Color background) {
		this.background.set(background);
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setBackground(java.awt.Color)
	 */
	@Override
	public GComp setBackground(Color background) {
		this.background.setColor(background);
		return this;
	}

	/* 
	 * @see TZ.G7.I.G7C#getWidth()
	 */
	@Override
	public int width() {
		return this.width.getInt();
	}

	/* 
	 * @see TZ.G7.I.G7C#getHeight()
	 */
	@Override
	public int height() {
		return this.height.getInt();
	}

	/* 
	 * @see TZ.G7.I.G7C#getX()
	 */
	@Override
	public int x() {
		return this.x.getInt();
	}

	/* 
	 * @see TZ.G7.I.G7C#getY()
	 */
	@Override
	public int y() {
		return this.y.getInt();
	}
	
	/* 
	 * @see TZ.G7.Component.I.GComp#background()
	 */
	@Override
	public Color background() {
		return this.background.get();
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getComponent() + "[P(" + this.x() + ", " + this.y() + "), S[" + this.width() + ", " + this.height() + "], " + "\"" + this.text + "\"" + "]";
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
	
	/* 
	 * @see TZ.G7.Component.I.GComp#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
		this.width.update(delta);
		this.height.update(delta);
		this.x.update(delta);
		this.y.update(delta);
		this.background.update(delta);
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
		
	}
	
	/* 
	 * @see TZ.G7.Component.I.GComp#renderComponent(java.awt.Graphics)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
		g.setColor(this.background.get());
		g.fillRect(0, 0, this.width(), this.height());
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#text(TZ.G7.Data.GText)
	 */
	@Override
	public GComp text(GText text) {
		this.text = text;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#text()
	 */
	@Override
	public GText text() {
		return this.text;
	}

}
