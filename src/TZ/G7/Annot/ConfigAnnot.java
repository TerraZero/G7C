package TZ.G7.Annot;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file ConfigAnnot.java
 * @project G7C
 * @identifier TZ.G7.Annot
 *
 */
public class ConfigAnnot {

	public static final String NONE = "[NONE]";
	
	public static final String DATA_LIST = "{LIST}";
	public static final String DATA_COLOR = "{COLOR}";
	public static final String DATA_SIZE = "{SIZE}";
	public static final String DATA_SPEED = "{SPEED}";
	
	public static final String TYPE_STRING = "(STRING)";
	public static final String TYPE_INT = "(INT)";
	public static final String TYPE_FLOAT = "(FLOAT)";
	
	
	
	public static boolean isNone(String input) {
		return input == null || input.equals(ConfigAnnot.NONE);
	}
	
	public static boolean isData(String input) {
		return input.startsWith("{") && input.endsWith("}");
	}
	
	public static boolean isType(String input) {
		return input.startsWith("(") && input.endsWith(")");
	}
	
	public static String getData(String input) {
		return input.substring(1, input.length() - 1).toLowerCase();
	}
	
	public static String data(String input) {
		if (ConfigAnnot.isData(input)) {
			return ConfigAnnot.getData(input);
		}
		return null;
	}
	
	public static String getType(String input) {
		return input.substring(1, input.length() - 1).toLowerCase();
	}
	
	public static String type(String input) {
		if (ConfigAnnot.isType(input)) {
			return ConfigAnnot.getType(input);
		}
		return null;
	}
	
}
