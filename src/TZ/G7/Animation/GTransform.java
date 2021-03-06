package TZ.G7.Animation;

import TZ.G7.GObj;
import TZ.G7.Annot.ConfigAnnot;
import TZ.G7.Annot.ConfigDefinition;
import TZ.G7.Annot.ConfigItem;
import TZ.G7.Annot.ConfigUse;
import TZ.G7.Config.GConfig;

/**
 * 
 * @author terrazero
 * @created Dec 18, 2014
 * 
 * @file TransformInt.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
@ConfigDefinition({
	@ConfigItem(option = "transform-speed", datatyp = ConfigAnnot.TYPE_FLOAT, data = ConfigAnnot.DATA_SIZE, description = "The transform default speed.", category = "Transform")
})
public class GTransform extends GObj {

	protected float value;
	
	protected float target;
	protected float speed;
	/**
	 * true  : this.target < this.value
	 * false : this.target > this.value
	 */
	protected boolean direction;
	
	public GTransform() {
		
	}
	
	public GTransform(float value) {
		this.value(value);
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	@ConfigUse({
		@ConfigItem(option = "transform-speed", fallback = "1")
	})
	protected void init() {
		super.init();
		this.speed = GConfig.singleton().getFloat("transform-speed", 1);
	}
	
	public GTransform speed(float speed) {
		this.speed = speed;
		this.direction = !(this.speed > 0);
		return this;
	}
	
	public GTransform value(float value) {
		this.value = value;
		this.target = value;
		return this;
	}
	
	public GTransform set(float target) {
		this.target = target;
		this.checkSpeed();
		return this;
	}
	
	private void checkSpeed() {
		boolean newDirection = this.target < this.value; 
		if (newDirection != this.direction) this.speed = -this.speed;
		this.direction = newDirection;
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
	
	public float speed() {
		return this.speed;
	}
	
	public boolean isTarget() {
		return this.target == this.value;
	}
	
	public void update(float delta) {
		if (this.target != this.value) {
			this.value += this.speed * delta;
			if (this.direction && this.target > this.value || !this.direction && this.target < this.value) this.value = this.target;
		}
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.value + " -> " + this.target + " (" + this.speed + ")]";
	}
	
}
