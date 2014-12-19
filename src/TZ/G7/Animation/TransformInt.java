package TZ.G7.Animation;

import TZ.G7.GObj;
import TZ.G7.Annot.ConfigDefinition;
import TZ.G7.Annot.ConfigItem;

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
	
})
public class TransformInt extends GObj {

	protected int value;
	protected int target;
	protected float speed;
	
	public TransformInt() {
		
	}
	
	public TransformInt(int value) {
		this.value = value;
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		
	}
	
}
