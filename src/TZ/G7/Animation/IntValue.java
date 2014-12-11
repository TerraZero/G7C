package TZ.G7.Animation;

import TZ.G7.Config.GConfig;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file IntValue.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class IntValue {

	protected int value;
	protected int target;
	protected int duration;
	protected boolean ani;
	
	public IntValue(int value) {
		this.value = value;
		this.duration = GConfig.singleton().getInt("value-duration", 100);
	}
	
	public IntValue(int value, int target, int duration) {
		this.value = value;
		this.target = target;
		this.ani = true;
		this.duration = duration;
	}
	
	public int value() {
		return this.value;
	}
	
	public IntValue value(int set) {
		this.ani = true;
		this.target = set;
		return this;
	}
	
	public IntValue force(int set) {
		this.value = set;
		return this;
	}
	
	public IntValue duration(int duration) {
		this.duration = duration;
		return this;
	}
	
	public void update(float delta) {
		if (this.ani) {
			if (this.value == target) {
				this.ani = false; 
			} else {
				
			}
		}
	}
	
}
