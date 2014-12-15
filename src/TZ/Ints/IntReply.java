package TZ.Ints;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file IntSetting.java
 * @project G7C
 * @identifier TZ.Ints
 *
 */
public class IntReply {
	
	public static final int IS_NULL = Ints.setBit(0, 0, true);
	public static final int IS_TRUE = Ints.setBit(0, 1, true);
	public static final int IS_FALSE = Ints.setBit(0, 2, true);

	protected int reply;
	
	public IntReply(int reply) {
		this.reply = reply;
	}
	
	public int reply() {
		return this.reply;
	}
	
	public void set(int reply) {
		this.reply = reply;
	}
	
	public boolean get(int pos) {
		return Ints.isBit(this.reply, pos);
	}
	
	public void set(int pos, boolean set) {
		this.reply = Ints.setBit(this.reply, pos, set);
	}
	
	public boolean isNull() {
		return this.get(0);
	}
	
	public boolean isTrue() {
		return this.get(1);
	}
	
	public boolean isFalse() {
		return this.get(2);
	}
	
}
