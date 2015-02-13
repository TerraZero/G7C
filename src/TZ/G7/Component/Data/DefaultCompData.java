package TZ.G7.Component.Data;

import java.awt.Color;

import TZ.G7.Component.I.GCompData;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompData.java
 * @project G7C
 * @identifier TZ.G7.Component.Data
 *
 */
public class DefaultCompData implements GCompData {
	
	protected int x;
	protected int dx;
	protected int y;
	protected int dy;
	protected int width;
	protected int dwidth;
	protected int height;
	protected int dheight;
	protected Color background;
	protected Color dbackground;

	/* 
	 * @see TZ.G7.Component.I.GCompData#size(int, int)
	 */
	@Override
	public GCompData size(int width, int height) {
		this.dwidth = width;
		this.dheight = height;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#setSize(int, int)
	 */
	@Override
	public GCompData setSize(int width, int height) {
		this.width = width;
		this.dwidth = width;
		this.height = height;
		this.dheight = height;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#location(int, int)
	 */
	@Override
	public GCompData location(int x, int y) {
		this.dx = x;
		this.dy = y;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#setLocation(int, int)
	 */
	@Override
	public GCompData setLocation(int x, int y) {
		this.x = x;
		this.dx = x;
		this.y = y;
		this.dy = y;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#width()
	 */
	@Override
	public int width() {
		return this.width;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#height()
	 */
	@Override
	public int height() {
		return this.height;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#x()
	 */
	@Override
	public int x() {
		return this.x;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#y()
	 */
	@Override
	public int y() {
		return this.y;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#dwidth()
	 */
	@Override
	public int dwidth() {
		return this.dwidth;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#dheight()
	 */
	@Override
	public int dheight() {
		return this.dheight;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#dx()
	 */
	@Override
	public int dx() {
		return this.dx;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#dy()
	 */
	@Override
	public int dy() {
		return this.dy;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#background()
	 */
	@Override
	public Color background() {
		return this.background;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#dbackground()
	 */
	@Override
	public Color dbackground() {
		return this.dbackground;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#background(java.awt.Color)
	 */
	@Override
	public GCompData background(Color background) {
		this.dbackground = background;
		return this;
	}

	/* 
	 * @see TZ.G7.Component.I.GCompData#setBackground(java.awt.Color)
	 */
	@Override
	public GCompData setBackground(Color background) {
		this.background = background;
		this.dbackground = background;
		return this;
	}

}
