package TZ.G7.Config;

import java.util.HashMap;
import java.util.Map;

import TZ.G7.GObj;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file Config.java
 * @project G7C
 * @identifier TZ.G7.Config
 *
 */
public class GConfig extends GObj {
	
	private static GConfig singleton;
	
	public static GConfig singleton() {
		if (GConfig.singleton == null) {
			GConfig.singleton = new GConfig();
		}
		return GConfig.singleton;
	}
	
	private Map<String, String> configs;
	
	@Override
	protected void init() {
		this.configs = new HashMap<String, String>();
	}
	
	public void initSettings() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			
		} else if (os.contains("mac")) {
			
		} else {
			System.setProperty("sun.java2d.opengl", "true");
		}
	}

	public String get(String name, String fallback) {
		String value = this.configs.get(name);
		return (value == null ? fallback : value);
	}
	
	public int getInt(String name, int fallback) {
		try {
			String value = this.configs.get(name);
			return (value == null ? fallback : Integer.parseInt(value));
		} catch (NumberFormatException e) {
			return fallback;
		}
	}
	
	public void set(String name, String value) {
		this.configs.put(name, value);
	}
	
}
