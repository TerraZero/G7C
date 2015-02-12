package TZ.Reflect;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author terrazero
 * @created Feb 12, 2015
 * 
 * @file ClassQuery.java
 * @project G7C
 * @identifier TZ.Reflect
 *
 */
public class ClassQuery {

	protected String load;
	protected List<ClassFile> cfs;
	
	public ClassQuery(String load) {
		try {
			this.cfs = ClassFileLoader.getLoader().load(load);
		} catch (IOException e) {
			this.exception(e);
		}
	}
	
	protected void exception(Exception e) {
		
	}
	
}
