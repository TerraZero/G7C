package TZ.Strings;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file Strings.java
 * @project G7C
 * @identifier TZ.Strings
 *
 */
public class Strings {

	public static String clearString(String string, String clear) {
		return string.replaceAll(clear, "");
	}
	
	public static int countChar(String s, char c) {
		return s.replaceAll("[^" + c + "]","").length();
	}
	
}
