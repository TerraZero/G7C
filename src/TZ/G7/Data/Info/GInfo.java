package TZ.G7.Data.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author terrazero
 * @created Jan 26, 2015
 * 
 * @file GInfo.java
 * @project G7C
 * @identifier TZ.G7.Data.Info
 *
 */
public abstract class GInfo {
	
	private static Map<String, GInfo> defines;
	
	static {
		GInfo.defines = new HashMap<String, GInfo>();
	}
	
	public static GInfo get(String name) {
		GInfo info = GInfo.defines.get(name);
		if (info != null && !info.isDefined()) {
			info.define();
		}
		return info;
	}
	
	public static void registry(GInfo info) {
		GInfo.defines.put(info.name(), info);
	}

	protected String name;
	protected boolean defined;
	
	// sql data
	protected String table;
	protected List<String> fields;
	
	public GInfo(String name) {
		this.name = name;
		GInfo.registry(this);
	}
	
	/**
	 * <strong>Call only when needed!</strong><br />
	 * create the info data
	 */
	protected void define() {
		this.fields = new ArrayList<String>();
		this.defineFields(this.fields);
	}
	
	public List<String> fields() {
		return this.fields;
	}
	
	public String table() {
		return this.table;
	}
	
	public String name() {
		return this.name;
	}
	
	public boolean isDefined() {
		return this.defined;
	}
	
	/**
	 * Define the fields for this data
	 * @param fields
	 */
	protected abstract void defineFields(List<String> fields);
	
}
