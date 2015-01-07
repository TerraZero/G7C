package TZ.G7.Animation;

import TZ.G7.GObj;
import TZ.G7.Config.GConfig;

/**
 * 
 * @author terrazero
 * @created Jan 5, 2015
 * 
 * @file GControllTransform.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class GTransformControlled extends GObj {

	protected float target;
	protected float speed;
	
	protected float value;
	
	public GTransformControlled() {
		
	}
	
	public GTransformControlled(float target) {
		this.target = target;
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.speed = GConfig.singleton().getFloat("controlled-transform-speed", 1);
	}
	
	public GTransformControlled speed(float speed) {
		this.speed = speed;
		return this;
	}
	
	public GTransformControlled target(float target) {
		this.target = target;
		return this;
	}
	
	public float speed() {
		return this.speed;
	}
	
	public float get() {
		return this.value;
	}
	
	public int getInt() {
		return (int)this.value;
	}
	
	public float target() {
		return this.target;
	}
	
	public int getTarget() {
		return (int)this.target;
	}
	
	public boolean isUp() {
		return this.value == 0;
	}
	
	public boolean isDown() {
		return this.value == this.target;
	}
	
	public boolean updateUp(float delta) {
		this.value += this.speed * delta;
		return this.checkAction(false);
	}
	
	public boolean updateDown(float delta) {
		this.value -= this.speed * delta;
		return this.checkAction(true);
	}
	
	private boolean checkAction(boolean direction) {
		if (direction && 0 > this.value || !direction && this.target < this.value) {
			if (direction) {
				this.value = 0;
			} else {
				this.value = this.target;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[0 <> " + this.value + " <> " + this.target + " (" + this.speed + ")]";
	}
	
}
