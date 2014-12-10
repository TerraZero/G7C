package TZ.G7.Config;

import java.util.HashMap;
import java.util.Map;

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
public class GConfig {
	
	private static Map<String, String> configs;
	
	static {
		GConfig.configs = new HashMap<String, String>();
	}

	public static String get(String name, String fallback) {
		String value = GConfig.configs.get(name);
		return (value == null ? fallback : value);
	}
	
	public static void set(String name, String value) {
		GConfig.configs.put(name, value);
	}
	
}
