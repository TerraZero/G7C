package TZ.Array;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file Strings.java
 * @project G7C
 * @identifier TZ.Array
 *
 */
public class Strings {

	public static boolean isIntern(String search, String... array) {
		for (int i = 0; i < array.length; i++) {
			if (Base.is(array[i], search)) return true;
		}
		return false;
	}
	
}
