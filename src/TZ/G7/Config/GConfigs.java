package TZ.G7.Config;

import java.util.HashMap;
import java.util.Map;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Jan 5, 2015
 * 
 * @file GConfigs.java
 * @project G7C
 * @identifier TZ.G7.Config
 *
 */
public class GConfigs extends GObj {
	
	private static GConfigs singleton;
	
	public static GConfigs singleton() {
		if (GConfigs.singleton == null) {
			GConfigs.singleton = new GConfigs();
		}
		return GConfigs.singleton;
	}

	private Map<String, GConfigItem> items;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.items = new HashMap<String, GConfigItem>();
		this.initItems();
	}
	
	protected void initItems() {
		this.add(new GConfigItem("exception-message", "user"));
		
		this.add(new GConfigItem("transform-speed", "1"));
		this.add(new GConfigItem("color-transform-speed", "transform-speed", "1"));
		
		// set development defaults
		this.set("exception-message", "dev");
	}
	
	public void add(GConfigItem item) {
		this.items.put(item.name(), item);
	}
	
	public GConfigItem get(String name) {
		GConfigItem start = this.items.get(name);
		if (start == null) return null;
			
		GConfigItem item = start;
		while (item != null && item.value() == null) {
			item = this.items.get(item.extended());
		}
		return (item == null ? start : item);
	}
	
	public GConfigs set(String name, String value) {
		this.getItem(name).set(value);
		return this;
	}
	
	public GConfigItem getItem(String name) {
		return this.items.get(name);
	}
	
}
