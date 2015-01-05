package TZ.G7.Config;

/**
 * 
 * @author terrazero
 * @created Jan 5, 2015
 * 
 * @file GConfigItem.java
 * @project G7C
 * @identifier TZ.G7.Config
 *
 */
public class GConfigItem {

	protected String name;
	protected String extended;
	protected String fallback;
	
	protected String value;
	
	public GConfigItem(String name, String fallback) {
		this.name = name;
		this.fallback = fallback;
	}
	
	public GConfigItem(String name, String extended, String fallback) {
		this.name = name;
		this.extended = extended;
		this.fallback = fallback;
	}

	public String name() {
		return this.name;
	}
	
	public String extended() {
		return this.extended;
	}
	
	public String fallback() {
		return this.fallback;
	}
	
	public String value() {
		return this.value;
	}
	
	public GConfigItem set(String value) {
		this.value = value;
		return this;
	}
	
	public String get() {
		return (this.value == null ? this.fallback : this.value);
	}
	
	public String get(String fallback) {
		return (this.value == null ? fallback : this.value);
	}
	
	public int getInt(int fallback) {
		try {
			return (this.value == null ? fallback : Integer.parseInt(this.value));
		} catch (NumberFormatException e) {
			return fallback;
		}
	}
	
	public float getFloat(float fallback) {
		try {
			return (this.value == null ? fallback : Float.parseFloat(this.value));
		} catch (NumberFormatException e) {
			return fallback;
		}
	}
	
}
