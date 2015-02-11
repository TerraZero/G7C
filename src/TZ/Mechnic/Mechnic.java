package TZ.Mechnic;

import java.util.HashMap;
import java.util.Map;

import TZ.Mechnic.Test.DefaultTest;

/**
 * 
 * @author Terra
 * @created 11.02.2015
 * 
 * @file Mechnik.java
 * @project G7C
 * @identifier TZ.Mechnic
 *
 */
public class Mechnic {
	
	private static Mechnic singleton;
	
	static {
		Mechnic.singleton = new Mechnic();
	}
	
	public static void register(String name, Object mechnic) {
		Mechnic.singleton.mechnicRegister(name, mechnic);
	}
	
	public static<type> type get(String name) {
		return Mechnic.singleton.mechnicGet(name);
	}

	protected Map<String, Object> mechnics;
	
	public Mechnic() {
		this.mechnics = new HashMap<String, Object>();
		this.init();
	}
	
	protected void init() {
		this.mechnicRegister("test", new DefaultTest());
	}
	
	protected void mechnicRegister(String name, Object mechnic) {
		this.mechnics.put(name, mechnic);
	}
	
	@SuppressWarnings("unchecked")
	protected<type> type mechnicGet(String name) {
		return (type)this.mechnics.get(name);
	}
	
}
