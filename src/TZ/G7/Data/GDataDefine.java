package TZ.G7.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author terrazero
 * @created Jan 23, 2015
 * 
 * @file GData.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
public abstract class GDataDefine {

	protected String name;
	
	protected String table;
	protected List<String> fields;
	
	public GDataDefine(String name, String table) {
		this.name = name;
		this.table = table;
		this.define();
	}
	
	protected void define() {
		this.fields = new ArrayList<String>();
		
		this.defineFields(this.fields);
	}
	
	protected abstract void defineFields(List<String> fields);
	
}
