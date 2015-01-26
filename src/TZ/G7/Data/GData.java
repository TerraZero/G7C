package TZ.G7.Data;

/**
 * 
 * @author terrazero
 * @created Jan 26, 2015
 * 
 * @file GData.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
public class GData {

	protected int id;
	protected int originalID;
	
	public GData() {
		this.id = -1;
	}
	
	public GData(int id) {
		this.id = id;
	}
	
	public GData id(int id) {
		this.id = id;
		return this;
	}
	
	public int id() {
		return this.id;
	}
	
}
