package TZ.G7.Data;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file GText.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
public class GText extends GObj {

	protected String text;
	
	public GText() {
		
	}
	
	public GText(String text) {
		this.text = text;
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.text = "";
	}
	
	public String get() {
		return this.text;
	}
	
	public GText set(String text) {
		this.text = text;
		return this;
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return this.text;
	}
	
}
