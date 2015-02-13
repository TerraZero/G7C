package TZ.G7.Component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import TZ.G7.GObj;
import TZ.G7.Component.Mechnic.GCompAlt;
import TZ.G7.Data.Unit.GText;
import TZ.G7.Handler.GInput;
import TZ.Mechnic.Mechnic;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file GComponent.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class GComponent extends GObj implements GCompAlt {
	
	protected String component;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected List<GCompAlt> components;
	
	protected GText text;
	protected Color background;
	
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
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.components = Mechnic.get("list");
		this.text = Mechnic.get("gtext");
		this.background = Color.BLACK;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#size(int, int)
	 */
	@Override
	public GCompAlt size(int width, int height) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setSize(int, int)
	 */
	@Override
	public GCompAlt setSize(int width, int height) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#location(int, int)
	 */
	@Override
	public GCompAlt location(int x, int y) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setLocation(int, int)
	 */
	@Override
	public GCompAlt setLocation(int x, int y) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#background(java.awt.Color)
	 */
	@Override
	public GCompAlt background(Color background) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#setBackground(java.awt.Color)
	 */
	@Override
	public GCompAlt setBackground(Color background) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#width()
	 */
	@Override
	public int width() {
		return 0;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#height()
	 */
	@Override
	public int height() {
		return 0;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#x()
	 */
	@Override
	public int x() {
		return 0;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#y()
	 */
	@Override
	public int y() {
		return 0;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#background()
	 */
	@Override
	public Color background() {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#updateComponent(float)
	 */
	@Override
	public void updateComponent(float delta) {
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventComponent(GInput input) {
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#renderComponent(java.awt.Graphics, int, int)
	 */
	@Override
	public void renderComponent(Graphics g, int parentWidth, int parentHeight) {
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#getComponents()
	 */
	@Override
	public List<GCompAlt> getComponents() {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#add(TZ.G7.Component.I.GComp)
	 */
	@Override
	public GCompAlt add(GCompAlt component) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#remove(TZ.G7.Component.I.GComp)
	 */
	@Override
	public GCompAlt remove(GCompAlt component) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#text(TZ.G7.Data.Unit.GText)
	 */
	@Override
	public GCompAlt text(GText text) {
		return null;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#text()
	 */
	@Override
	public GText text() {
		return null;
	}

}
