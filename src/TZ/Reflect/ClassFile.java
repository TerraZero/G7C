package TZ.Reflect;

/**
 * 
 * @author terrazero
 * @created Feb 12, 2015
 * 
 * @file ClassFile.java
 * @project G7C
 * @identifier TZ.Reflect
 *
 */
public class ClassFile {

	protected String name;
	protected ClassFileType type;
	
	public ClassFile(String name, ClassFileType type) {
		this.name = name;
		this.type = type;
	}
	
	public String name() {
		return this.name;
	}
	
	public ClassFileType type() {
		return this.type;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + " [" + this.type + "]";
	}
	
}

enum ClassFileType {
	
	PACKAGE,
	CLASS,
	
}
