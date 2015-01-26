package TZ.G7.Data.Controller;

import java.util.HashMap;
import java.util.Map;

import TZ.G7.Data.GData;

/**
 * 
 * @author terrazero
 * @created Jan 26, 2015
 * 
 * @file GController.java
 * @project G7C
 * @identifier TZ.G7.Data.Controller
 *
 */
public abstract class GController<data extends GData> {
	
	private static Map<String, GController<?>> controller;
	
	static {
		GController.controller = new HashMap<String, GController<?>>();
	}
	
	@SuppressWarnings("unchecked")
	public static<type extends GController<?>> type get(String name) {
		return (type)GController.controller.get(name);
	}
	
	public static void registry(GController<?> controller) {
		GController.controller.put(controller.name(), controller);
	}

	protected String name;
	
	public GController(String name) {
		this.name = name;
		GController.registry(this);
	}
	
	public String name() {
		return this.name;
	}
	
	public data load(int id) {
		return this.loads(id)[0];
	}
	
	public abstract void save(data data);
	
	public abstract data[] loads(int... ids);
	
}
