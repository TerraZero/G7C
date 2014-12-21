package TZ.G7.Animation;

import java.awt.Color;

import TZ.G7.GObj;

/**
 * 
 * @author Terra
 * @created 20.12.2014
 * 
 * @file GColorTransform.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class GColorTransform extends GObj {

	protected GTransform red;
	protected GTransform green;
	protected GTransform blue;
	protected GTransform alpha;
	
	public GColorTransform() {
		
	}

	public GColorTransform(Color color) {
		this.setColor(color);
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.red = new GTransform();
		this.green = new GTransform();
		this.blue = new GTransform();
		this.alpha = new GTransform(255);
	}
	
	public GColorTransform set(Color color) {
		this.red.set(color.getRed());
		this.green.set(color.getGreen());
		this.blue.set(color.getBlue());
		this.alpha.set(color.getAlpha());
		return this;
	}
	
	public GColorTransform set(int red, int green, int blue) {
		this.red.set(red);
		this.green.set(green);
		this.blue.set(blue);
		return this;
	}
	
	public GColorTransform set(int red, int green, int blue, int alpha) {
		this.red.set(red);
		this.green.set(green);
		this.blue.set(blue);
		this.alpha.set(alpha);
		return this;
	}
	
	public GColorTransform setColor(Color color) {
		this.red.value(color.getRed());
		this.green.value(color.getGreen());
		this.blue.value(color.getBlue());
		this.alpha.value(color.getAlpha());
		return this;
	}
	
	public Color get() {
		return new Color(this.red.getInt(), this.green.getInt(), this.blue.getInt(), this.alpha.getInt());
	}
	
	public Color target() {
		return new Color(this.red.getTarget(), this.green.getTarget(), this.blue.getTarget(), this.alpha.getTarget());
	}
	
	public GColorTransform update(float delta) {
		this.red.update(delta);
		this.green.update(delta);
		this.blue.update(delta);
		this.alpha.update(delta);
		return this;
	}
	
	public GColorTransform speed(float speed) {
		this.red.speed(speed);
		this.green.speed(speed);
		this.blue.speed(speed);
		this.alpha.speed(speed);
		return this;
	}
	
	public float speed() {
		return this.red.speed();
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return "[r: " + this.red.toString() + ", g: " + this.green.toString() + ", b: " + this.blue.toString() + ", a: " + this.alpha.toString() + "]";
	}
	
}
