package TZ.Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author terrazero
 * @created Feb 12, 2015
 * 
 * @file Cache.java
 * @project G7C
 * @identifier TZ.Cache
 *
 */
public class Cache<type> {
	
	private static List<Cache<?>> register;
	
	static {
		Cache.register = new ArrayList<Cache<?>>();
	}
	
	public synchronized static void register(Cache<?> c) {
		Cache.register.add(c);
	}
	
	public static void clearAll() {
		Cache.clear("all");
	}
	
	public synchronized static void clear(String name) {
		if (name == "all") {
			for (Cache<?> c : Cache.register) {
				c.clear();
			}
		} else {
			for (Cache<?> c : Cache.register) {
				if (c.name == name) {
					c.clear();
				}
			}
		}
	}

	protected String name;
	protected Map<String, type> cache;
	
	public Cache(String name) {
		Cache.register(this);
		this.name = name;
		this.cache = new HashMap<String, type>();
	}
	
	public boolean is(String name) {
		return this.cache.containsKey(name);
	}
	
	public type get(String name) {
		return this.cache.get(name);
	}
	
	public type cache(String name, type data) {
		return this.cache.put(name, data);
	}
	
	public void clear() {
		this.cache.clear();
	}
	
}
